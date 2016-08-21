package pipes;

import java.io.EOFException;
import java.util.ArrayList;

public class Pipe {
	private ArrayList<String> data;
	private boolean isClosed;

	public Pipe(){
		System.out.println("pipe created");
		data = new ArrayList<String>();
		isClosed = false;
	}

	public void write(String s){
		if(isClosed){
			return;
		}
		else{
			data.add(s);
		}
	}

	public String read() throws EOFException {
		while(true){
			if(data.isEmpty()){
				if(isClosed){
					throw new EOFException();
				}
				try{
					Thread.sleep(10);
				}catch (InterruptedException e){
					System.out.println("The thread is interrupted");
				}
			}
			else{
				return data.remove(0);
			}
		}
	}
	
	public void close(){
		isClosed = true;
	}
}

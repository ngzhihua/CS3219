package filters;
import java.io.EOFException;

import pipes.Pipe;

public abstract class Filter implements Runnable{
	private Pipe in, out;
	public Filter(){
		System.out.println("Filter created"); //for debug
	}
	public void setInput(Pipe p){
		in=p;
	}
	public void setOutput(Pipe p){
		out=p;
	}
	
	public void write(String s){
		if(s == null){
			out.close();
		}
		else{
			out.write(s);
		}
	}
	
	public String read() throws EOFException{
		return in.read();
	}

}

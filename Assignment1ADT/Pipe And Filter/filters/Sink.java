package filters;

import java.io.EOFException;
import java.util.List;

public class Sink extends Filter{

	@Override
	public void run(){
		List<String> output = readWord();
		System.out.println("Output:");
		for(String s:output){
			System.out.println(s);
		}
	}
}

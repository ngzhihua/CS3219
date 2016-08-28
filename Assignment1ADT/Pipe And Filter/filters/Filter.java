package filters;

import java.util.List;
import pipes.Pipe;
/*
Author: Duan Xuzhou*/
public abstract class Filter implements Runnable{
	protected Pipe in, out;

	public void setInput(Pipe input){
		in=input;
	}

	public void setOutput(Pipe output){
		out=output;
	}

	public List<String> readWord(){
		if(in.readWordList()==null){
			System.out.println("no text to read!");
		}
		return in.readWordList();
	}

	public List<String> readIgnoreWord(){
		if(in.readIgnoreWord()==null){
			System.out.println("no ignore words to read!");
		}
		return in.readIgnoreWord();
	}

	public void writeIgnoreWord(List<String> output){
		if(output.isEmpty()){
			System.out.println("empty ignore word list to write!");
		}
		out.writeIgnoreWord(output);
	}
	
	public void passIgnoreWord(){
		List<String> output=readIgnoreWord();
		writeIgnoreWord(output);
	}

	public void writeWord(List<String> output){
		if(output.isEmpty()){
			System.out.println("empty word list to write!");
		}
		out.writeWordList(output);
	}
}

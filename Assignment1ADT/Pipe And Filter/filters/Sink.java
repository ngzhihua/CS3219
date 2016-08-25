package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Sink extends Filter{

	@Override
	public void run(){
		List<String> output = readWord();
		try {
			writeOutputToFile(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeOutputToFile(List<String> output) throws IOException{
		PrintWriter pw = new PrintWriter("out.txt");
		System.out.println("Output:");
		for (String sentence: output){
			pw.println(sentence);
			System.out.println(sentence);
		}
		
		pw.close();
	}
}

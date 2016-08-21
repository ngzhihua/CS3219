import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ADTOutput {
	private ArrayList<String> kwic;
	
	public ADTOutput(ArrayList<String> kwic){
		this.kwic = kwic;
	}
	
	public void print() throws IOException{
		PrintWriter pw = new PrintWriter("out.txt");
		for (String sentence: kwic){
			pw.println(sentence);
			System.out.println(sentence);
		}
		
		pw.close();
	}
}

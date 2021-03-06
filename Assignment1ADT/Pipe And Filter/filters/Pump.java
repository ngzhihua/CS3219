package filters;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*
Author: Duan Xuzhou
The pump takes in input from the user and format it into the data structure specified in the architecture design
*/
public class Pump extends Filter {
	private Scanner sc;
	private String linesFileName,ignoreFileName;

	public Pump(){
		linesFileName = new String();
		ignoreFileName = new String();
		sc = new Scanner(System.in);
	}

	@Override
	public void run(){
		try{
			readInput();
			List<String> inputWordlist= getAllWordlist();
			List<String> ignoreWordlist= getAllIgnoreWordlist();

			ignoreWordFormatting(ignoreWordlist);
			inputWordFormatting(inputWordlist, ignoreWordlist);

			writeWord(inputWordlist);
			writeIgnoreWord(ignoreWordlist);

		}catch(IOException e ){
			System.out.println("File cannot be found, please try again.");
			run();
		}
	}

	private void readInput() {
		System.out.println("Please enter the file name for input lines: ");
		if (sc.hasNext()){
			linesFileName = sc.nextLine();
		}
		System.out.println("Please enter the file name for words to ignore: ");
		if (sc.hasNext()){
			ignoreFileName = sc.nextLine();
		}
	}

	private List<String> getAllWordlist() throws IOException{
		List<String> allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + linesFileName));
		return allLines;
	}

	private List<String> getAllIgnoreWordlist() throws IOException{
		List<String> allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + ignoreFileName));
		return allLines;
	}

	private void inputWordFormatting(List<String> inputWordlist, List<String> ignoreWordlist){
		for(int i=0;i<inputWordlist.size();i++){
			String temp=(inputWordlist.get(i)).toLowerCase();
			String[] token=temp.split("\\s");
			String replacement=new String();
			for(int j=0;j<token.length;j++){
				if(!(ignoreWordlist.contains(token[j]))){
					String temp2=(token[j].substring(0, 1)).toUpperCase()+token[j].substring(1);
					replacement+=temp2;
					replacement+=" ";
				}
				else{
					replacement+=token[j];
					replacement+=" ";
				}
			}
			inputWordlist.set(i, replacement);
		}
	}

	private void ignoreWordFormatting(List<String> ignoreWordlist){
		for(int i=0;i<ignoreWordlist.size();i++){
			String temp=(ignoreWordlist.get(i)).toLowerCase();
			ignoreWordlist.set(i, temp);
		}
	}

}

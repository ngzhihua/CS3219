package filters;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

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
			System.out.println("Welcome to the KWIC");
			System.out.println("Please enter the file name for Lines: ");
			if (sc.hasNext()){
				linesFileName = sc.nextLine();
			}
			System.out.println("Please enter the file name for Words to Ignore: ");
			if (sc.hasNext()){
				ignoreFileName = sc.nextLine();
			}
			List<String> inputWordlist= getAllWordlist();
			List<String> ignoreWordlist= getAllIgnoreWordlist();
			
			writeWord(inputWordlist);
			writeIgnoreWord(ignoreWordlist);

		}catch(Exception e){
			System.out.println("error reading input");
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
	
}

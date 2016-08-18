import java.io.File;
import java.util.Scanner;

public class ADTController {
	
	public ADTController(){
		
	}
	
	public void run(){
		
		String linesFileName = "";
		String ignoreFileName = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the file name for Lines: ");
		if (sc.hasNext()){
			linesFileName = sc.nextLine();
		}
		System.out.println("Please enter the file name for Words to Ignore: ");
		if (sc.hasNext()){
			ignoreFileName = sc.nextLine();
		}
		
		if (checkFileExists(linesFileName)){
			if (checkFileExists(ignoreFileName)){
				ADTInput adtInput = new ADTInput(linesFileName, ignoreFileName);
			}
		}
		
		
		sc.close();
	}
	
	private boolean checkFileExists(String fileName){
		File file = new File(fileName);
		if (file.exists()){
			if (!file.isDirectory()){
				return true;
			}
			
		}
		return false;
	}
}

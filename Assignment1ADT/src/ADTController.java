import java.io.File;
import java.io.IOException;
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
		
		
		ADTInput adtInput = new ADTInput(linesFileName, ignoreFileName);
		try{
			ADTCharacters adtCharacters = new ADTCharacters(adtInput.getAllLines(), adtInput.getWordsToIgnore());
			adtCharacters.setChar();
			ADTCircularShift adtCircularShift = new ADTCircularShift(adtCharacters.getLines(), adtCharacters.getWordsToIgnore());
			adtCircularShift.shift();
			ADTAlphabeticShifts adtAlphabeticShifts = new ADTAlphabeticShifts(adtCharacters.getLines(), adtCircularShift.getShiftedIndex());
			adtAlphabeticShifts.alphabetize();
			System.out.print(adtAlphabeticShifts.getKWIC());
		}
		catch(IOException ex){
			System.out.println("File cannot be found, please restart program and specify another file name");
		}
		finally{
			System.exit(0);
		}
		
		
		
		sc.close();
	}
	
//	private boolean checkFileExists(String fileName){
//		File file = new File(fileName);
//		if (file.exists()){
//			if (!file.isDirectory()){
//				return true;
//			}
//			
//		}
//		return false;
//	}
}

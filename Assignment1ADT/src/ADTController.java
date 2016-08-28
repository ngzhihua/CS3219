/**
 * 
 * @author Ng Zhi Hua
 *
 */

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
		System.out.println("Please enter the file name for input lines: ");
		if (sc.hasNext()){
			linesFileName = sc.nextLine();
		}
		System.out.println("Please enter the file name for words to Ignore: ");
		if (sc.hasNext()){
			ignoreFileName = sc.nextLine();
		}
		
		
		ADTInput adtInput = new ADTInput(linesFileName, ignoreFileName);
		try{
			ADTCharacters adtCharacters = new ADTCharacters(adtInput.getAllLines(), adtInput.getWordsToIgnore());
			adtCharacters.setChar();
			ADTCircularShift adtCircularShift = new ADTCircularShift(adtCharacters.getLines(), adtCharacters.getWordsToIgnore());
			adtCircularShift.shift();
			ADTAlphabeticShifts adtAlphabeticShifts = new ADTAlphabeticShifts(adtCharacters.getLines(), adtCircularShift.getShiftedIndex(), adtCharacters.getWordsToIgnore());
			adtAlphabeticShifts.alphabetize();
			ADTOutput adtOutput = new ADTOutput(adtAlphabeticShifts.getKWIC());
			adtOutput.print();
		}
		catch(IOException ex){
			System.out.println("File cannot be found, please try again.");
			run();
		}
		
		sc.close();
	}
}
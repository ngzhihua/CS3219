/**
 * 
 * @author Ng Zhi Hua
 *
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ADTInput {
	
	private String lineFileName;
	private String wordsToIgnoreFileName;
	
	public ADTInput(String lineFileName, String wordsToIgnoreFileName){
		this.lineFileName = lineFileName;
		this.wordsToIgnoreFileName = wordsToIgnoreFileName;
	}
	
	public List<String> getAllLines() throws IOException{
		List<String> allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + lineFileName));

		return allLines;
	}
	
	public List<String> getWordsToIgnore() throws IOException{
		
		List<String> wordsToIgnore = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "\\" + wordsToIgnoreFileName));
		
		return wordsToIgnore;
	}
}
import java.util.ArrayList;
import java.util.Collections;

public class ADTAlphabeticShifts {
	
	private ArrayList<ArrayList<String>> lines;
	private ArrayList<IntegerPair> shiftedIndex;
	private ArrayList<String> kwic;
	
	public ADTAlphabeticShifts(ArrayList<ArrayList<String>> lines, ArrayList<IntegerPair> shiftedIndex){
		this.lines = lines;
		this.shiftedIndex = shiftedIndex;
	}
	
	//This function converts shifted indices into words, sort them alphabetically and capitalizes the first character
	public void alphabetize(){
		ArrayList<String> kwic = new ArrayList<String>();
		
		for (IntegerPair index: shiftedIndex){
			Integer row = index.getRow();
			Integer word = index.getWord();
			Integer rowSize = lines.get(row).size();
			String sentence = new String(lines.get(row).get(word));
			Integer wordIndex = word + 1;
			while (wordIndex % rowSize != word){
				sentence = sentence + " " + lines.get(row).get(wordIndex % rowSize);
				wordIndex ++;
			}
			kwic.add(capitalizeFirstCharacter(sentence));
		}
		
		Collections.sort(kwic);
		this.kwic = kwic;
	}
	
	public ArrayList<String> getKWIC(){
		return this.kwic;
	}
	
	private String capitalizeFirstCharacter(String sentence){
		Integer sentenceLength = sentence.length();
		String initialChar = sentence.substring(0, 1);
		initialChar = initialChar.toUpperCase();
		sentence = initialChar + sentence.substring(1, sentenceLength);
		
		return sentence;
	}
}
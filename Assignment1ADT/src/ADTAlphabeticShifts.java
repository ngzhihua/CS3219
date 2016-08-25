import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ADTAlphabeticShifts implements ADTAlphabeticShiftsInterface{
	
	private ArrayList<ArrayList<String>> lines;
	private ArrayList<IntegerPair> shiftedIndex;
	private List<String> wordsToIgnore;
	private ArrayList<String> kwic;
	
	public ADTAlphabeticShifts(ArrayList<ArrayList<String>> lines, ArrayList<IntegerPair> shiftedIndex, List<String> wordsToIgnore){
		this.lines = lines;
		this.shiftedIndex = shiftedIndex;
		this.wordsToIgnore = wordsToIgnore;
	}
	
	// This function converts words to ignore in lines to lower case
	private void convertWordsToIgnoreToLower(){
		for (int i = 0; i < lines.size(); i++){
			for (int j = 0; j < lines.get(i).size(); j++){
				for (int k = 0; k < wordsToIgnore.size(); k++){
					if (lines.get(i).get(j).toLowerCase().equals(wordsToIgnore.get(k).toLowerCase())){
						String lowerCaseWordToIgnore = lines.get(i).remove(j).toLowerCase();
						lines.get(i).add(j, lowerCaseWordToIgnore);
					}
				}
			}
		}
	}
	
	//This function converts shifted indices into words, sort them alphabetically and capitalizes the first character
	public void alphabetize(){
		convertWordsToIgnoreToLower();
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
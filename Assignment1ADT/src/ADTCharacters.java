import java.util.List;
import java.util.ArrayList;

public class ADTCharacters {
	private List<String> lines;
	private List<String> wordsToIgnore;
	private ArrayList<ArrayList<String>> storage;
	
	public ADTCharacters(List<String> lines, List<String> wordsToIgnore){
		this.lines = lines;
		this.wordsToIgnore = wordsToIgnore;
	}
	
	//This function breaks up the string into a 2d array 
	public void setChar(){
		this.storage = new ArrayList<ArrayList<String>>();
		for (String line: this.lines){
			ArrayList<String> lineWords = new ArrayList<String>();
			String[] words = line.split(" ");
			for (int i = 0 ; i < words.length; i++){
				lineWords.add(words[i]);
			}
			storage.add(lineWords);
		}
	}
	
	public ArrayList<ArrayList<String>> getLines(){
		return this.storage;
	}
	
	
	public List<String> getWordsToIgnore(){
		return this.wordsToIgnore;
	}
	
	
//	public int getNumOfLines(){
//		return this.storage.size();
//	}
//	
//	public int getNumOfWords(int index){
//		return this.storage.get(index).size();
//	}
//
//	public int getNumOfWordsToIgnore(){
//		return this.wordsToIgnore.size();
//	}
//	
//	public String getWordToIgnore(int index){
//		return this.wordsToIgnore.get(index);
//	}
	
	
}

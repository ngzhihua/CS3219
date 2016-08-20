import java.util.ArrayList;
import java.util.List;

public class ADTCircularShift {
	private ArrayList<ArrayList<String>> lines;
	private List<String> wordsToIgnore;
	private ArrayList<IntegerPair> shiftedIndex = new ArrayList<IntegerPair>();
	
	public ADTCircularShift(ArrayList<ArrayList<String>> lines, List<String> wordsToIgnore){
		this.lines = lines;
		this.wordsToIgnore = wordsToIgnore;
	}
	
	public void shift(){
		for (int i = 0 ; i < lines.size(); i++){
			for (int j = 0; j < lines.get(i).size(); j++){
				boolean toIgnore = false;
				for (int k = 0 ; k < wordsToIgnore.size(); k++){
					if (lines.get(i).get(j).toLowerCase().equals(wordsToIgnore.get(k).toLowerCase())){
						toIgnore = true;
						break;
					}
				}
				if (!toIgnore){
					shiftedIndex.add(new IntegerPair(i, j));				
				}
				else{
					toIgnore = false;
				}
			}
		}
	}
	
	public ArrayList<IntegerPair> getShiftedIndex(){
		return this.shiftedIndex;
	}
	
}

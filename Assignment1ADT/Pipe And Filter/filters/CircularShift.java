package filters;

import java.util.LinkedList;
import java.util.List;

public class CircularShift extends Filter{

	@Override
	public void run(){
		List<String> wordlist= readWord();		
		passIgnoreWord();
		wordlist=getAllCircularShift(wordlist);
		writeWord(wordlist);
	}
	
	private List<String> getAllCircularShift(List<String> input){
		List<String> output = new LinkedList<String>();
		for(int i=0;i<input.size();i++){
			String token[]=(input.get(i)).split("\\s");
			for(int j=0;j<token.length;j++){
				String temp=new String();
				for(int k=0;k<token.length;k++){
					temp+=(token[k]);
					temp+=(" ");
				}
				output.add(temp);
				circulateLeft(token);
			}
		}
		return output;
	}

	private void circulateLeft(String[] data){
		String temp = data[0];
		for(int i=0;i<data.length-1;i++){
			data[i]=data[i+1];
		}
		data[data.length-1]=temp;
	}

}

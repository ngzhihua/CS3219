package filters;

import java.util.LinkedList;
import java.util.List;

public class IgnoreWordRemoval extends Filter{
	
	@Override
	public void run(){
		List<String> wordlist= readWord();
		List<String> ignorelist= readIgnoreWord();
		wordlist=ignoreWordFilterer(wordlist, ignorelist);
		writeWord(wordlist);
	}
	private List<String> ignoreWordFilterer(List<String> wordlist,List<String> ignorelist){
		List<String>output=new LinkedList<String>();
		for(int i=0;i<wordlist.size();i++){
			String[]token=(wordlist.get(i)).split("\\s");
			if(!(ignorelist.contains(token[0].toLowerCase()))){
				output.add(wordlist.get(i));
			}
		}	
		return output;
	}

}

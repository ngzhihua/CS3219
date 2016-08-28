package filters;

import java.util.Collections;
import java.util.List;
/*
Author: Duan Xuzhou
The AlphabeticalSort uses collection.sort to sort in alphabetical order
*/
public class AlphabeticalSort extends Filter{
	@Override
	public void run(){
		List<String> wordlist=readWord();
		Collections.sort(wordlist);
		writeWord(wordlist);
	}
}

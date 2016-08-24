package filters;

import java.util.Collections;
import java.util.List;

public class AlphabeticalSort extends Filter{
	@Override
	public void run(){
		List<String> wordlist=readWord();
		Collections.sort(wordlist);
		writeWord(wordlist);
	}
}

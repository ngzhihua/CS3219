package main;
import filters.AlphabeticalSort;
import filters.CircularShift;
import filters.Filter;
import filters.FilterWrapper;
import filters.IgnoreWordRemoval;
import filters.Pump;
import filters.Sink;

public class KWIC_Pipe_Filter {

	public static void main(String[] args) {
		// This is the driver class, to start the KWIC

		Filter[] filters={new Pump(), new CircularShift(), new IgnoreWordRemoval(),new AlphabeticalSort(),new Sink()};
		
		(new FilterWrapper(filters)).run();

	}

}

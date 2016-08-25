import java.util.Scanner;
import filters.AlphabeticalSort;
import filters.CircularShift;
import filters.Filter;
import filters.FilterWrapper;
import filters.IgnoreWordRemoval;
import filters.Pump;
import filters.Sink;

public class Controller {
	public static void main(String[] args){
		while(true){
			System.out.println("Please select from the following architectures (Enter their number):");
			System.out.println("1. Abstract Data Type");
			System.out.println("2. Pipes and Filters");
			System.out.println("3. Exit");

			Scanner sc = new Scanner(System.in);
			Integer architectureNumber = 0;
			if (sc.hasNextInt()){
				architectureNumber = sc.nextInt();
			}

			if (architectureNumber == 1){
				ADTController adtController = new ADTController();
				adtController.run();
				break;
			}
			else if (architectureNumber == 2){
				//Call pipe and filter
				Filter[] filters={new Pump(), new CircularShift(), new IgnoreWordRemoval(),new AlphabeticalSort(),new Sink()};			
				(new FilterWrapper(filters)).run();
				break;
			}
			else if (architectureNumber == 3){
				System.exit(0);
			}
			else{
				System.out.println("Invalid Selection, please try again.\n");
			}
		}

	}
}

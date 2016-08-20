import java.util.Scanner;

public class Controller {
	public static void main(String[] args){
		
		System.out.println("Please select from the following architectures: (Enter their number)");
		System.out.println("1. Abstract Data Type");
		System.out.println("2. Pipes and Filters");
		
		Scanner sc = new Scanner(System.in);
		Integer architectureNumber = 0;
		if (sc.hasNext()){
			architectureNumber = sc.nextInt();
		}
		
		if (architectureNumber == 1){
			ADTController adtController = new ADTController();
			adtController.run();
		}
		else if (architectureNumber == 2){
			//Call pipe and filter
		}
		else{
			//Prompt input again
		}
		
	}
}

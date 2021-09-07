import java.util.Scanner;
public class CelsiusConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter celsius value:");
		float celsius = scanner.nextFloat();
		double fahrenheit = ( celsius * 1.8 ) + 32f;
		System.out.println("Converted value ="+ fahrenheit);
		scanner.close();
	}

}

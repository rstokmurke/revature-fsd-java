import java.util.Scanner;

public class MinutesExtract {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter time in HH:MM:SS format");
		String name = scanner.nextLine();
		
		System.out.println("minutes="+ name.substring(3, 5));
		scanner.close();
	}
}

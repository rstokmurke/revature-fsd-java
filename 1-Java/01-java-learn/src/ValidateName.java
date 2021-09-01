import java.util.Scanner;
public class ValidateName {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Short Name:");
		String name = scanner.nextLine();
		
		if (name.length() <= 6 && name.length() >=2) {
		
		 System.out.println("This is a valid short name");
		} else {
			System.out.println("This is not Web URL");
		}	
	}
}



import java.util.Scanner;

public class Displayloop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		if (option < 4) {
			while (option < 4) {
				System.out.println("Menu");
				System.out.println("====");
				System.out.println("1. Balance Enquiry");
				System.out.println("2. Recharge");
				System.out.println("3. Change caller tune");
				System.out.println("4. Exit");

				Scanner sc = new Scanner(System.in);

				System.out.println("Choose an Option");
				option = sc.nextInt();

				switch (option) {
				case 1:
					System.out.println("Balance Enquiry");
					break;
				case 2:
					System.out.println("2. Recharge");
					break;
				case 3:
					System.out.println("3. Change caller tune");
					break;
				}
			}

		} else if (option == 4) {
			System.out.println("4. Exit");
		}
		else if(option>4) {
			System.out.println("You have entered a wrong input");
		}
	}

}
import java.util.Scanner;
public class ProfitCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int buyingPrice = scanner.nextInt();
		int sellingPrice =scanner.nextInt();
		int profit = sellingPrice - buyingPrice;
		
		System.out.println("Profit =" + profit);

	}

}

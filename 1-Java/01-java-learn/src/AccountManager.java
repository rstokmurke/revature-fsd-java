
public class AccountManager {

	public static void main(String[] args) {
		String accountNumber = "01302343794";
		double balance = 5000.0;
		
		System.out.println("Account Statement of " + accountNumber);
		System.out.println("Initial Balance " + balance);
		
		System.out.println("\n---------------------------");
		System.out.println("Type  Transactions  Balance");
		System.out.println("---------------------------");
		
		/*char type = 'W';
		double transaction = 2000.0;
		balance = balance - transaction;
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		
		type = 'D';
		transaction = 20000.0;
		balance = balance + transaction;
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		
		type = 'D';
		transaction = 500.0;
		balance = balance + transaction;
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		
		type = 'W';
		transaction = 15500.0;
		balance = balance - transaction;
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		
		type = 'W';
		transaction = 10000.0;
		balance = balance - transaction;
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);*/
		
		balance = calculateBalanceAndPrint('W', 2000.0, balance);
		balance = calculateBalanceAndPrint('D', 20000.0, balance);
		balance = calculateBalanceAndPrint('D', 500.0, balance);
		balance = calculateBalanceAndPrint('W', 15500.0, balance);
		balance = calculateBalanceAndPrint('W', 10000.0, balance);
		
		System.out.println("---------------------------");
	}
	
	public static double calculateBalanceAndPrint(char type, double transaction, double balance) {
		if (type == 'D') {
			balance += transaction;
		}
		if (type == 'W') {
			balance -= transaction;
		}
		
		System.out.printf("%4c %12.2f %9.2f\n", type, transaction, balance);
		return balance;
	}
}

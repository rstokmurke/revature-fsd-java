
public class Account {
	private String accountNumber;
	private double balance;
	private Transaction[] transaction;
	
	public Account(String accountNumber, double balance, Transaction[] transaction) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transaction = transaction;
	}
	
	public static void main(String args[]) {
		Transaction transaction1 = new Transaction('W', 2000);
		Transaction transaction2 = new Transaction('D', 20000);
		Transaction transaction3 = new Transaction('D', 500);
		Transaction transaction4 = new Transaction('W', 15500);
		Transaction transaction5 = new Transaction('W', 10000);
		
		Transaction[] transactionArray = {transaction1, transaction2, transaction3, transaction4, transaction5};
		Account account = new Account("01302343794",5000.0, transactionArray);
	}
}

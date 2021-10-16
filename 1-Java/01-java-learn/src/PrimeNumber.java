
public class PrimeNumber {
	static boolean primeNo(int num) {

		boolean temp = false;
		for (int i = 2; i <= num / 2; ++i) {
			if (num % i == 0) {
				temp = true;			
			}
		}
		if (temp == false) {
			System.out.println(num + " is prime");
		} else {
			System.out.println(num + " is not prime");
		}
		return temp;
	}

	public static void main(String[] args) {

		primeNo(41);
		primeNo(17);
		primeNo(25);
	}

}

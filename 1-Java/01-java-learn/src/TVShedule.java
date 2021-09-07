
public class TVShedule {

	public static void main(String[] args) {
		int date = 2;
		LinePrinter.printLine();
		while (date <= 31) {
			System.out.println(date);
			date = date + 3;
		}
		System.out.println("uing do while");
		date = 2;
		do {
			
				System.out.println(date);
				date = date + 3;
		} while (date <= 31);
		
		System.out.println("using loop");
		for (date = 2;date <= 30;date = date+3) {
			System.out.println(date);
		}
	}

}

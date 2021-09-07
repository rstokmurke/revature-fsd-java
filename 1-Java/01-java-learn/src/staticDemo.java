
public class staticDemo {

	private int capacity = 20;

	public static int age = 10;

	public static void staticMethod() {
		System.out.println("Hello world");
		System.out.println(age);
		// System.out.println(capacity); we cant acces the non static variable from
		// static method

	}

	public static void main(String args[]) {
		System.out.println(age);
		// System.out.println(capacity); we cant accesss because capacity is not a satic
		// variable
		int capacity1 = 20;
		System.out.println(capacity1);

		staticDemo staticDemo1 = new staticDemo();
		System.out.println(staticDemo1.capacity);
	}
}

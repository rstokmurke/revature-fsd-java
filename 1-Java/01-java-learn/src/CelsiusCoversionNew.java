
public class CelsiusCoversionNew {

	public static void main(String[] args) {
		System.out.println("Farehneit="+ tofarehn(12));

	}
	public static float tofarehn(float celsius) {
		float farenheit = (celsius * 9/5) + 32;
		return farenheit;
	}

}

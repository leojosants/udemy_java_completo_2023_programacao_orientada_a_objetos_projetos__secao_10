package application;

public class Program {

	public static void main(String[] args) {

		String[] vector = new String[] { "Maria", "Bob", "Alex" };

		// FOR - convencional
		System.out.println("\nFOR");

		for (int i = 0; i < vector.length; i++) {
			System.out.printf("Nome: %s%n",vector[i]);
		}

		// ForEach
		System.out.println("\nFOREACH");
		
		for (String obj : vector) {
			System.out.printf("Nome: %s%n",obj);
		}
	}
}

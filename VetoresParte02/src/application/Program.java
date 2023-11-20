package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int n = 0;
		double sumPrice = 0.0;
		double averagePrice = 0.0;

		n = requestData(scanner);

		Product[] productVector = new Product[n];

		fillVector(scanner, productVector);

		sumPrice = calculateSumPrice(productVector);

		averagePrice = calculateAveragePrice(productVector, sumPrice);

		displayData(averagePrice);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestData(Scanner scanner) {
		int n = 0;

		do {
			System.out.print("\nQuanto N produtos serão informados? ");
			n = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (n <= 0) {
				System.out.print("-> campo 'Quanto N produtos serão informados?' não pode ser menor ou igual a 0: ");
				n = scanner.nextInt();
				scanner.nextLine(); // buffer
			}
		} while (n <= 0);

		return n;
	}

	private static void fillVector(Scanner scanner, Product[] productVector) {
		String temporaryName = "";
		double temporaryPrice = 0.0;

		System.out.printf("\nInforme nome e preço do(s) %d produto(s)", productVector.length);

		for (int i = 0; i < productVector.length; i++) {
			do {
				System.out.printf("\nDigite o nome  do %dº produto: ", (i + 1));
				temporaryName = scanner.nextLine().toUpperCase().trim();

				while (temporaryName.equals("")) {
					System.out.printf("-> campo 'Digite o nome do %dº produto' não pode ser vazio: ", (i + 1));
					temporaryName = scanner.nextLine().toUpperCase().trim();
				}
			} while (temporaryName.equals(""));

			do {
				System.out.printf("Digite o preço do %dº produto: ", (i + 1));
				temporaryPrice = scanner.nextDouble();
				scanner.nextLine(); // buffer

				while (temporaryPrice <= 0.0) {
					System.out.printf("-> campo 'Digite o preço do %dº produto' não pode ser menor ou igual a 0: ", i);
					temporaryPrice = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			} while (temporaryPrice <= 0.0);

			productVector[i] = new Product(temporaryName, temporaryPrice);
		}
	}

	private static double calculateSumPrice(Product[] productVector) {
		double sumPrice = 0.0;

		for (int i = 0; i < productVector.length; i++) {
			sumPrice += productVector[i].getPrice();
		}

		return sumPrice;
	}

	private static double calculateAveragePrice(Product[] productVector, double sumPrice) {
		double averagePrice = 0.0;
		averagePrice = sumPrice / productVector.length;
		return averagePrice;
	}

	private static void displayData(double averagePrice) {
		System.out.printf("\nPreço médio: R$ %.2f%n", averagePrice);
	}
}

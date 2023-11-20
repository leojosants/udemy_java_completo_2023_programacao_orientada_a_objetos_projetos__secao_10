package exemplo01.application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int n = 0;
		double averageHeight = 0.0;

		n = requestData(scanner);

		double[] heightVector = new double[n];

		fillVector(scanner, heightVector);

		averageHeight = calculateAverageHeight(heightVector);

		displayData(averageHeight);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestData(Scanner scanner) {
		int n = 0;

		do {
			System.out.print("\nInforme um número inteiro para N, referente a quantidade de altura a ser informada: ");
			n = scanner.nextInt();

			while (n <= 0) {
				System.out.print("-> campo 'informe um número inteiro para N' não pode ser menor ou igual a 0: ");
				n = scanner.nextInt();
			}
		} while (n <= 0);

		return n;
	}

	private static void fillVector(Scanner scanner, double[] heightVector) {
		double temporary = 0.0;

		System.out.printf("\nInforme %d altura(s)%n", heightVector.length);

		for (int i = 0; i < heightVector.length; i++) {
			do {
				System.out.printf("Digite a %dª altura [m]: ", (i + 1));
				temporary = scanner.nextDouble();
				heightVector[i] = temporary;

				while (temporary <= 0.0) {
					System.out.printf("-> campo 'digite a %dª altura [m]' não pode ser menor ou igual a 0: ", i);
					temporary = scanner.nextDouble();
					heightVector[i] = temporary;
				}
			} while (temporary <= 0.0);

			System.out.println();
		}
	}

	private static double calculateAverageHeight(double[] heightVector) {
		double averageHeight = 0.0;
		double sumHeight = 0.0;

		for (int i = 0; i < heightVector.length; i++) {
			sumHeight += heightVector[i];
		}

		averageHeight = sumHeight / heightVector.length;

		return averageHeight;
	}

	private static void displayData(double averageHeight) {
		System.out.printf("Altura média: %.2f%n", averageHeight);
	}
}

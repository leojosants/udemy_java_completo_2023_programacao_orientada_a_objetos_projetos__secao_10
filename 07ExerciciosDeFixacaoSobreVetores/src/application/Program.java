package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;
		double sum = 0.0;
		double average = 0.0;

		initialNumber = requestInitialNumber(scanner);

		double[] intVector = new double[initialNumber];

		fillVector(scanner, intVector);

		sum = calculateSum(intVector);

		average = calculateAverage(intVector, sum);

		displayAverage(average);

		checkElementsBelowAverage(intVector, average);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantos elementos vai ter o vetor? ");
			initialNumber = scanner.nextInt();

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos elementos vai ter o vetor?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos elementos vai ter o vetor?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillVector(Scanner scanner, double[] vector) {
		double temporary = 0;

		System.out.printf("\nInforme o(s) %d elementos(s) real(s) para o vetor %n", vector.length);

		for (int i = 0; i < vector.length; i++) {
			do {
				System.out.printf("Digite o %dº número: ", (i + 1));
				temporary = scanner.nextDouble();

				while (temporary < 0.0) {
					System.out.printf("-> campo 'Digite o %dº número' não pode ser menor que 0.0: ", (i + 1));
					temporary = scanner.nextDouble();
				}

				while (temporary == 0.0) {
					System.out.printf("-> campo 'Digite o %dº número' não pode ser igual a 0.0: ", (i + 1));
					temporary = scanner.nextDouble();
				}

			} while (temporary <= 0.0);

			vector[i] = temporary;
		}
	}

	private static double calculateSum(double[] vector) {
		double sum = 0.0;

		for (int i = 0; i < vector.length; i++) {
			sum += vector[i];
		}

		return sum;
	}

	private static double calculateAverage(double[] vector, double sum) {
		double average = 0.0;
		average = sum / vector.length;
		return average;
	}

	private static void displayAverage(double average) {
		System.out.printf("\nMédia do vetor: %.3f%n", average);
	}

	private static void checkElementsBelowAverage(double[] vector, double average) {
		System.out.println("\nElementos abaixo da média: ");

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < average) {
				System.out.printf("- %.1f%n", vector[i]);
			}
		}
		System.out.println();
	}
}

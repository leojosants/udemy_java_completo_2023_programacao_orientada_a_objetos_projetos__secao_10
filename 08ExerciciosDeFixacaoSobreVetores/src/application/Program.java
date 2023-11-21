package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;

		initialNumber = requestInitialNumber(scanner);

		int[] vector = new int[initialNumber];

		fillVector(scanner, vector);

		calculateSum(vector);

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

	private static void fillVector(Scanner scanner, int[] vector) {
		int temporary = 0;

		System.out.printf("\nInforme o(s) %d elementos(s) inteiro(s) para o vetor %n", vector.length);

		for (int i = 0; i < vector.length; i++) {
			do {
				System.out.printf("Digite o %dº elemento: ", (i + 1));
				temporary = scanner.nextInt();

				while (temporary < 0) {
					System.out.printf("-> campo 'Digite o %dº elemento' não pode ser menor que 0: ", (i + 1));
					temporary = scanner.nextInt();
				}

				while (temporary == 0) {
					System.out.printf("-> campo 'Digite o %dº elemento' não pode ser igual a 0: ", (i + 1));
					temporary = scanner.nextInt();
				}

			} while (temporary <= 0.0);

			vector[i] = temporary;
		}
	}

	private static void calculateSum(int[] vector) {
		int sum = 0;
		int totalOfEvenNumbers = 0;

		for (int i = 0; i < vector.length; i++) {
			if ((vector[i] % 2) == 0) {
				sum += vector[i];
				totalOfEvenNumbers++;
			}
		}

		calculateAverage(sum, totalOfEvenNumbers);
	}

	private static void calculateAverage(int sum, int totalOfEvenNumbers) {
		int average = 0;

		if (totalOfEvenNumbers != 0) {
			average = sum / totalOfEvenNumbers;
		}

		displayAverage(average, totalOfEvenNumbers);
	}

	private static void displayAverage(double average, int totalOfEvenNumbers) {
		if (totalOfEvenNumbers == 0) {
			System.out.println("\nNenhum número par");

		} else {
			System.out.printf("\nMédia dos pares: %.1f%n", average);
		}
	}
}

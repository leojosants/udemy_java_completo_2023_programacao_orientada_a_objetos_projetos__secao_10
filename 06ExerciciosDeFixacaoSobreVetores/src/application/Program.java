package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;

		initialNumber = requestInitialNumber(scanner);

		int[] vector_A = new int[initialNumber];
		int[] vector_B = new int[initialNumber];
		int[] vector_C = new int[initialNumber];

		fillNumbersVector(scanner, vector_A, 'A');
		fillNumbersVector(scanner, vector_B, 'B');

		calculateSumOfElementsOfVectors(vector_A, vector_B, vector_C, initialNumber);

		displayVector(vector_C);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantos valores terá cada vetor? ");
			initialNumber = scanner.nextInt();

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos valores terá cada vetor?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos valores terá cada vetor?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillNumbersVector(Scanner scanner, int[] vector, char whichVector) {
		int temporaryNumber = 0;

		if (whichVector == 'A') {
			System.out.printf("\nInforme o(s) %d número(s) inteiro(s) para o vetor A %n", vector.length);

		} else {
			System.out.printf("\nInforme o(s) %d número(s) inteiro(s) para o vetor B %n", vector.length);
		}

		for (int i = 0; i < vector.length; i++) {
			do {
				System.out.printf("Digite o %dº número: ", (i + 1));
				temporaryNumber = scanner.nextInt();

				while (temporaryNumber < 0) {
					System.out.printf("-> campo 'Digite o %dº número' não pode ser menor que 0: ", (i + 1));
					temporaryNumber = scanner.nextInt();
				}

				while (temporaryNumber == 0.0) {
					System.out.printf("-> campo 'Digite o %dº número' não pode ser igual a 0: ", (i + 1));
					temporaryNumber = scanner.nextInt();
				}

			} while (temporaryNumber <= 0);

			vector[i] = temporaryNumber;
		}
	}

	private static void calculateSumOfElementsOfVectors(int[] vector_A, int[] vector_B, int[] vector_C, int initialNumber) {
		int temporarySum = 0;

		for (int i = 0; i < initialNumber; i++) {
			temporarySum = vector_A[i] + vector_B[i];
			vector_C[i] = temporarySum;
		}
	}

	private static void displayVector(int[] vector) {
		System.out.println("\nVetor resultante");

		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%d%n", vector[i]);
		}
	}
}

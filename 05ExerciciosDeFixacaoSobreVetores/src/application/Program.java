package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;

		initialNumber = requestInitialNumber(scanner);

		double[] numbersVector = new double[initialNumber];

		fillNumbersVector(scanner, numbersVector);

		displayLargestNumber(numbersVector);
//		displayTotalAmountOfEvenNumbers(numbersVector);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantos números reais serão digitados? ");
			initialNumber = scanner.nextInt();

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos números reais serão digitados?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos números reais serão digitados?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillNumbersVector(Scanner scanner, double[] numbersVector) {
		double temporaryNumber = 0.0;

		System.out.printf("\nInforme o(s) %d número(s) real(s) %n", numbersVector.length);

		for (int i = 0; i < numbersVector.length; i++) {
			do {
				System.out.printf("Digite 0 %dº número: ", (i + 1));
				temporaryNumber = scanner.nextDouble();

				while (temporaryNumber < 0.0) {
					System.out.printf("-> campo 'Digite 0 %dº número' não pode ser menor que 0.0: ", (i + 1));
					temporaryNumber = scanner.nextDouble();
				}

				while (temporaryNumber == 0.0) {
					System.out.printf("-> campo 'Digite 0 %dº número' não pode ser igual a 0.0: ", (i + 1));
					temporaryNumber = scanner.nextDouble();
				}

			} while (temporaryNumber <= 0.0);

			numbersVector[i] = temporaryNumber;
		}
	}

	private static void displayLargestNumber(double[] numbersVector) {
		double largestNumber = numbersVector[0];
		int totalOfEqualNumbers = 0;
		int positionOfTheLargestNumber = 0;

		for (int i = 0; i < numbersVector.length; i++) {
			if (numbersVector[i] > largestNumber) {
				largestNumber = numbersVector[i];
				positionOfTheLargestNumber = i;
			}

			if (numbersVector[0] == numbersVector[i]) {
				totalOfEqualNumbers++;
			}
		}

		if (totalOfEqualNumbers == numbersVector.length) {
			System.out.println("\nNão há maior valor, todos são iguais");

		} else {
			System.out.printf("\nMaior valor: %.2f%n", largestNumber);
			System.out.printf("Posição do maior valor: %d%n", positionOfTheLargestNumber);
		}

	}

	private static void displayTotalAmountOfEvenNumbers(int[] numbersVector) {
		int total = 0;

		for (int i = 0; i < numbersVector.length; i++) {
			if ((numbersVector[i] % 2) == 0) {
				total++;
			}
		}

		System.out.printf("\nQuantidade de números pares: %d%n", total);
	}
}

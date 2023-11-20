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
			System.out.print("\nQuantos n�meros reais ser�o digitados? ");
			initialNumber = scanner.nextInt();

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos n�meros reais ser�o digitados?' n�o pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos n�meros reais ser�o digitados?' n�o pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillNumbersVector(Scanner scanner, double[] numbersVector) {
		double temporaryNumber = 0.0;

		System.out.printf("\nInforme o(s) %d n�mero(s) real(s) %n", numbersVector.length);

		for (int i = 0; i < numbersVector.length; i++) {
			do {
				System.out.printf("Digite 0 %d� n�mero: ", (i + 1));
				temporaryNumber = scanner.nextDouble();

				while (temporaryNumber < 0.0) {
					System.out.printf("-> campo 'Digite 0 %d� n�mero' n�o pode ser menor que 0.0: ", (i + 1));
					temporaryNumber = scanner.nextDouble();
				}

				while (temporaryNumber == 0.0) {
					System.out.printf("-> campo 'Digite 0 %d� n�mero' n�o pode ser igual a 0.0: ", (i + 1));
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
			System.out.println("\nN�o h� maior valor, todos s�o iguais");

		} else {
			System.out.printf("\nMaior valor: %.2f%n", largestNumber);
			System.out.printf("Posi��o do maior valor: %d%n", positionOfTheLargestNumber);
		}

	}

	private static void displayTotalAmountOfEvenNumbers(int[] numbersVector) {
		int total = 0;

		for (int i = 0; i < numbersVector.length; i++) {
			if ((numbersVector[i] % 2) == 0) {
				total++;
			}
		}

		System.out.printf("\nQuantidade de n�meros pares: %d%n", total);
	}
}

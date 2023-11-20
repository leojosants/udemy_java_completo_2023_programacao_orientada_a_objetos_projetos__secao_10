package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;

		initialNumber = requestInitialNumber(scanner);

		int[] numbersVector = new int[initialNumber];

		fillNumbersVector(scanner, numbersVector);

		displayEvenNumbers(numbersVector);
		
		displayTotalAmountOfEvenNumbers(numbersVector);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantos números inteiros serão digitados? ");
			initialNumber = scanner.nextInt();

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos números inteiros serão digitados?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos números inteiros serão digitados?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillNumbersVector(Scanner scanner, int[] numbersVector) {
		int temporaryNumber = 0;

		System.out.printf("\nInforme o(s) %d número(s) inteiro(s) %n", numbersVector.length);

		for (int i = 0; i < numbersVector.length; i++) {
			do {
				System.out.printf("Digite 0 %dº número: ", (i + 1));
				temporaryNumber = scanner.nextInt();

				while (temporaryNumber < 0) {
					System.out.printf("-> campo 'Digite 0 %dº número' não pode ser menor que 0: ", (i + 1));
					temporaryNumber = scanner.nextInt();
				}

				while (temporaryNumber == 0) {
					System.out.printf("-> campo 'Digite 0 %dº número' não pode ser igual a 0: ", (i + 1));
					temporaryNumber = scanner.nextInt();
				}

			} while (temporaryNumber <= 0.0);

			numbersVector[i] = temporaryNumber;
		}
	}

	private static void displayEvenNumbers(int[] numbersVector) {
		System.out.print("\nNumeros pares: ");

		for (int i = 0; i < numbersVector.length; i++) {
			if ((numbersVector[i] % 2) == 0) {
				System.out.printf("%d ", numbersVector[i]);
			}
		}
	}

	private static void displayTotalAmountOfEvenNumbers(int[] numbersVector) {
		int total = 0;

		for (int i = 0; i < numbersVector.length; i++) {
			if ((numbersVector[i] % 2) == 0) {
				total++;
			}
		}
		
		System.out.printf("\nQuantidade de números pares: %d%n",total);
	}
}

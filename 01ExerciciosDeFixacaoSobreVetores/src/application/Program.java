package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = 0;

		n = requestInitialNumber(scanner);

		int[] numbersVector = new int[n];

		fillNumbersVector(scanner, numbersVector);

		checksNegativeNumbers(numbersVector);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */

	private static int requestInitialNumber(Scanner scanner) {
		int n = 0;

		do {
			System.out.print("\nInforme um valor para N [entre 1 e 10]: ");
			n = scanner.nextInt();

			while (n < 0) {
				System.out.print("-> campo 'Informe um valor para N [entre 1 e 10]' não pode ser menor que 0: ");
				n = scanner.nextInt();
			}

			while (n == 0) {
				System.out.print("-> campo 'Informe um valor para N [entre 1 e 10]' não pode ser igual a 0: ");
				n = scanner.nextInt();
			}

			while (n > 10) {
				System.out.print("-> campo 'Informe um valor para N [entre 1 e 10]' não pode ser maior que 10: ");
				n = scanner.nextInt();
			}
		} while (n <= 0);

		return n;
	}

	private static void fillNumbersVector(Scanner scanner, int[] numbersVector) {
		int temporaryNumber = 0;

		System.out.printf("\nInforme os %d número(s) %n", numbersVector.length);

		for (int i = 0; i < numbersVector.length; i++) {
			System.out.printf("Digite o %dº número: ", (i + 1));
			temporaryNumber = scanner.nextInt();
			numbersVector[i] = temporaryNumber;
		}
	}

	private static void checksNegativeNumbers(int[] numbersVector) {
		System.out.println("\nNúmeros negativos:");

		for (int i = 0; i < numbersVector.length; i++) {
			if (numbersVector[i] < 0) {
				System.out.printf("%d%n", numbersVector[i]);
			}
		}
	}
}

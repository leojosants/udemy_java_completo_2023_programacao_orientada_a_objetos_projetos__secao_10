package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);

		int n = 0;
		double sumRealNumbersVector = 0.0;
		double averageRealNumbersVector = 0.0;

		n = requestInitialNumber(scanner);

		double[] realNumbersVector = new double[n];

		fillNumbersVector(scanner, realNumbersVector);

		printRealNumbersVector(realNumbersVector);

		sumRealNumbersVector = calculateSumRealNumbersVector(realNumbersVector);

		displaySumRealNumbersVector(sumRealNumbersVector);

		averageRealNumbersVector = calculateAverageRealNumbersVector(sumRealNumbersVector,realNumbersVector);

		displayAverageRealNumbersVector(averageRealNumbersVector);
		
		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int n = 0;

		do {
			System.out.print("\nInforme um valor para N: ");
			n = scanner.nextInt();

			while (n < 0) {
				System.out.print("-> campo 'Informe um valor para N' não pode ser menor que 0: ");
				n = scanner.nextInt();
			}
			
			while (n == 0) {
				System.out.print("-> campo 'Informe um valor para N' não pode ser igual a 0: ");
				n = scanner.nextInt();
			}

		} while (n <= 0);

		return n;
	}

	private static void fillNumbersVector(Scanner scanner, double[] realNumbersVector) {
		double temporaryNumber = 0.0;

		System.out.printf("\nInforme os %d número(s) %n", realNumbersVector.length);

		for (int i = 0; i < realNumbersVector.length; i++) {
			do {
				System.out.printf("Digite o %dº número real: ", (i + 1));
				temporaryNumber = scanner.nextDouble();

				while (temporaryNumber < 0.0) {
					System.out.printf("-> campo 'Digite o %dº número real' não pode ser menor que 0: ", (i + 1));
					temporaryNumber = scanner.nextDouble();
				}
				
				while (temporaryNumber == 0.0) {
					System.out.printf("-> campo 'Digite o %dº número real' não pode ser igual a 0: ", (i + 1));
					temporaryNumber = scanner.nextDouble();
				}
			} while (temporaryNumber <= 0.0);

			realNumbersVector[i] = temporaryNumber;
		}
	}

	private static void printRealNumbersVector(double[] realNumbersVector) {
		System.out.print("\nElementos do vetor: ");

		for (int i = 0; i < realNumbersVector.length; i++) {
			System.out.printf("%.2f ", realNumbersVector[i]);
		}
	}

	private static double calculateSumRealNumbersVector(double[] realNumbersVector) {
		double sum = 0.0;

		for (int i = 0; i < realNumbersVector.length; i++) {
			sum += realNumbersVector[i];
		}

		return sum;
	}

	private static void displaySumRealNumbersVector(double sumRealNumbersVector) {
		System.out.printf("\nSoma:  %.2f%n", sumRealNumbersVector);
	}

	private static double calculateAverageRealNumbersVector(double sumRealNumbersVector, double[] realNumbersVector) {
		double average = 0.0;
		average = sumRealNumbersVector / realNumbersVector.length;
		return average;
	}
	
	private static void displayAverageRealNumbersVector(double averageRealNumbersVector) {
		System.out.printf("Média: %.2f%n", averageRealNumbersVector);
	}
}

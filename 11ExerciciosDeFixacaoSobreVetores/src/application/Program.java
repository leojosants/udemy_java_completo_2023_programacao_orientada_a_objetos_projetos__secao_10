package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;
		double shorterHeight = 0.0;
		double greaterHeight = 0.0;
		double averageHeightOfWomen = 0.0;
		int numberOfMen = 0;

		initialNumber = requestInitialNumber(scanner);

		double[] heightsVector = new double[initialNumber];
		char[] genersVector = new char[initialNumber];

		fillVector(scanner, heightsVector, genersVector, initialNumber);

		shorterHeight = calculateSmallestHeight(heightsVector);
		greaterHeight = calculateGreatestHeight(heightsVector);
		averageHeightOfWomen = calculateTheAverageHeightOfWomen(heightsVector, genersVector, initialNumber);
		numberOfMen = checkNumberOfMen(genersVector);

		displayShorterHeight(shorterHeight);
		displayGreaterHeight(greaterHeight);
		displayAverageHeightOfWomen(averageHeightOfWomen);
		displayNumberOfMen(numberOfMen);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantas pessoas serão digitadas? ");
			initialNumber = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantas pessoas serão digitadas?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantas pessoas serão digitadas?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer

				while (initialNumber < 0) {
					System.out.print("-> campo 'Quantas pessoas serão digitadas?' não pode ser menor que 0: ");
					initialNumber = scanner.nextInt();
					scanner.nextLine(); // buffer
				}
			}
		} while (initialNumber <= 0);

		System.out.println();
		return initialNumber;
	}

	private static void fillVector(Scanner scanner, double[] heightsVector, char[] genersVector, int initialNumber) {
		double temporaryHeight = 0.0;
		char temporaryGender;

		System.out.printf("Informe o(s) dado(s) da(s) %d pessoa(s)%n", initialNumber);

		for (int i = 0; i < initialNumber; i++) {
			System.out.printf("\nDigite os dados da %dº pessoa: ", (i + 1));
			System.out.println();

			do {
				System.out.print("Altura [m]: ");
				temporaryHeight = scanner.nextDouble();
				scanner.nextLine(); // buffer

				while (temporaryHeight < 0.0) {
					System.out.print("-> campo 'Altura [m]' não pode ser menor que 0.0: ");
					temporaryHeight = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (temporaryHeight == 0.0) {
					System.out.print("-> campo 'Altura [m]' não pode ser igual a 0.0: ");
					temporaryHeight = scanner.nextDouble();
					scanner.nextLine(); // buffer

					while (temporaryHeight < 0.0) {
						System.out.print("-> campo 'Altura [m]' não pode ser menor que 0.0: ");
						temporaryHeight = scanner.nextDouble();
						scanner.nextLine(); // buffer
					}
				}
			} while (temporaryHeight <= 0.0);

			heightsVector[i] = temporaryHeight;

			do {
				System.out.print("Gênero [M / F]: ");
				temporaryGender = scanner.next().charAt(0);

				while ((temporaryGender != 'm') && (temporaryGender != 'f')) {
					System.out.print("-> campo 'Gênero [M / f]' somente deve receber [M] ou [F]: ");
					temporaryGender = scanner.next().charAt(0);
				}
			} while ((temporaryGender != 'm') && (temporaryGender != 'f'));

			genersVector[i] = temporaryGender;
		}
	}

	private static double calculateSmallestHeight(double[] heightsVector) {
		double shorterHeight = heightsVector[0];

		for (int i = 0; i < heightsVector.length; i++) {
			if (heightsVector[i] < shorterHeight) {
				shorterHeight = heightsVector[i];
			} 
		}

		return shorterHeight;
	}

	private static double calculateGreatestHeight(double[] heightsVector) {
		double greaterHeight = heightsVector[0];

		for (int i = 0; i < heightsVector.length; i++) {
			if (heightsVector[i] > greaterHeight) {
				greaterHeight = heightsVector[i];
			} 
		}

		return greaterHeight;
	}

	private static double calculateTheAverageHeightOfWomen(double[] heightsVector, char[] genersVector, int initialNumber) {
		double average = 0.0;
		double sum = 0.0;
		int counter = 0;

		for (int i = 0; i < initialNumber; i++) {
			if (genersVector[i] == 'f') {
				sum += heightsVector[i];
				counter++;
			}
		}

		average = sum / counter;
		return average;
	}

	private static int checkNumberOfMen(char[] vector) {
		int counter = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == 'm') {
				counter++;
			}
		}

		return counter;
	}

	private static void displayShorterHeight(double shorterHeight) {
		System.out.printf("\nMenor altura: %.2f%n", shorterHeight);
	}

	private static void displayGreaterHeight(double greaterHeight) {
		System.out.printf("Maior altura: %.2f%n", greaterHeight);
	}

	private static void displayAverageHeightOfWomen(double averageHeightOfWomen) {
		System.out.printf("Média das alturas das mulheres: %.2f%n", averageHeightOfWomen);
	}
	
	private static void displayNumberOfMen(int numberOfMen) {
		System.out.printf("Número de homens: %d%n", numberOfMen);
	}
}

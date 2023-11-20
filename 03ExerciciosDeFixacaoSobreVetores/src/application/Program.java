package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;
		double sumOfHeights = 0.0;
		double averageHeight = 0.0;

		initialNumber = requestInitialNumber(scanner);

		Person[] personVector = new Person[initialNumber];

		fillNumbersVector(scanner, personVector);

		sumOfHeights = calculateSumOfHeights(personVector);

		averageHeight = calculateAverageHeight(sumOfHeights, personVector);

		displayAverageHeight(averageHeight);

		calculatePercentageOfPeopleUnderTheAgeOf16(personVector);

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
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillNumbersVector(Scanner scanner, Person[] personVector) {
		String temporaryName = "";
		int temporaryAge = 0;
		double temporaryHeight = 0.0;

		System.out.printf("\nInforme nome, idade e altura da(s) %d pessoa(s)%n", personVector.length);

		for (int i = 0; i < personVector.length; i++) {
			System.out.printf("Dados da %dº pessoa: ", (i + 1));

			do {
				System.out.print("\nNome: ");
				temporaryName = scanner.nextLine().trim();

				while (temporaryName.equals("")) {
					System.out.print("-> campo 'Nome' não pode ser vazio: ");
					temporaryName = scanner.nextLine().trim();
				}
			} while (temporaryName.equals(""));

			do {
				System.out.print("Idade: ");
				temporaryAge = scanner.nextInt();
				scanner.nextLine(); // buffer

				while (temporaryAge < 0) {
					System.out.print("-> campo 'Idade' não pode ser menor que 0: ");
					temporaryAge = scanner.nextInt();
					scanner.nextLine(); // buffer
				}

				while (temporaryAge == 0) {
					System.out.print("-> campo 'Idade' não pode ser igual a 0: ");
					temporaryAge = scanner.nextInt();
					scanner.nextLine(); // buffer
				}
			} while (temporaryAge <= 0);

			do {
				System.out.print("Altura [metros]: ");
				temporaryHeight = scanner.nextDouble();
				scanner.nextLine(); // buffer

				while (temporaryHeight < 0.0) {
					System.out.print("-> campo 'Altura [metros]' não pode ser menor que 0: ");
					temporaryHeight = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (temporaryHeight == 0.0) {
					System.out.print("-> campo 'Altura [metros]' não pode ser igual a 0: ");
					temporaryHeight = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			} while (temporaryHeight <= 0.0);

			personVector[i] = new Person(temporaryName, temporaryAge, temporaryHeight);
			System.out.println();
		}
	}

	private static double calculateSumOfHeights(Person[] personVector) {
		double sum = 0.0;

		for (int i = 0; i < personVector.length; i++) {
			sum += personVector[i].getHeight();
		}

		return sum;
	}

	private static double calculateAverageHeight(double sumOfHeights, Person[] personVector) {
		double average = 0.0;
		average = sumOfHeights / personVector.length;
		return average;
	}

	private static void displayAverageHeight(double averageHeight) {
		System.out.printf("Altura média: %.2f%n", averageHeight);
	}

	private static void calculatePercentageOfPeopleUnderTheAgeOf16(Person[] personVector) {
		int under16 = 0;
		double averageUnder16 = 0.0;

		for (int i = 0; i < personVector.length; i++) {
			if (personVector[i].getAge() < 16) {
				under16++;
			}
		}

		averageUnder16 = ((double)under16 / personVector.length) * 100.00;

		System.out.printf("Porcentagem de pessoas com menos de 16 anos: %.1f%%\n", averageUnder16);
		System.out.println("Pessoas com menos de 16 anos: ");

		for (int i = 0; i < personVector.length; i++) {
			if (personVector[i].getAge() < 16) {
				System.out.printf("%s%n", personVector[i].getName());
			}
		}
	}
}

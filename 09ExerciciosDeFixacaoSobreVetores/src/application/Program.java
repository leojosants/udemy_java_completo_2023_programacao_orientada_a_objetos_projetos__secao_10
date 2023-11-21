package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;
		String olderPerson = "";

		initialNumber = requestInitialNumber(scanner);

		String[] namesVector = new String[initialNumber];
		int[] agesVector = new int[initialNumber];

		fillVector(scanner, namesVector, agesVector, initialNumber);

		olderPerson = checkOlderPerson(namesVector, agesVector, initialNumber);

		displayOlderPerson(olderPerson);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantas pessoas serão informadas? ");
			initialNumber = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantas pessoas serão informadas?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantas pessoas serão informadas?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillVector(Scanner scanner, String[] namesVector, int[] agesVector, int initialNumber) {
		String temporaryName = "";
		int temporaryAge = 0;

		System.out.printf("Informe o(s) dado(s) da(s) %d pessoa(s)%n", initialNumber);

		for (int i = 0; i < initialNumber; i++) {
			System.out.printf("\nDigite os dados da %dº pessoa: ", (i + 1));
			System.out.println();

			do {
				System.out.print("Nome: ");
				temporaryName = scanner.nextLine().trim();

				while (temporaryName.equals("")) {
					System.out.print("-> campo 'Nome' não pode ser vazio: ");
					temporaryName = scanner.nextLine().trim();
				}
			} while (temporaryName.equals(""));

			namesVector[i] = temporaryName;

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

			agesVector[i] = temporaryAge;
		}
	}

	private static String checkOlderPerson(String[] namesVector, int[] agesVector, int initialNumber) {
		String olderPerson = "";
		int temporaryAge = agesVector[0];

		for (int i = 0; i < initialNumber; i++) {
			if (agesVector[i] > temporaryAge) {
				olderPerson = namesVector[i];
			}
		}

		return olderPerson;
	}

	private static void displayOlderPerson(String olderPerson) {
		System.out.printf("\nPessoa mais velha: %s%n", olderPerson.toUpperCase());
	}

}

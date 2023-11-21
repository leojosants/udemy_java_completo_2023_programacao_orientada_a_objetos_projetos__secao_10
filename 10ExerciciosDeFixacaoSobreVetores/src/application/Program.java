package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		int initialNumber = 0;

		initialNumber = requestInitialNumber(scanner);

		String[] namesVector = new String[initialNumber];
		double[] gradesVector = new double[initialNumber];

		fillVector(scanner, namesVector, gradesVector, initialNumber);

		calculateAverageGrades(namesVector, gradesVector, initialNumber);

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestInitialNumber(Scanner scanner) {
		int initialNumber = 0;

		do {
			System.out.print("\nQuantos alunos serão informados? ");
			initialNumber = scanner.nextInt();
			scanner.nextLine(); // buffer

			while (initialNumber < 0) {
				System.out.print("-> campo 'Quantos alunos serão informados?' não pode ser menor que 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while (initialNumber == 0) {
				System.out.print("-> campo 'Quantos alunos serão informados?' não pode ser igual a 0: ");
				initialNumber = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

		} while (initialNumber <= 0);

		return initialNumber;
	}

	private static void fillVector(Scanner scanner, String[] namesVector, double[] gradesVector, int initialNumber) {
		String temporaryName = "";
		double temporaryGrade_1 = 0.0;
		double temporaryGrade_2 = 0.0;
		double temporarySumOfGrades = 0.0;

		System.out.printf("Informe o(s) dado(s) do(s) %d aluno(s)%n", initialNumber);

		for (int i = 0; i < initialNumber; i++) {
			System.out.printf("\nDigite os dados do %dº aluno: ", (i + 1));
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
				System.out.print("Nota do primeiro semestre: ");
				temporaryGrade_1 = scanner.nextDouble();
				scanner.nextLine(); // buffer

				while (temporaryGrade_1 < 0.0) {
					System.out.print("-> campo 'Nota do primeiro semestre' não pode ser menor que 0.0: ");
					temporaryGrade_1 = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (temporaryGrade_1 == 0.0) {
					System.out.print("-> campo 'Nota do primeiro semestre' não pode ser igual a 0.0: ");
					temporaryGrade_1 = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			} while (temporaryGrade_1 <= 0.0);

			do {
				System.out.print("Nota do segundo  semestre: ");
				temporaryGrade_2 = scanner.nextDouble();
				scanner.nextLine(); // buffer

				while (temporaryGrade_2 < 0.0) {
					System.out.print("-> campo 'Nota do segundo semestre' não pode ser menor que 0.0: ");
					temporaryGrade_2 = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}

				while (temporaryGrade_2 == 0.0) {
					System.out.print("-> campo 'Nota do segundo semestre' não pode ser igual a 0.0: ");
					temporaryGrade_2 = scanner.nextDouble();
					scanner.nextLine(); // buffer
				}
			} while (temporaryGrade_2 <= 0.0);

			temporarySumOfGrades = temporaryGrade_1 + temporaryGrade_2;
			gradesVector[i] = temporarySumOfGrades;
		}
	}

	private static void calculateAverageGrades(String[] namesVector, double[] gradesVector, int initialNumber) {
		double gradeForApproval = 6.0;

		System.out.println("\nAlunos aprovados:");

		for (int i = 0; i < initialNumber; i++) {
			if (gradesVector[i] >= gradeForApproval) {
				System.out.printf("- %s%n", namesVector[i].toUpperCase());
			}
		}
	}
}

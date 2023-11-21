package application;

import java.util.Scanner;

import entities.Rent;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Rent[] bedroomsVector = new Rent[10];

		int totalNumberOfTenants = 0;
		
		totalNumberOfTenants = requestTotalNumberOfTenants(scanner);

		fillVector(scanner, bedroomsVector, totalNumberOfTenants);

		displayBusyRooms(bedroomsVector);

		scanner.close();
	}

	/*
	 * functions
	 */
	private static int requestTotalNumberOfTenants(Scanner scanner) {
		int total = 0;

		System.out.println();

		while (total == 0) {
			do {
				System.out.print("Informe o número de quartos que vão ser alugados: ");
				total = scanner.nextInt();
				scanner.nextLine(); // buffer

				while (total < 0) {
					System.out.print(
							"-> campo'Informe o número de quartos que vão ser alugados', não pode ser menor que 0: ");
					total = scanner.nextInt();
					scanner.nextLine(); // buffer
				}

				while (total == 0) {
					System.out.print(
							"-> campo'Informe o número de quartos que vão ser alugados', não pode ser igual a 0: ");
					total = scanner.nextInt();
					scanner.nextLine(); // buffer

					while (total < 0) {
						System.out.print(
								"-> campo'Informe o número de quartos que vão ser alugados', não pode ser menor que 0: ");
						total = scanner.nextInt();
						scanner.nextLine(); // buffer
					}
				}
			} while (total <= 0);
		}

		System.out.println();

		return total;
	}

	private static String requestName(Scanner scanner) {
		String temporaryName = "";

		do {
			System.out.print("Nome: ");
			temporaryName = scanner.nextLine().trim().toUpperCase();

			while (temporaryName.equals("")) {
				System.out.print("-> campo 'Nome' não pode ser vazio: ");
				temporaryName = scanner.nextLine().trim().toUpperCase();
			}
		} while (temporaryName.equals(""));

		return temporaryName;
	}

	private static String requestEmail(Scanner scanner) {
		String temporaryEmail = "";

		do {
			System.out.print("Email: ");
			temporaryEmail = scanner.nextLine().trim().toUpperCase();

			while (temporaryEmail.equals("")) {
				System.out.print("-> campo 'Email' não pode ser vazio: ");
				temporaryEmail = scanner.nextLine().trim().toUpperCase();
			}
		} while (temporaryEmail.equals(""));

		return temporaryEmail;
	}

	private static int requestRoomNumber(Scanner scanner, Rent[] vector) {
		int temporaryRoom = 0;

		System.out.print("Número do quarto [0 a 9]: ");
		temporaryRoom = scanner.nextInt();
		scanner.nextLine(); // buffer

		while ((temporaryRoom < 0) || (temporaryRoom > 9) || (vector[temporaryRoom] != null)) {
			while (temporaryRoom < 0) {
				System.out.print("-> campo 'Número do quarto [0 a 9]', não pode ser menor que 0: ");
				temporaryRoom = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while (temporaryRoom > 9) {
				System.out.print("-> campo 'Número do quarto [0 a 9]', não pode ser maior que 9: ");
				temporaryRoom = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while (vector[temporaryRoom] != null) {
				System.out.print("-> quarto indisponível, opção(s) disponível(s) [ ");

				for (int j = 0; j < vector.length; j++) {
					if (vector[j] == null) {
						System.out.printf("%d ", j);
					}
				}

				System.out.print("]: ");

				temporaryRoom = scanner.nextInt();
				scanner.nextLine(); // buffer
			}
		}

		return temporaryRoom;
	}

	private static void fillVector(Scanner scanner, Rent[] vector, int totalNumberOfTenants) {
		for (int i = 0; i < totalNumberOfTenants; i++) {
			System.out.printf("Aluguel #%d: ", (i + 1));
			System.out.println();

			String temporaryName = requestName(scanner);
			String temporaryEmail = requestEmail(scanner);
			int temporaryRoom = requestRoomNumber(scanner, vector);
			vector[temporaryRoom] = new Rent(temporaryName, temporaryEmail);

			System.out.println();
		}
	}

	private static void displayBusyRooms(Rent[] bedroomsVector) {
		System.out.println("Quartos ocupados:");

		for (int i = 0; i < bedroomsVector.length; i++) {
			if (bedroomsVector[i] != null) {
				System.out.printf("%d: %s, %s%n", i, bedroomsVector[i].getName(), bedroomsVector[i].getEmail());
			}
		}

	}
}

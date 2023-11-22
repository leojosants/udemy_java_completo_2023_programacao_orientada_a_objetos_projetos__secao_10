package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static Scanner scanner = new Scanner(System.in);

	public static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		int totalRecords = requestTotalRecords();

		fillList(employeeList, totalRecords);

		int idThatWillIncrease = requestIdThatWillIncrease();

		Employee employeeId = employeeList.stream().filter(x -> x.getId() == idThatWillIncrease).findFirst()
				.orElse(null);

		if (employeeId == null) {
			System.out.println("-> Id inexistente");

		} else {
			double increasePercentage = requestIncreasePercentage();
			employeeId.increaseSalary(increasePercentage);
		}

		System.out.println("\nLista de funcionários:");

		for (Employee employee : employeeList) {
			System.out.printf("%s%n", employee);
		}

		scanner.close();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions
	 */
	private static int requestTotalRecords() {
		int totalRecords = 0;

		System.out.print("\nQuantos funcionários serão registrado: ");
		totalRecords = scanner.nextInt();
		scanner.nextLine(); // buffer

		while ((totalRecords <= 0)) {
			while ((totalRecords < 0)) {
				System.out.print("-> campo 'Quantos funcionários serão registrado' não pode ser menor que 0: ");
				totalRecords = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while ((totalRecords == 0)) {
				System.out.print("-> campo 'Quantos funcionários serão registrado' não pode ser igual a 0: ");
				totalRecords = scanner.nextInt();
				scanner.nextLine(); // buffer
			}
		}

		return totalRecords;
	}

	private static void fillList(List<Employee> employeeList, int totalRecords) {
		for (int i = 0; i < totalRecords; i++) {
			System.out.printf("%nFuncionário #%d%n", (i + 1));

			int temporaryId = requestId();

			while (hasId(temporaryId)) {
				System.out.print("-> 'Id indisponível', informe outro ");
				temporaryId = requestId();
			}

			String temporaryName = requestName();
			double temporarySalary = requestSalary();

			employeeList.add(new Employee(temporaryId, temporaryName, temporarySalary));
		}
	}

	private static int requestId() {
		int id = 0;

		System.out.print("Id: ");
		id = scanner.nextInt();
		scanner.nextLine(); // buffer

		while ((id < 0) || (id == 0)) {
			while ((id < 0)) {
				System.out.print("-> campo 'Id' não pode ser menor que 0: ");
				id = scanner.nextInt();
				scanner.nextLine(); // buffer
			}

			while ((id == 0)) {
				System.out.print("-> campo 'Id' não pode ser igual a 0: ");
				id = scanner.nextInt();
				scanner.nextLine(); // buffer
			}
		}

		return id;
	}

	public static boolean hasId(int id) {
		Employee employee = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return employee != null;
	}

	private static String requestName() {
		String name = "";

		System.out.print("Nome: ");
		name = scanner.nextLine().replace(",", "").replace(".", "").trim();

		while (name.isEmpty()) {
			System.out.print("-> campo 'Nome' não pode ser vazio: ");
			name = scanner.nextLine().replace(",", "").replace(".", "").trim();
		}

		return name;
	}

	private static double requestSalary() {
		double salary = 0.0;

		System.out.print("Salário: R$ ");
		salary = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while ((salary <= 0.0)) {
			while ((salary < 0.0)) {
				System.out.print("-> campo 'Salário' não pode ser menor que 0.0: ");
				salary = scanner.nextDouble();
				scanner.nextLine(); // buffer
			}

			while ((salary == 0.0)) {
				System.out.print("-> campo 'Salário' não pode ser igual a 0.0: ");
				salary = scanner.nextDouble();
				scanner.nextLine(); // buffer
			}
		}

		return salary;
	}

	private static int requestIdThatWillIncrease() {
		int idIncrease = 0;

		System.out.print("\nEntre com o 'Id' que vai ter aumento salarial: ");
		idIncrease = scanner.nextInt();
		scanner.nextLine(); // buffer

		return idIncrease;
	}

	private static double requestIncreasePercentage() {
		double increasePercentage = 0.0;

		System.out.print("Entre com a porcentagem: ");
		increasePercentage = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while ((increasePercentage <= 0.0)) {
			while ((increasePercentage < 0.0)) {
				System.out.print("-> campo 'Entre com a porcentagem' não pode ser menor que 0.0: ");
				increasePercentage = scanner.nextDouble();
				scanner.nextLine(); // buffer
			}

			while ((increasePercentage == 0.0)) {
				System.out.print("-> campo 'Entre com a porcentagem' não pode ser igual a 0.0: ");
				increasePercentage = scanner.nextDouble();
				scanner.nextLine(); // buffer
			}
		}

		return increasePercentage;
	}
}

package entities;

public class Employee {
	/*
	 * attributes
	 */
	private Integer id;
	private String name;
	private Double salary;

	/*
	 * constructor
	 */
	public Employee(Integer id, String name, Double salary) {
		this.setId(id);
		this.setName(name);
		this.setSalary(salary);
	}

	/*
	 * getters and setters
	 */
	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	private void setSalary(Double salary) {
		this.salary = salary;
	}

	/*
	 * methods
	 */
	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100.0;
	}

	public String toString() {
		return String.format("ID: %d, ", this.getId()) + String.format("Nome: %s, ", this.getName())
				+ String.format("Salário: R$ %.2f", this.getSalary());
	}
}

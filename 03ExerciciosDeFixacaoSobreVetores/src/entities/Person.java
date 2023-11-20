package entities;

public class Person {
	/*
	 * attributes
	 */
	private String name;
	private int age;
	private double height;

	/*
	 * constructor
	 */
	public Person(String name, int age, double height) {
		this.setName(name);
		this.setAge(age);
		this.setHeight(height);
	}

	/*
	 * getters and setters
	 */
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}
}

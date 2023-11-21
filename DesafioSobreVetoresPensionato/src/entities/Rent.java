package entities;

public class Rent {
	/*
	 * attributes
	 */
	private String name;
	private String email;

	/*
	 * constructor
	 */
	public Rent(String name, String email) {
		this.setName(name);
		this.setEmail(email);
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

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}
	
	
}

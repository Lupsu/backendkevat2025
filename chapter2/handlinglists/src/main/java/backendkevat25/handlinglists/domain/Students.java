package backendkevat25.handlinglists.domain;

public class Students {
    private String firstName;
    private String lastName;

    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
    }

    @Override
	public String toString() {
		return "First name [firstName=" + firstName + "], Last name [lastName=" + lastName + "]";
    }
}

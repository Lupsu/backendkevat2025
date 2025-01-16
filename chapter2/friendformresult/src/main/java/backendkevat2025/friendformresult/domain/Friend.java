package backendkevat2025.friendformresult.domain;

import java.util.ArrayList;
import java.util.List;

public class Friend {
    private String firstName;
    private String lastName;
    private static List<Friend> friendsList = new ArrayList<>();

	public Friend() {}

    // Constructor
    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        friendsList.add(this); // Add the new object to the list
    }

    // Getters and setters
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

    // Method to get the list of friends
    public static List<Friend> getFriendsList() {
        return friendsList;
    }
}
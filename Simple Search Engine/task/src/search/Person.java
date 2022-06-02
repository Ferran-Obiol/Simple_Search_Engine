package search;

public class Person {

    private String firstName = "";
    private String lastName = "";;
    private String email = "";;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPerson(String toSearch) {
        return (firstName.toLowerCase().contains(toSearch.toLowerCase())
                || lastName.toLowerCase().contains(toSearch.toLowerCase())
                || email.toLowerCase().contains(toSearch.toLowerCase()));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + (email.isBlank() ? "" : " " + email);
    }
}

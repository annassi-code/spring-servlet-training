package model;

public class User {
    private String firstName;
    private String lastName;
    private int budget;
    private User brother;

    public User(String firstName, String lastName, int budget, User brother) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
        this.brother = brother;
    }

    public User(String firstName, String lastName, int budget) {
        this(firstName,lastName,budget,null);
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

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public User getBrother() {
        return brother;
    }

    public void setBrother(User brother) {
        this.brother = brother;
    }
}

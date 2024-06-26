package se.lexicon.model;

import java.util.Arrays;

public class Person {
    // todo: needs completion
    private int id;
    private String firstName;
    private String lastName;
    private int sequencer = 0;
    private Book[] books = new Book[0];

    // Constructor
    public Person(String firstName, String lastName) {
        getNextid();
        validateAndAssignStringInput(firstName, "firstName");
        validateAndAssignStringInput(lastName, "lastName");
    }

    // Helper methods
    private void getNextid() {
        this.id = sequencer + 1;
        sequencer++;
    }
    private void validateAndAssignStringInput(String stringInput, String paramName) {
        if (stringInput == null || stringInput.trim().isEmpty()) {
            throw new IllegalArgumentException(paramName + " must not be null or empty");
        }

        switch (paramName) {
            case "firstName":
                this.firstName = stringInput;
                break;
            case "lastName":
                this.lastName = stringInput;
                break;
        }
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        validateAndAssignStringInput(firstName, "firstName");
    }
    public void setLastName(String lastName) {
        validateAndAssignStringInput(lastName, "lastName");
    }
    public void setEmail(String email) {
        validateAndAssignStringInput(email, "email");
    }

    // Methods
    public String getPersonInformation() {
        String booksAsString = this.books == null ? "No books borrowed" : Arrays.toString(this.books);
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + booksAsString +
                '}';
    }

    public void loanBook (Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null");
        }

        Book[] tempBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, tempBooks, 0, books.length);
        tempBooks[books.length] = book;
        books = tempBooks;

        book.setBorrower(this);
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null");
        }

        Book[] tempBooks = new Book[books.length - 1];
        int index = 0;

        for (Book value : books) {
            if (value.getId().equals(book.getId())) {
                continue;
            }
            tempBooks[index] = value;
            index++;
        }
        books = tempBooks;

        book.setBorrower(null);
    }

    public Book[] getBooks() {
        return books;
    }

}
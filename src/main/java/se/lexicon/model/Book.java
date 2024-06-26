package se.lexicon.model;

import java.util.UUID;

public class Book {
    private final String id;
    private String title;
    private String author;
    private boolean available;



    public Book(String title, String author) {
        this.id = generateId();
        setTitle(title);
        setAuthor(author);
        this.available = true;
    }

    private String generateId() {
        return UUID.randomUUID().toString().substring(0, 12);
    }

    private void validateStringInput(String stringInput, String paramName) {
        if (stringInput == null || stringInput.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setTitle (String title) {
        validateStringInput(title, "title");
        this.title = title;
    }
    public void setAuthor (String author) {
        validateStringInput(author, "author");
        this.author = author;
    }

    public String getBookInformation() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }

    public void setBorrower (Person borrower) {
        this.available = borrower == null;
    }
}
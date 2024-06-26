package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion

        // Create books.
        Book tlotr = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book hp = new Book("Harry Potter", "J.K. Rowling");

        // Create a person instance
        Person person = new Person("Sergiu", "Niculescu");
        // Display person information.
        String personInformation = person.getPersonInformation();
        System.out.println(personInformation);


        // Loan a book to the person
        person.loanBook(tlotr);
        // Display person information after borrowing a book
        System.out.println("\nAfter loaning the book, the person should have one book!");
        personInformation = person.getPersonInformation();
        System.out.println(personInformation);

        // Display book information after borrowing a book
        System.out.println("\nAfter loaning the book, the available should be false!");
        String bookInformation = tlotr.getBookInformation();
        hp.getBookInformation();
        String bookInformation2;
        System.out.println(bookInformation);

        // Loan another book to the person.
        person.loanBook(hp);


        // Display the books that the person has borrowed.
        System.out.println("\nBooks that the person has borrowed:");
        for (Book book : person.getBooks()) {
            System.out.println(book.getBookInformation());
        }

        // Return the borrowed book
        person.returnBook(tlotr);
        person.returnBook(hp);
        // Display person information after returning the book
        personInformation = person.getPersonInformation();
        System.out.printf(personInformation);
        // Display book information after borrowing a book
        System.out.println("After returning the tlotr and the harry potter, the available should be true!");
        bookInformation = tlotr.getBookInformation();
        bookInformation2 = hp.getBookInformation();
        System.out.println(bookInformation);
        System.out.println(bookInformation2);




    }

}
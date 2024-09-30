package com.sheikhimtiaz.complexcollections;


public class LibrarySystemTest {
    public static void run() {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "1234567890"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "1234567891"));
        library.addBook(new Book("1984", "George Orwell", "Dystopian", "1234567892"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", "1234567893"));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", "1234567894"));

        // Print all books in the library
        library.printAllBooks();

        // User borrows a book
        library.borrowBook("user1", "1234567890");
        library.borrowBook("user1", "1234567892");

        // Print borrowed books
        library.printBorrowedBooks("user1");

        // Print all books after borrowing
        library.printAllBooks();

        // User returns a book
        library.returnBook("user1", "1234567890");

        // Print borrowed books after returning
        library.printBorrowedBooks("user1");

        // Print all books after returning
        library.printAllBooks();
    }
}
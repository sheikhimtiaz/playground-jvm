package com.sheikhimtiaz.complexcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<String, List<Book>> genreToBooksMap;
    private Map<String, Set<Book>> userBorrowedBooksMap;

    public Library() {
        genreToBooksMap = new HashMap<>();
        userBorrowedBooksMap = new HashMap<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        genreToBooksMap
                .computeIfAbsent(book.getGenre(), k -> new ArrayList<>())
                .add(book);
    }

    // Borrow a book
    public boolean borrowBook(String userId, String isbn) {
        for (List<Book> books : genreToBooksMap.values()) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    userBorrowedBooksMap
                            .computeIfAbsent(userId, k -> new HashSet<>())
                            .add(book);
                    books.remove(book);
                    return true;
                }
            }
        }
        return false;
    }

    // Return a book
    public boolean returnBook(String userId, String isbn) {
        Set<Book> borrowedBooks = userBorrowedBooksMap.get(userId);
        if (borrowedBooks != null) {
            for (Book book : borrowedBooks) {
                if (book.getIsbn().equals(isbn)) {
                    borrowedBooks.remove(book);
                    addBook(book);
                    return true;
                }
            }
        }
        return false;
    }

    // Search for books by genre
    public List<Book> searchBooksByGenre(String genre) {
        return genreToBooksMap.getOrDefault(genre, Collections.emptyList());
    }

    // Print all books in the library
    public void printAllBooks() {
        for (Map.Entry<String, List<Book>> entry : genreToBooksMap.entrySet()) {
            System.out.println("Genre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  " + book);
            }
        }
    }

    // Print all borrowed books for a user
    public void printBorrowedBooks(String userId) {
        Set<Book> borrowedBooks = userBorrowedBooksMap.getOrDefault(userId, Collections.emptySet());
        System.out.println("User " + userId + " has borrowed:");
        for (Book book : borrowedBooks) {
            System.out.println("  " + book);
        }
    }
}


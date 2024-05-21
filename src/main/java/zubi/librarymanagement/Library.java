package zubi.librarymanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<Integer, Book> books;

    public Library() {
        books = new HashMap<>();
    }
    //addBooksFromFile(String filePath): Read book data from file and add to collection
    //filePath (String): The file path of the text file containing the book information.
    public void addBooksFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int booksAdded = 0;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length == 3) {
                    int id = Integer.parseInt(bookData[0].trim());
                    String title = bookData[1].trim();
                    String author = bookData[2].trim();
                    if (!books.containsKey(id)) {
                        books.put(id, new Book(id, title, author));
                        booksAdded++;
                    } else {
                        System.out.println("Book with ID " + id + " already exists in the collection. Skipping...");
                    }
                } else {
                    System.out.println("Invalid book data format: " + line);
                }
            }
            System.out.println("Added " + booksAdded + " books to the collection.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    //removeBook(int bookId): Remove a book from the collection
//bookId (int): The unique ID number of the book to be removed from the collection.
    public void removeBook(int bookId) {
        if (books.containsKey(bookId)) {
            books.remove(bookId);
            System.out.println("Book with ID " + bookId + " has been removed from the collection.");
        } else {
            System.out.println("Book with ID " + bookId + " not found in the collection.");
        }
    }
    //listAllBooks(): Display the list of all books in the collection
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            System.out.println("Books in the collection:");
            for (Book book : books.values()) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    }

}

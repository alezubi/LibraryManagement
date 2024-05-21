package zubi.librarymanagement;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Library {
    private final BookRepository bookRepository;

    public Library(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBooksFromFile(String filePath) {
        // Read books from the file and add them to the repository
        List<Book> books = readBooksFromFile(filePath);
        books.forEach(bookRepository::addBook);
    }

    public void removeBook(int bookId) {
        bookRepository.removeBook(bookId);
    }

    public void listAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        books.forEach(System.out::println);
    }

    private List<Book> readBooksFromFile(String filePath) {
        // Implement the logic to read books from the file
        // and return a list of Book objects
        return List.of();
    }
}

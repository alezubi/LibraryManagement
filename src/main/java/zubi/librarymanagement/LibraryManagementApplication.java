package zubi.librarymanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;
//Alejandro Zubillaga , CEN-3024C-31950 05/16/2024
//main controller
//The Library Management System (LMS) is a console-based application designed to manage the collection of books in a library. The key features and functionality of the LMS are:
//Add new books to the collection from a text file: The system should be able to read book information (unique ID, title, and author) from a text file and add the books to the collection.
//Remove a book from the collection using its ID number: The system should allow users to remove a book from the collection by providing the book's unique ID number.
//List all books currently in the collection: The system should display a list of all the books currently in the collection, including their ID, title, and author.
@SpringBootApplication
public class LibraryManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public BookRepository bookRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcBookRepository(jdbcTemplate);
    }

    @Bean
    public CommandLineRunner commandLineRunner(Library library) {
        return args -> {
            // menu and user input handling
        };
    }
}
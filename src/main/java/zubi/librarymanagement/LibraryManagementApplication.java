package zubi.librarymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add books from file");
            System.out.println("2. Remove a book");
            System.out.println("3. List all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the file path: ");
                    String filePath = scanner.nextLine();
                    library.addBooksFromFile(filePath);
                    break;
                case 2:
                    System.out.print("Enter the book ID to remove: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    library.removeBook(bookId);
                    break;
                case 3:
                    library.listAllBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library Management System...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}

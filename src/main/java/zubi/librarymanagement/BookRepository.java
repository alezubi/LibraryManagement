package zubi.librarymanagement;

import java.util.List;

public interface BookRepository {
    void addBook(Book book);

    void removeBook(int bookId);

    List<Book> getAllBooks();
}

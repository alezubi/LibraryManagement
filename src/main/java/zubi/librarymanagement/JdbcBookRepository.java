package zubi.librarymanagement;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcBookRepository implements BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getAuthor());
    }


    @Override
    public void removeBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";
        jdbcTemplate.update(sql, bookId);
    }


    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT id, title, author FROM books";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author")
        ));
    }
}


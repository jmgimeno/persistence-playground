package cat.udl.eps.amp.jdbc.h2.db;

import cat.udl.eps.amp.jdbc.h2.domain.Book;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcBookDAO implements BookDAO {
    private final DataSource dataSource;

    public JdbcBookDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> allBoks() throws SQLException {
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery("SELECT * FROM tutorials_tbl")) {
            var books = new ArrayList<Book>();
            while (resultSet.next()) {
                var book = new Book(resultSet.getLong("id"), resultSet.getString("title"),
                        resultSet.getString("author"
                ));
                books.add(book);
            }
            return books;
        }
    }

    @Override
    public long addBook(Book book) throws SQLException {
        if (book.getId() != -1) throw new IllegalArgumentException("book cannot have id");
        String sql = "INSERT INTO tutorials_tbl (title, author) VALUES (?, ?)";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.executeUpdate();
            try (var resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    var id = resultSet.getLong(1);
                    book.setId(id);
                    return id;
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
    }

    @Override
    public Optional<Book> findById(long id) throws SQLException {
        String sql = "SELECT * FROM tutorials_tbl WHERE id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    var book = new Book(resultSet.getLong("id"), resultSet.getString("title"),
                            resultSet.getString("author"));
                    return Optional.of(book);
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        if (book.getId() == -1) throw new IllegalArgumentException("book must have id");
        String sql = "UPDATE tutorials_tbl SET title = ?, author = ? WHERE id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setLong(3, book.getId());
            statement.executeUpdate();
        }
    }
}

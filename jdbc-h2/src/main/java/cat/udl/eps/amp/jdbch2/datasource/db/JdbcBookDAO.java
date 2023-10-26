package cat.udl.eps.amp.jdbch2.datasource.db;

import cat.udl.eps.amp.jdbch2.datasource.domain.Book;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
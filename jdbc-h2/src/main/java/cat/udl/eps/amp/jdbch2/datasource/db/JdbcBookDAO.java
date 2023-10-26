package cat.udl.eps.amp.jdbch2.datasource.db;

import cat.udl.eps.amp.jdbch2.datasource.domain.Book;

import javax.sql.DataSource;
import java.sql.SQLException;
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
}

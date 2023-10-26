package cat.udl.eps.amp.jdbch2.datasource.db;

import cat.udl.eps.amp.jdbch2.datasource.domain.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    List<Book> allBoks() throws SQLException;
    long addBook(Book book) throws SQLException;
}

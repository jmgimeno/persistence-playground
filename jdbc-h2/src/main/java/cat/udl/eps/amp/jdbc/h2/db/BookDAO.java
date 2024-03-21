package cat.udl.eps.amp.jdbc.h2.db;

import cat.udl.eps.amp.jdbc.h2.domain.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> allBoks() throws SQLException;

    long addBook(Book book) throws SQLException;

    Optional<Book> findById(long id) throws SQLException;

    void updateBook(Book book) throws SQLException;
}

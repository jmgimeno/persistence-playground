package cat.udl.eps.amp.jpa.h2.db;

import cat.udl.eps.amp.jpa.h2.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> allBoks();
    long addBook(Book book);
    Optional<Book> findById(long id);
    void updateBook(Book book);
}

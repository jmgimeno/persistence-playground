package cat.udl.eps.amp.jdbch2.datasource.migrations;

import cat.udl.eps.amp.jdbch2.datasource.db.BookDAO;
import cat.udl.eps.amp.jdbch2.datasource.db.JdbcBookDAO;
import cat.udl.eps.amp.jdbch2.datasource.domain.Book;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Logger;

public class AddBooks {

    private static final Logger logger = Logger.getLogger(AddBooks.class.getName());
    private static final String url = "jdbc:h2:mem:test";
    private static final DataSource dataSource = JdbcConnectionPool.create(
            url, "sa", null);

    public static void main(String[] args) {
        try {
            FlyWayMigrations.initDatabase(dataSource);
            BookDAO bookDAO = new JdbcBookDAO(dataSource);
            long newID = bookDAO.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
            System.out.println("newID = " + newID);
            List<Book> books = bookDAO.allBoks();
            System.out.println(books);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
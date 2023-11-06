package cat.udl.eps.amp.jdbc.h2.initscript;

import cat.udl.eps.amp.jdbc.h2.db.BookDAO;
import cat.udl.eps.amp.jdbc.h2.db.JdbcBookDAO;
import cat.udl.eps.amp.jdbc.h2.domain.Book;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.util.List;

public class AddBooks {

    static DataSource dataSource = JdbcConnectionPool.create(
            "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'jdbc-h2/scripts/init.sql'", "sa", "sa");

    public static void main(String[] args) {
        try {
            BookDAO bookDAO = new JdbcBookDAO(dataSource);
            long newID = bookDAO.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
            System.out.println("newID = " + newID);
            List<Book> books = bookDAO.allBoks();
            System.out.println(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

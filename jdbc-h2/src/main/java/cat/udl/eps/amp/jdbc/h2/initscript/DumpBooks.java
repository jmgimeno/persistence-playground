package cat.udl.eps.amp.jdbc.h2.initscript;

import cat.udl.eps.amp.jdbc.h2.db.BookDAO;
import cat.udl.eps.amp.jdbc.h2.db.JdbcBookDAO;
import cat.udl.eps.amp.jdbc.h2.domain.Book;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.util.List;

public class DumpBooks {

    static DataSource dataSource = JdbcConnectionPool.create(
            "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'jdbc-h2/scripts/init.sql'", "sa", "sa");

    public static void main(String[] args) {
        try {
            BookDAO bookDAO = new JdbcBookDAO(dataSource);
            List<Book> books = bookDAO.allBoks();
            books.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

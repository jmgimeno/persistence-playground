package cat.udl.eps.amp.jdbch2.datasource.migrations;

import cat.udl.eps.amp.jdbch2.datasource.db.BookDAO;
import cat.udl.eps.amp.jdbch2.datasource.db.JdbcBookDAO;
import cat.udl.eps.amp.jdbch2.datasource.domain.Book;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.util.List;

public class DumpBooks {

    public static final String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    static DataSource dataSource = JdbcConnectionPool.create(
            url, "sa", null);

    public static void main(String[] args) {
        try {
            FlyWayMigrations.initDatabase(dataSource);
            BookDAO bookDAO = new JdbcBookDAO(dataSource);
            List<Book> books = bookDAO.allBoks();
            System.out.println(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

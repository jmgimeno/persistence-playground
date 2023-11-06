package cat.udl.eps.amp.jdbc.h2.migrations;

import cat.udl.eps.amp.jdbc.h2.db.BookDAO;
import cat.udl.eps.amp.jdbc.h2.db.JdbcBookDAO;
import cat.udl.eps.amp.jdbc.h2.domain.Book;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Logger;

public class DumpBooks {

    static {
        System.setProperty("org.slf4j.simpleLogger.log.org.flywaydb", "warn");
    }

    private static final Logger logger = Logger.getLogger(DumpBooks.class.getName());
    private static final String url = "jdbc:h2:./jdbc-h2/dbfiles/test;AUTO_SERVER=TRUE";
    private static final DataSource dataSource = JdbcConnectionPool.create(
            url, "sa", null);

    public static void main(String[] args) {
        try {
            FlyWayMigrations.initDatabase(dataSource);
            BookDAO bookDAO = new JdbcBookDAO(dataSource);
            List<Book> books = bookDAO.allBoks();
            System.out.println(books);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

}

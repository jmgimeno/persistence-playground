package cat.udl.eps.amp.jpa.h2.main;

import cat.udl.eps.amp.jpa.h2.db.BookDAO;
import cat.udl.eps.amp.jpa.h2.db.JPABookDAO;
import cat.udl.eps.amp.jpa.h2.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;

public class Main {

    static {
        System.setProperty("org.jboss.logging.provider", "slf4j");
        System.setProperty("org.slf4j.simpleLogger.log.org.flywaydb", "warn");
        System.setProperty("org.slf4j.simpleLogger.log.org.hibernate", "warn");
    }

    static void initDatabase() {
        String url = "jdbc:h2:./jpa-h2/dbfiles/test";
        DataSource dataSource = JdbcConnectionPool.create(url, "sa", null);
        Flyway flyway = Flyway
                .configure()
                .loggers("slf4j")
                .dataSource(dataSource)
                .cleanDisabled(false)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    public static void main(String[] args) {
        initDatabase();
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-h2")) {
            EntityManager em = emf.createEntityManager();
            BookDAO bookDAO = new JPABookDAO(em);
            long newID = bookDAO.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
            System.out.println("newID = " + newID);
            Book newAdded = bookDAO.findById(newID).orElseThrow();
            System.out.println(newAdded);
            newAdded.setAuthor("J.R.R. Tolkien (edited)");
            bookDAO.updateBook(newAdded);
            bookDAO.allBoks().forEach(System.out::println);
        }
    }
}

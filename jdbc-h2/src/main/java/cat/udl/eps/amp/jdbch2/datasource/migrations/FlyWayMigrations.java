package cat.udl.eps.amp.jdbch2.datasource.migrations;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyWayMigrations {
    static void initDatabase(DataSource dataSource) {
        Flyway flyway = Flyway
                .configure()
                .loggers("slf4j")
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }
}

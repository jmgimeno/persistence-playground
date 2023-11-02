package cat.udl.eps.amp.jdbch2.datasource.migrations;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyWayMigrations {
    static void initDatabase(DataSource dataSource) {
        Logger.getLogger("org.flywaydb").setLevel(Level.WARNING);
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }
}

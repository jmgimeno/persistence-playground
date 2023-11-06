package cat.udl.eps.amp.jdbc.h2.migrations;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class FlyWayMigrations {
    static void initDatabase(DataSource dataSource) {
        Flyway flyway = Flyway
                .configure()
                .loggers("slf4j")
                .dataSource(dataSource)
                .cleanDisabled(false)
                .load();
        flyway.clean();
        flyway.migrate();
    }
}

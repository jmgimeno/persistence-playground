package cat.udl.eps.amp.jdbch2.datasource.migrations;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public class FlyWayMigrations {
    static void initDatabase(DataSource dataSource) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }
}

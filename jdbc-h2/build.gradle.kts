plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.2.224")
    implementation("org.flywaydb:flyway-core:10.0.0")
}

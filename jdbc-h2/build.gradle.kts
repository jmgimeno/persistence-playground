plugins {
    application
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.2.220")
    implementation("org.flywaydb:flyway-core:9.22.3")
}

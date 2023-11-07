plugins {
    application
    idea
}

repositories {
    mavenCentral()
}

idea {
    module {
        setDownloadJavadoc(true)
    }
}

dependencies {
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate:hibernate-core:6.3.1.Final")
    implementation("com.h2database:h2:2.1.214")
    implementation("org.flywaydb:flyway-core:10.0.0")
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.9")
}

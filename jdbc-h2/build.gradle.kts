plugins {
    application
    idea
}

repositories {
    mavenCentral()
}

idea {
    module {
        isDownloadJavadoc = true
    }
}

dependencies {
    implementation("com.h2database:h2:2.4.240")
    implementation("org.flywaydb:flyway-core:12.1.0")
    implementation("org.slf4j:slf4j-api:2.0.17")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
}

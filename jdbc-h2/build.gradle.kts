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
    implementation("com.h2database:h2:2.1.210")
    implementation("org.flywaydb:flyway-core:10.0.0")
    implementation("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.9")
}

plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.h2database:h2:2.2.224")
    implementation("org.flywaydb:flyway-core:10.0.0")
    implementation("org.slf4j:slf4j-api:1.7.29")
    runtimeOnly("org.slf4j:slf4j-nop:1.7.29")
}

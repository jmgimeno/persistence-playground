plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.testcontainers:testcontainers-bom:2.0.3"))
    testImplementation("org.testcontainers:testcontainers-junit-jupiter")
    testImplementation("org.testcontainers:testcontainers-postgresql")

    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    testRuntimeOnly("org.postgresql:postgresql:42.7.10")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.5.32")
}

tasks.test {
    useJUnitPlatform()
}

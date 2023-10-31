plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testcontainers:postgresql:1.19.1")
    testImplementation("org.testcontainers:junit-jupiter:1.19.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.4.6")
    testRuntimeOnly("org.postgresql:postgresql:42.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

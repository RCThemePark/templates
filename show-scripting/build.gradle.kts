plugins {
    id("groovy")
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "net.rcthemepark"
version = "1.12.1-1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compileOnly("net.rcthemepark:addon:1.21.1")
    implementation("org.apache.groovy:groovy:4.0.14")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications.create<MavenPublication>("maven") {
        this.version = "1.21.1-1.0.0"
        from(components["java"])

        this.artifactId = "showscripting"
        this.groupId = "net.rcthemepark"
    }
}


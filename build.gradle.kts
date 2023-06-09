plugins {
    kotlin("jvm") version "1.8.10"
    id("java")
    id("jacoco")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(group = "org.apache.commons", name = "commons-csv",  version = "1.10.0")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.valiktor:valiktor-core:0.12.0")
}

application {
    mainClass.set("main.Main")
}
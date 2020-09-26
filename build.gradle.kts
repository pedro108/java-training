plugins {
    java
}

group = "org.pjesus"
version = "0.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")
    implementation("org.javatuples", "javatuples", "1.2")
}

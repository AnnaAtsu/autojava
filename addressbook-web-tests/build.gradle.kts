import org.gradle.internal.classpath.Instrumented.systemProperty

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation ("org.jcommander:jcommander:2.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.mysql:mysql-connector-j:9.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.3.0.CR1")

}

tasks.test {
    useJUnitPlatform()
   // if (project.hasProperty("browser")) {
     //   systemProperty("browser",project.property("browser"))
   // }
    if (project.hasProperty("target")) {
           systemProperty("target",project.property("target"))
        }


}

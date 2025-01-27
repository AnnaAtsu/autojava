plugins {
    id("java")
    id("org.hidetake.swagger.generator") version "2.19.1"
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
    testImplementation("com.squareup.okhttp3:okhttp:4.11.0")
    testImplementation("com.squareup.okhttp3:okhttp-urlconnection:4.11.0")
    testImplementation("org.eclipse.angus:angus-mail:2.0.2")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    swaggerCodegen ("io.swagger:swagger-codegen-cli:2.4.34")
    testImplementation("io.swagger:swagger-annotations:1.5.17")
    testImplementation("com.squareup.okhttp:okhttp:2.7.5")
    testImplementation("com.squareup.okhttp:logging-interceptor:2.7.5")
    testImplementation("com.google.code.gson:gson:2.8.1")
    testImplementation("io.gsonfire:gson-fire:1.8.0")
    testImplementation("org.threeten:threetenbp:1.3.5")
    testImplementation("javax.annotation:javax.annotation-api:1.3.2")

}


tasks.test {
    useJUnitPlatform()
}

swaggerSources {
    create("mantis") {
        setInputFile(file("$projectDir/swagger.json"))
        code(
            closureOf<org.hidetake.gradle.swagger.generator.GenerateSwaggerCode> {
                language = "java"
            }
        )
    }
}
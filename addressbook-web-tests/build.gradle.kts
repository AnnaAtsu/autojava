
//import jdk.internal.agent.resources.agent
//import org.gradle.internal.classpath.Instrumented.systemProperty

plugins {
    id("java")
}


//val agent: Configuration by configurations.creating;
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

//configurations {
  //  agent {
    //    canBeResolved = true
      //  canBeConsumed = true
    //}
//}

configurations {
    create("agent") {
        isCanBeResolved = true
        isCanBeConsumed = true
    }
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation ("org.jcommander:jcommander:2.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.mysql:mysql-connector-j:9.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.3.0.CR1")
   //agent("org.aspectj:aspectjweaver:1.9.22")

    testImplementation (platform("io.qameta.allure:allure-bom:2.29.0"))
    testImplementation ("io.qameta.allure:allure-junit5")

}

tasks.test {
    useJUnitPlatform()
   // if (project.hasProperty("browser")) {
     //   systemProperty("browser",project.property("browser"))
   // }
   if (project.hasProperty("target")) {
          systemProperty("target",project.property("target"))
       }

  //  if (project.hasProperty("browser")) {
   //     val browserValue = project.property("browser") as String
  //      systemProperty("browser", browserValue)
  //  }

   // if (project.hasProperty("target")) {
        // Cast the property to String if necessary
    //    val targetValue = project.property("target") as String
    //    systemProperty("target", targetValue)
   // }
  //  jvmArgs = listOf("-javaagent:${agent.singleFile}")

}

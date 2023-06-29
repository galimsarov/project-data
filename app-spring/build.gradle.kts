plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.serialization")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator") // info; refresh; springMvc output
    implementation("org.springframework.boot:spring-boot-starter-web") // Controller, Service, etc..

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // from models to json and Vice versa
    implementation("org.jetbrains.kotlin:kotlin-reflect") // for spring-boot app
    implementation("org.jetbrains.kotlin:kotlin-stdlib") // for spring-boot app
    // transport models
    implementation(project(":common"))
    // v1 api
    implementation(project(":api-v1-jackson"))
    implementation(project(":mappers-v1"))
    // Stubs
    implementation(project(":stubs"))
    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //testImplementation("org.springframework.boot:spring-boot-starter-webflux") // Controller, Service, etc..
    //testImplementation("com.ninja-squad:springmockk:3.0.1") // mockking beans
}

tasks.withType<Test> {
    useJUnitPlatform()
}
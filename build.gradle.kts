import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.61" //TODO: Version 확인
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61" //TODO: Version 확인
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
//  kotlin("plugin.jpa") version "1.5.31"
//  kotlin("plugin.allopen") version "1.4.32"
}

allOpen {   // Kotlin은 final이 기본. Hibernate의 Entity는 final일 수 없다. (Hibernate User Guide - POJO Models 5번 항목)
            // JPA -> 런타임에 Entity Proxy Object를 생성 (Lazy와 같은 동작 수행해야하기 때문)
    annotation("javax.persistence.Entity")
//  annotation("javax.persistence.Embeddable")
//  annotation("javax.persistence.MappedSuperclass")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.10")
    implementation("com.zaxxer:HikariCP:3.4.5")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.oracle.database.jdbc:ojdbc8")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    useJUnitPlatform()
}

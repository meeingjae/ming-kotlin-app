import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.61" //TODO: Version 확인
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61" //TODO: Version 확인
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("kapt") version "1.3.61"
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

    implementation("com.querydsl:querydsl-jpa")
    implementation("com.querydsl:querydsl-core")
    kapt("com.querydsl:querydsl-apt:4.4.0:jpa")

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
    dependsOn("ok")
    useJUnitPlatform()
}

gradle.beforeProject {
    //이녀석은 언제..?
    if (state.failure != null) {
        println("$project beforeProject ----------------FAILED")
    } else {
        println("$project beforeProject ----------------SUCCESS")
    }
}

gradle.afterProject {
    //project Configure 시작 단계에서 호출
    if (state.failure != null) {
        println("$project afterProject ----------------FAILED")
    } else {
        println("$project afterProject ----------------SUCCESS")
    }
}

//tasks.whenTaskAdded {
//    extra["srcDir"] = "src/main/java"
//}
//
//val a by tasks.registering
//
//println("source dir is ${a.get().extra["srcDir"]}")

tasks.register("ok") {
    println("task $this progress...")
    println("task $this done.")
}

tasks.register("failed") {
    dependsOn("ok")
    doLast {
        throw RuntimeException("failed...")
    }
}

gradle.taskGraph.beforeTask {
    // 특정 Task가 실행되기 전에 어떠한 행위를 할 수 있다. (ex. logging)
    println(" before task name : $this")
}

gradle.taskGraph.afterTask {
    //특정 Task가 완료된 후 어떠한 행위를 할 수 있다. (ex. logging)
    println(" after task name : $this")
}
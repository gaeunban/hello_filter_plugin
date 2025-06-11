buildscript {
    repositories {
   		mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.elasticsearch.gradle:build-tools:8.13.0")
    }
}

plugins {
   `java-library`
    //id("elasticsearch.esplugin")
}

apply(plugin = "elasticsearch.esplugin")



group = "com.hello"
version = "8.13.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    //api(libs.commons.math3)
    //implementation(libs.guava)
    //이거 해줘야 elasticsearch libray 생김
    implementation("org.elasticsearch:elasticsearch:8.13.0")
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

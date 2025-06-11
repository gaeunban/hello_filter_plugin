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
}

group = "com.hello"
version = "8.13.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    //이거 해줘야 elasticsearch libray 생김
    implementation("org.elasticsearch:elasticsearch:8.13.0")
}


java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

// JAR: 플러그인 jar 생성 (기본 jar task 그대로 사용 가능)
tasks.named<Jar>("jar") {
    archiveBaseName.set("hello_plugin")
    archiveVersion.set("8.13.0")
}

// ZIP: Elasticsearch 플러그인용 압축 생성
tasks.register<Zip>("buildPluginZip") {
    dependsOn(tasks.named("jar")) // jar 먼저 생성되게 함

    archiveBaseName.set("hello_plugin")
    archiveVersion.set("8.13.0")
    destinationDirectory.set(layout.buildDirectory.dir("distributions"))

    // .jar 파일 포함 (압축 해제 없이)
    from(layout.buildDirectory.file("libs/hello_plugin-8.13.0.jar")) {
        into("hello_plugin")
    }

    // plugin-descriptor.properties 포함
    from("src/main/plugin-metadata") {
        include("plugin-descriptor.properties")
        into("hello_plugin/META-INF")
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

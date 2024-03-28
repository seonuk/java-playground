plugins {
    id("java")
}


repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("com.oracle.database.jdbc:ojdbc8:12.2.0.1")
    implementation("com.lmax:disruptor:4.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
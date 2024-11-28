plugins {
    id("java")
    id("fabric-loom") version("1.8-SNAPSHOT")
    kotlin("jvm") version ("2.0.0")
}

group = "games.synx"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
}

dependencies {
    minecraft("net.minecraft:minecraft:1.21")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.16.0")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.19+kotlin.1.9.23")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.100.7+1.21")
    modImplementation("com.cobblemon:fabric:1.6.0+1.21-SNAPSHOT")

    api("org.mongodb:bson:4.7.2")
    api("net.kyori:adventure-key:4.13.0")



}
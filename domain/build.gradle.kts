plugins {
    kotlin("kapt")
    id ("java-library")
    id ("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Constants.javaTarget
    targetCompatibility = Constants.javaTarget
}
dependencies {
    implementation(DomainImplementationDependencies.javaX)
    implementation(DomainImplementationDependencies.kotlinX)
}
import org.gradle.api.JavaVersion

object Constants {
    const val compileSdk = 33
    const val targetSdk = compileSdk
    const val minSdk = 21
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val namespace = "email.aghajani.pixabay"
    const val jvmTarget = "11"
    val javaTarget = JavaVersion.VERSION_11
}
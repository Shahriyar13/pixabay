object DataImplementationDependencies {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gsonByRetrofit by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }
    val timberLogger by lazy { "com.jakewharton.timber:timber:${Versions.timberLogger}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
}

object DataKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
}

object DataTestImplementationDependencies {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val hilt by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
}

object DataTestKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
}

object DataAndroidTestImplementationDependencies {
    val testJUnit by lazy { "androidx.test.ext:junit:${Versions.androidJUnit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val hilt by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
}

object DataAndroidTestKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
}
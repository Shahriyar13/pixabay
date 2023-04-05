object AppImplementationDependencies {
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeMaterial by lazy { "androidx.compose.material3:material3" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val viewmodelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewmodelCompose}" }
    val lifeCycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
    val paging by lazy { "androidx.paging:paging-runtime:${Versions.paging}" }
    val pagingCompose by lazy { "androidx.paging:paging-compose:${Versions.pagingCompose}" }
    val coilCompose by lazy { "io.coil-kt:coil-compose:${Versions.coilCompose}" }
}

object AppKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
    val hiltAndroidX by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}" }
}

object AppTestImplementationDependencies {
    val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
    val hilt by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
    val paging by lazy { "androidx.paging:paging-common:${Versions.paging}" }
}

object AppTestKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
}

object AppAndroidTestImplementationDependencies {
    val testJUnit by lazy { "androidx.test.ext:junit:${Versions.androidJUnit}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeJUnit by lazy { "androidx.compose.ui:ui-test-junit4" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val hilt by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }
}

object AppAndroidTestKaptDependencies {
    val hilt by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }
}

object AppDebugImplementationDependencies {
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
}
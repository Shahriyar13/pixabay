package email.aghajani.data.remote.api

import email.aghajani.data.remote.dto.response.ServerResponseDto
import email.aghajani.domain.entities.enums.OrderEnum
import email.aghajani.pixabay.data.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {

    @GET("$baseUrl/api")
    suspend fun fetchImages(
        @Query("q") query: String? = "",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 21,
        @Query("order") order: OrderEnum = OrderEnum.POPULAR,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): ServerResponseDto

}
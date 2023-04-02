package email.aghajani.data.remote

import email.aghajani.data.remote.dto.response.ServerResponseDto
import email.aghajani.domain.common.PixabayResult
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

object Converter {
    fun <T> createFromResponse(response: Response<ServerResponseDto<T>>): PixabayResult<T> {
        return if (response.isSuccessful) {
            val body = response.body()
            if (body?.hits != null) {
                PixabayResult.Success(body.hits)
            } else {
                    PixabayResult.Error("Error Null body")
            }
        } else {
            return try {
                val reader = JSONObject((response.errorBody() as ResponseBody).string())
                val errorMessage = reader.getJSONArray("Messages")[0].toString()
                PixabayResult.Error(errorMessage)
            } catch (e: JSONException) {
                e.printStackTrace()
                PixabayResult.Error("Error ${e.message}")
            }

        }
    }
}
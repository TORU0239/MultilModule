package sg.toru.mbase_module.core.network

import retrofit2.http.GET

interface NetworkService {
    @GET("posts")
    suspend fun getService(): List<String>
}
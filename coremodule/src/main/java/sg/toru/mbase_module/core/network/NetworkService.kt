package sg.toru.mbase_module.core.network

import okhttp3.Response
import retrofit2.http.GET

interface NetworkService {
    @GET
    suspend fun getService(): List<String>
}
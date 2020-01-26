package sg.toru.mbase_module.core.network

import retrofit2.http.GET
import sg.toru.mbase_module.core.model.FeedPost

interface NetworkService {
    @GET("posts")
    suspend fun getService(): List<FeedPost>
}
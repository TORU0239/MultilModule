package sg.toru.mbase_module.core.network

import retrofit2.http.GET
import retrofit2.http.Path
import sg.toru.mbase_module.core.model.pojo.FeedComments
import sg.toru.mbase_module.core.model.pojo.FeedPost

interface NetworkService {
    @GET("posts")
    suspend fun getAllPosts(): List<FeedPost>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id:String): FeedPost

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id:String): List<FeedComments>
}
package sg.toru.mbase_module.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import sg.toru.mbase_module.core.model.pojo.FeedComments
import sg.toru.mbase_module.core.model.pojo.FeedPost

interface NetworkService {
    @GET("posts")
    suspend fun getAllPosts(): Response<List<FeedPost>>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id:String): Response<FeedPost>

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") id:String): Response<List<FeedComments>>
}
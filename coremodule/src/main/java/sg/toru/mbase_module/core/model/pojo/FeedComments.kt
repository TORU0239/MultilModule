package sg.toru.mbase_module.core.model.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Field

@JsonClass(generateAdapter = true)
data class FeedComments(@field:Json(name = "postId")    val postId:String,
                        @field:Json(name = "id")        val id:String,
                        @field:Json(name = "name")      val name:String,
                        @field:Json(name = "email")     val email:String,
                        @field:Json(name = "body")      val body:String)
/*
* https://jsonplaceholder.typicode.com/posts/1/comments
*
* "postId": 1,
"id": 1,
"name": "id labore ex et quam laborum",
"email": "Eliseo@gardner.biz",
"body"
*
* */
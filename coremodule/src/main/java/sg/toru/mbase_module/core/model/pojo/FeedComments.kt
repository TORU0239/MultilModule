package sg.toru.mbase_module.core.model.pojo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedComments(@field:Json(name = "postId")    val postId:String,
                        @field:Json(name = "id")        val id:String,
                        @field:Json(name = "name")      val name:String,
                        @field:Json(name = "email")     val email:String,
                        @field:Json(name = "body")      val body:String)
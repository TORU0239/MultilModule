package sg.toru.mbase_module.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedPost(@field:Json(name="userId") val userId:String,
                    @field:Json(name="id") val id:String,
                    @field:Json(name="title") val title:String,
                    @field:Json(name="body") val body:String)
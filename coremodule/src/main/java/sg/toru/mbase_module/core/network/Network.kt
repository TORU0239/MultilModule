package sg.toru.mbase_module.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    const val BASE_URL = "https://www.google.com"
    init {
        val okHttpClient:OkHttpClient = OkHttpClient().newBuilder()
                                        .readTimeout(300, TimeUnit.MILLISECONDS)
                                        .writeTimeout(300, TimeUnit.MILLISECONDS)
                                        .build()

        val retrofit:Retrofit = Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(MoshiConverterFactory.create())
                                .client(okHttpClient)
                                .build()
    }
}
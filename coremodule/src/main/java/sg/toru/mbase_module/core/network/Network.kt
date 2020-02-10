package sg.toru.mbase_module.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {
//    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//
//    private val loggingInterceptor:HttpLoggingInterceptor =
//        HttpLoggingInterceptor().apply {
//            setLevel(HttpLoggingInterceptor.Level.BODY)
//        }
//
//    private val okHttpClient:OkHttpClient = OkHttpClient().newBuilder()
//        .readTimeout(3000, TimeUnit.MILLISECONDS)
//        .writeTimeout(3000, TimeUnit.MILLISECONDS)
//        .addNetworkInterceptor(loggingInterceptor)
//        .build()
//
//    internal val retrofit:Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(MoshiConverterFactory.create())
//        .client(okHttpClient)
//        .build()
}
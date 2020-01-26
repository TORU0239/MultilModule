package sg.toru.mbase_module.core.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val okHttpClient:OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(300, TimeUnit.MILLISECONDS)
        .writeTimeout(300, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor())
        .build()

    private val retrofit:Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    suspend fun request() = retrofit.create(NetworkService::class.java).getService()
}
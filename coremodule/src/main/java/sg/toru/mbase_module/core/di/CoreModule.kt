package sg.toru.mbase_module.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import sg.toru.mbase_module.core.network.Network
import java.util.concurrent.TimeUnit

@Module
class CoreModule {
    @Provides
    fun test() = false

    @Provides
    fun okHttpClient(interceptor:HttpLoggingInterceptor){
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .readTimeout(3000, TimeUnit.MILLISECONDS)
            .writeTimeout(3000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    @Provides
    fun networkInterceptor() =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
}
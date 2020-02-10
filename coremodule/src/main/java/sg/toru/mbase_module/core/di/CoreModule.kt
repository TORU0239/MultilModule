package sg.toru.mbase_module.core.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sg.toru.mbase_module.core.network.service.NetworkService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Singleton
@Module
class CoreModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun okHttpClient(interceptor:HttpLoggingInterceptor):OkHttpClient {
        return OkHttpClient().newBuilder()
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

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideService(retrofit:Retrofit): NetworkService = retrofit.create(
        NetworkService::class.java)
}
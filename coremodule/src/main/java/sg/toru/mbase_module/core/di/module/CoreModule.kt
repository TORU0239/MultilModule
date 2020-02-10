package sg.toru.mbase_module.core.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import sg.toru.mbase_module.core.di.scope.CoreScope
import sg.toru.mbase_module.core.network.service.NetworkService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class CoreModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Singleton
    @Provides
    fun okHttpClient(interceptor:HttpLoggingInterceptor):OkHttpClient {
        return OkHttpClient().newBuilder()
            .readTimeout(3000, TimeUnit.MILLISECONDS)
            .writeTimeout(3000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun networkInterceptor() =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit:Retrofit): NetworkService = retrofit.create(
        NetworkService::class.java)
}
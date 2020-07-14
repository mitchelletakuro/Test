package com.mitchelletakuro.takurogbemisola.di

import com.mitchelletakuro.takurogbemisola.data.network.CarOwnersInterface
import com.mitchelletakuro.takurogbemisola.data.network.JsonPostsApi
import com.mitchelletakuro.takurogbemisola.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Provider
import java.util.concurrent.TimeUnit



val appComponent = module {
    factory { getHttpLoggingInterceptor() }
    factory { provideOkHttpClient(get()) }
    single { provideCarOwnerService(get()) }
    single { ProvideRetrofit(get()) }
    single { provideApiService(get()) }
}


fun provideCarOwnerService(retrofit: Retrofit.Builder):CarOwnersInterface {
    return retrofit.baseUrl(Constants.DOWNLOAD_BASE_URL)
        .build()
        .create(CarOwnersInterface::class.java)
}



//fun provideFilterService(retrofit: Retrofit.Builder): FilterInterface {
//    return retrofit.baseUrl(Constants.BASE_URL)
//        .build()
//        .create(FilterInterface::class.java)
//
//}

private fun provideApiService(retrofit: Retrofit): JsonPostsApi = retrofit.create(JsonPostsApi::class.java)

private fun ProvideRetrofit(
        okHttpClient: OkHttpClient
): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(okHttpClient)
            .build()


//fun provideRetrofit():Retrofit {
//    return Retrofit.Builder()
//        .client(provideOkHttpClient(getHttpLoggingInterceptor()))
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//}

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(1, TimeUnit.MINUTES)
        .callTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return httpLoggingInterceptor
}



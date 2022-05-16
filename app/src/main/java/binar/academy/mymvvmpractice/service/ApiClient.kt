package binar.academy.mymvvmpractice.service

import android.content.Context
import com.chuckerteam.chucker.api.Chucker
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Abika Chairul Yusri created on 3/11/2022 at 10:24 PM.
 */
object ApiClient {
    // BASE_URL merupakan URL default untuk mengkoneksikan aplikasi dengan endpoint pada API
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    fun getInstance(context: Context): ApiService{
        val instance : ApiService by lazy {
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .collector(ChuckerCollector(context))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            retrofit.create(ApiService::class.java)
        }

        return instance
    }

//    private val client = OkHttpClient.Builder()
//        .addInterceptor(logging)
//        .build()
//
//    val instance: ApiService by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//
//        retrofit.create(ApiService::class.java)
//    }
}
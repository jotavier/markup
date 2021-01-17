package br.com.compasso.findit.http

import br.com.compasso.findit.BuildConfig
import okhttp3.Headers.Companion.toHeaders
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Connection {
    companion object {
        private const val DEFAULT_CONNECTION_TIMEOUT_IN_SECONDS: Long = 10
        const val REQUEST_ERROR = "Falha ao solicitar dados"
        const val CONNECTION_ERROR =
            "Falha de comunicação. Por favor, verifique a sua conexão."
    }

    private var connectionTimeout = DEFAULT_CONNECTION_TIMEOUT_IN_SECONDS

    private val headers = mutableMapOf(
        Pair(Header.ACCEPT, Header.Type.APPLICATION_JSON),
        Pair(Header.CONTENT_TYPE, Header.Type.APPLICATION_JSON),
    )

    private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)

    fun build(): Retrofit = retrofitBuilder.client(getHttpClient()).build()

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().connectTimeout(connectionTimeout, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                requestBuilder.headers(
                    headers.toHeaders()
                ).method(request.method, request.body)
                chain.proceed(requestBuilder.build())
            }.build()
    }

    fun setConnectionTimeout(timeInSeconds: Long): Connection {
        connectionTimeout = timeInSeconds
        return this
    }

    fun addHeader(key: String, value: String): Connection {
        headers[key] = value
        return this
    }
}
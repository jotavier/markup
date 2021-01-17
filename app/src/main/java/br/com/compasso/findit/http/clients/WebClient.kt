package br.com.compasso.findit.http.clients

import br.com.compasso.findit.http.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class WebClient {
    fun <T> request(
        call: Call<T>,
        onSuccess: (result: T) -> Unit,
        onError: (message: String) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (!response.isSuccessful) {
                    onError(Connection.REQUEST_ERROR)
                    return
                }
                if (response.body() == null) {
                    onError(Connection.REQUEST_ERROR)
                    return
                }
                response.body()?.also(onSuccess)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                onError(Connection.CONNECTION_ERROR)
                t.printStackTrace()
            }
        })
    }
}

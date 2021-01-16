package br.com.compasso.findit.http.repositories

sealed class Resource<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null
) {

    fun cache(resource: Resource<T>) =
        if (data != null) failure(resource.message, resource.data) else resource

    class Success<T>(data: T, message: String? = null) : Resource<T>(Status.SUCCESS, data, message)
    class Failure<T>(message: String?, data: T? = null) : Resource<T>(Status.FAILURE, data, message)
    class Loading<T>(data: T? = null, message: String? = null) :
        Resource<T>(Status.LOADING, data, message)

    companion object {
        fun <T> success(data: T, message: String? = null) = Success(data, message)
        fun <T> failure(message: String?, data: T? = null) = Failure(message, data)
        fun <T> loading(data: T? = null, message: String? = null) = Loading(data, message)
    }

    enum class Status {
        SUCCESS,
        FAILURE,
        LOADING
    }
}
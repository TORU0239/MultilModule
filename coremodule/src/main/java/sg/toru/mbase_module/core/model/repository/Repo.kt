package sg.toru.mbase_module.core.model.repository

import retrofit2.Response
import sg.toru.mbase_module.core.network.Network
import sg.toru.mbase_module.core.network.NetworkService

object Repo {
    private val networkService:NetworkService = Network.retrofit.create(NetworkService::class.java)

    suspend fun advancedAllPost() = baseRequest { networkService.getAllPosts() }

    private suspend fun<T : Any> baseRequest(apiCall: suspend ()-> Response<T>):Output<T>{
        val result:Response<T>
        try {
            result = apiCall.invoke()
        } catch (exception:Exception) {
            return Output.Exceptional(exception)
        }

        if(!result.isSuccessful){
            result.errorBody()?.let { error ->
                return Output.Failure(error.toString())
            }
        }

        if(result.body() == null){
            return Output.Exceptional(RuntimeException("Null body is not allowed here!"))
        }
        return Output.Success(result.body()!!)
    }
}

sealed class Output<out T:Any> { // out means we are only allowed to read the value.
    data class Success<out T:Any>(val output:T):Output<T>()
    data class Failure(val failureMsg:String):Output<Nothing>()
    data class Exceptional(val exception:java.lang.Exception):Output<Nothing>()
}
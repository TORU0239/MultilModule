package sg.toru.mbase_module.core.model.repository

import retrofit2.Response
import sg.toru.mbase_module.core.network.reponse.Output
import sg.toru.mbase_module.core.network.service.NetworkService
import javax.inject.Inject

class NetRepository @Inject constructor(var service: NetworkService) {
    suspend fun advancedAllPost() = baseRequest { service.getAllPosts() }

    private suspend fun<T : Any> baseRequest(apiCall: suspend ()-> Response<T>): Output<T> {
        val result: Response<T>
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
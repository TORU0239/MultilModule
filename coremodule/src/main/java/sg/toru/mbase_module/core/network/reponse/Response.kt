package sg.toru.mbase_module.core.network.reponse

sealed class Output<out T:Any> { // out means we are only allowed to read the value.
    data class Success<out T:Any>(val output:T):Output<T>()
    data class Failure(val failureMsg:String):Output<Nothing>()
    data class Exceptional(val exception:java.lang.Exception):Output<Nothing>()
}
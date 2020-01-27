package sg.toru.multilmodule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.toru.mbase_module.core.model.pojo.FeedPost
import sg.toru.mbase_module.core.model.repository.Output
import sg.toru.mbase_module.core.model.repository.Repo

class MainViewModel:ViewModel() {
    internal fun testCoroutine(): LiveData<List<FeedPost>> = liveData{
        when(val post = Repo.advancedAllPost()){
            is Output.Success<List<FeedPost>> ->{
                emit(post.output)
            }
            is Output.Failure -> {
                exceptionalLiveData.value = ""
            }
            is Output.Exceptional -> {
                exceptionalLiveData.value = ""
            }
        }
    }

    val exceptionalLiveData:MutableLiveData<String> = MutableLiveData()
}

class TestViewModel(private val param:String):ViewModel(){
    internal fun runSomething(){
        Log.e("Toru", "runSomething! $param")
    }
}
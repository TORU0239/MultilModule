package sg.toru.multilmodule.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.toru.mbase_module.core.model.pojo.FeedPost
import sg.toru.mbase_module.core.model.repository.NetRepository
import sg.toru.mbase_module.core.network.reponse.Output
import javax.inject.Inject

class MainViewModel:ViewModel() {
    @Inject
    lateinit var repo:NetRepository

    internal fun testCoroutine(): LiveData<List<FeedPost>> = liveData{
        when(val post = repo.advancedAllPost()){
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
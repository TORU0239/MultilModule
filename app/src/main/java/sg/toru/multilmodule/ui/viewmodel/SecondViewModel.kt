package sg.toru.multilmodule.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import sg.toru.mbase_module.core.model.pojo.FeedPost
import sg.toru.mbase_module.core.model.repository.NetRepository
import sg.toru.mbase_module.core.network.reponse.Output
import javax.inject.Inject

class SecondViewModel: ViewModel() {

    @Inject
    lateinit var repo:NetRepository

    fun test() = liveData {
        when(val post = repo.advancedAllPost()){
            is Output.Success<List<FeedPost>> ->{
                emit(post.output)
            }
            is Output.Failure -> {

            }
            is Output.Exceptional -> {

            }
        }
    }
}
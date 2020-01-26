package sg.toru.multilmodule

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sg.toru.mbase_module.core.model.repository.Repo

class MainViewModel:ViewModel() {
    internal val resultLiveData = MutableLiveData<String>()

    internal fun trigger(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = Repo.requestAllPosts()
            withContext(Dispatchers.Main){
                resultLiveData.value = result.size.toString()
            }
        }
    }

    internal fun getPostAndComment(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("Toru", "post trigger")
            val post = Repo.requestPostById(id)
            Log.e("Toru", "comment trigger")
            val comments = Repo.requestCommentById(id)

            withContext(Dispatchers.Main){
                Log.e("Toru", "body: ${post.body}")
                Log.e("Toru", "comments size: ${comments.size}")
            }
        }
    }
}

class TestViewModel(private val param:String):ViewModel(){
    internal fun runSomething(){
        Log.e("Toru", "runSomething! $param")
    }
}
package sg.toru.multilmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sg.toru.mbase_module.core.model.repository.Repo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
        test2()
    }

    private fun test() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = Repo.requestAllPosts()
            withContext(Dispatchers.Main){
                Log.e("Toru", "result size :: ${result.size}")
            }
        }
    }

    private fun test2(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = Repo.requestPostById("1")
        }
    }
}

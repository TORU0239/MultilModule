package sg.toru.multilmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sg.toru.mbase_module.core.network.Network
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    fun test() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = Network.request()
            withContext(Dispatchers.Main){
                Log.e("Toru", "result size :: ${result.size}")
            }
        }
    }
}

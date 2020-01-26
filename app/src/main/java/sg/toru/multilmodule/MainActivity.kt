package sg.toru.multilmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sg.toru.mbase_module.core.model.pojo.FeedPost
import sg.toru.mbase_module.core.model.repository.Repo

class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    private val customViewModel:TestViewModel by lazy {
        CustomViewModelFactory("TORU!!!").create(TestViewModel::class.java)
    }

    private val textView: TextView by lazy {
        findViewById<TextView>(R.id.txtResult)
    }

    private val progressBar:ProgressBar by lazy {
        findViewById<ProgressBar>(R.id.progressBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.testCoroutine().observe(this, Observer<List<FeedPost>>{ list ->
            progressBar.visibility = View.GONE
            if(list.isEmpty()){
                textView.text = "No returned value!!"
            }
            else{
                textView.text = "returned size:::: ${list.size}"
            }
        })
    }
}

@Suppress("UNCHECKED_CAST")
class CustomViewModelFactory(private val param:String):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestViewModel(param) as T
    }
}
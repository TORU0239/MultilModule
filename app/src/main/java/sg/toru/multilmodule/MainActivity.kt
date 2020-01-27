package sg.toru.multilmodule

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sg.toru.mbase_module.core.model.pojo.FeedPost

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
            textView.text = "returned size:::: ${list.size}"
        })

        viewModel.exceptionalLiveData.observe(this, Observer {
            progressBar.visibility = View.GONE
            // Error Handling Part
        })
    }
}

@Suppress("UNCHECKED_CAST")
class CustomViewModelFactory(private val param:String):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestViewModel(param) as T
    }
}
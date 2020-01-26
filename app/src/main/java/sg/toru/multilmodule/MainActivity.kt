package sg.toru.multilmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sg.toru.mbase_module.core.model.repository.Repo

class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    private val customViewModel:TestViewModel by lazy {
        CustomViewModelFactory("TORU!!!").create(TestViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel.resultLiveData.observe(this, Observer<String> {
//            Log.e("Toru", "returned string:: $it")
//        })
//        viewModel.trigger()
//        customViewModel.runSomething()

        viewModel.getPostAndComment("2")
    }
}

@Suppress("UNCHECKED_CAST")
class CustomViewModelFactory(private val param:String):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestViewModel(param) as T
    }
}
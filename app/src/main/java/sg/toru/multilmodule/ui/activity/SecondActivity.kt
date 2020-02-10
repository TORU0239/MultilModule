package sg.toru.multilmodule.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sg.toru.mbase_module.core.model.pojo.FeedPost
import sg.toru.multilmodule.R
import sg.toru.multilmodule.app.App
import sg.toru.multilmodule.ui.viewmodel.SecondViewModel

class SecondActivity : AppCompatActivity() {

    private val viewModel:SecondViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(SecondViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        (application as App).appComponent.injectTo(viewModel)
        viewModel.test().observe(this, Observer<List<FeedPost>>{ list ->
            Log.e("Toru", "${list.size}")
        })
    }
}

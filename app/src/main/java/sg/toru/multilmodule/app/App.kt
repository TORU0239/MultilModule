package sg.toru.multilmodule.app

import android.app.Application
import sg.toru.mbase_module.core.di.CoreComponent
import sg.toru.mbase_module.core.di.DaggerCoreComponent

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    lateinit var coreComponent: CoreComponent
    private fun init(){
        coreComponent = DaggerCoreComponent
            .builder()
            .build()

        coreComponent.injectTo(this)
    }

    private fun initAppComponent() {

    }

}
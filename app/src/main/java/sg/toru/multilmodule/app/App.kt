package sg.toru.multilmodule.app

import android.app.Application
import sg.toru.mbase_module.core.di.CoreComponent
import sg.toru.mbase_module.core.di.DaggerCoreComponent
import sg.toru.multilmodule.di.AppComponent
import sg.toru.multilmodule.di.DaggerAppComponent


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initCoreComponent()
        initAppComponent()
    }

    lateinit var coreComponent: CoreComponent
    lateinit var appComponent:AppComponent

    private fun initCoreComponent(){
        coreComponent = DaggerCoreComponent
                        .builder()
                        .build()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                        .coreComponent(coreComponent)
                        .build()
    }
}
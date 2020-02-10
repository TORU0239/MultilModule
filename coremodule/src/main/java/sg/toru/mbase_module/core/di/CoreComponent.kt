package sg.toru.mbase_module.core.di

import android.app.Application
import dagger.Component
import sg.toru.mbase_module.core.di.module.CoreModule
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun injectTo(app:Application)
}
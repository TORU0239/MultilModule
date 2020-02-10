package sg.toru.mbase_module.core.di

import android.app.Application
import dagger.Component

@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun injectTo(app:Application)
}
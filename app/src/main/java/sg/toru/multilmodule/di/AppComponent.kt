package sg.toru.multilmodule.di

import android.app.Application
import dagger.Component
import sg.toru.mbase_module.core.di.CoreComponent
import sg.toru.multilmodule.di.scope.AppScope
import sg.toru.multilmodule.ui.viewmodel.MainViewModel
import sg.toru.multilmodule.ui.viewmodel.SecondViewModel

@Component(
    modules = [AppModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface AppComponent {
    fun injectTo(app:Application)
    fun injectTo(viewModel:MainViewModel)
    fun injectTo(viewModel:SecondViewModel)
}
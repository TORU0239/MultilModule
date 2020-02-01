package sg.toru.mbase_module.core.di

import dagger.Component

@Component(modules = [CoreModule::class])
interface CoreComponent {
    fun injectTo()
}
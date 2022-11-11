package jkl4o4.noteapp.main.sl

import jkl4o4.noteapp.main.presentation.MainViewModel

class MainModule(private val provideNavigation: ProvideNavigation) : Module<MainViewModel> {

    override fun viewModel() = MainViewModel(provideNavigation.provideNavigation())
}

package jkl4o4.noteapp.main.sl

import jkl4o4.noteapp.main.presentation.NavigationCommunication

interface Core : ProvideNavigation {

    class Base : Core {

        private val navigationCommunication = NavigationCommunication.Base()

        override fun provideNavigation() = navigationCommunication

    }
}


interface ProvideNavigation {
    fun provideNavigation(): NavigationCommunication.Mutable
}
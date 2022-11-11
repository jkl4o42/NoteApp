package jkl4o4.noteapp.main.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val navigationCommunication: NavigationCommunication.Mutable
) : ViewModel(), Init, Communication.Observe<NavigationStrategy> {

    override fun init(isFirstRun: Boolean) {
        if (isFirstRun)
            navigationCommunication.map(NavigationStrategy.Replace(Screen.Notes))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<NavigationStrategy>) {
        navigationCommunication.observe(owner, observer)
    }
}
package jkl4o4.noteapp.main.sl

import androidx.lifecycle.ViewModel
import jkl4o4.noteapp.details.presentation.NoteDetailsViewModel
import jkl4o4.noteapp.details.sl.NoteDetailsModule
import jkl4o4.noteapp.main.presentation.MainViewModel
import jkl4o4.noteapp.note.presentation.NotesViewModel
import jkl4o4.noteapp.note.sl.NotesModule

interface DependencyContainer {
    fun <T : ViewModel> module(clasz: Class<T>): Module<*>

    class Error : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>): Module<*> =
            throw IllegalStateException("no module found for $clasz")
    }

    class Base(
        private val core: Core,
        private val dependencyContainer: DependencyContainer = Error()
    ) : DependencyContainer {
        override fun <T : ViewModel> module(clasz: Class<T>): Module<*> =
            when (clasz) {
                MainViewModel::class.java -> MainModule(core)
                NotesViewModel.Base::class.java -> NotesModule(core)
                NoteDetailsViewModel::class.java -> NoteDetailsModule()
                else -> dependencyContainer.module(clasz)
            }


    }
}
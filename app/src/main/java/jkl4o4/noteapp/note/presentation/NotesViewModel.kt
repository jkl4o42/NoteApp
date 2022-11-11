package jkl4o4.noteapp.note.presentation

import androidx.lifecycle.ViewModel
import jkl4o4.noteapp.main.presentation.NavigationCommunication
import jkl4o4.noteapp.main.presentation.NavigationStrategy
import jkl4o4.noteapp.main.presentation.Screen

interface NotesViewModel {

    fun showNoteDetails(item: String)

    class Base(
        private val navigationCommunication: NavigationCommunication.Mutate
    ) : ViewModel(), NotesViewModel {

        override fun showNoteDetails(item: String) {
            navigationCommunication.map((NavigationStrategy.Add(Screen.NoteDetails)))
        }

    }
}
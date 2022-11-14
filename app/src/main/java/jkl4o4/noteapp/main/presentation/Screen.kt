package jkl4o4.noteapp.main.presentation

import jkl4o4.noteapp.details.presentation.NoteDetailsFragment
import jkl4o4.noteapp.notes.presentation.NotesFragment

sealed class Screen {

    abstract fun fragment(): Class<out BaseFragment<*>>

    object Notes : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = NotesFragment::class.java
    }

    object NoteDetails : Screen() {
        override fun fragment(): Class<out BaseFragment<*>> = NoteDetailsFragment::class.java
    }
}
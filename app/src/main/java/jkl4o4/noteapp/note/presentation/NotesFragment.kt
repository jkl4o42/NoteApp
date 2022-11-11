package jkl4o4.noteapp.note.presentation

import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import jkl4o4.noteapp.R
import jkl4o4.noteapp.main.presentation.BaseFragment

class NotesFragment : BaseFragment<NotesViewModel.Base>() {
    override val layoutId = R.layout.fragment_notes
    override val viewModelClass = NotesViewModel.Base::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val createNewNote = view.findViewById<FloatingActionButton>(R.id.createNewNoteButton)
        createNewNote.setOnClickListener {
            viewModel.showNoteDetails("")
        }
    }

}
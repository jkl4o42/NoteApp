package jkl4o4.noteapp.notes.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import jkl4o4.noteapp.R
import jkl4o4.noteapp.main.presentation.BaseFragment

class NotesFragment : BaseFragment<NotesViewModel.Base>() {
    override val layoutId = R.layout.fragment_notes
    override val viewModelClass = NotesViewModel.Base::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val createNewNote = view.findViewById<FloatingActionButton>(R.id.createNewNoteButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.notesRecyclerView)

        createNewNote.setOnClickListener {
            //todo
            viewModel.showNoteDetails(NoteUi(0, ""))
        }

        val adapter = NotesAdapter(object : ClickListener {
            override fun onClick(item: NoteUi) = viewModel.showNoteDetails(item)
        })

        recyclerView.adapter = adapter

        adapter.map(
            listOf(
                NoteUi(0, "asdasdasdasasdasdasdasasdasdasdas"),
                NoteUi(1, "asdasdasdasasdasdasdasasdasdasdas"),
                NoteUi(2, "asdasdasdasasdasdasdasasdasdasdas"),
                NoteUi(3, "asdasdasdasasdasdasdasasdasdasdas"),
                NoteUi(4, "asdasdasdasasdasdasdasasdasdasdas"),
            )
        )

    }

}
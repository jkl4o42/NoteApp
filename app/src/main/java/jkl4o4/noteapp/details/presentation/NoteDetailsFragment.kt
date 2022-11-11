package jkl4o4.noteapp.details.presentation

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import jkl4o4.noteapp.R
import jkl4o4.noteapp.main.presentation.BaseFragment

class NoteDetailsFragment : BaseFragment<NoteDetailsViewModel>() {
    override val layoutId = R.layout.fragment_note_details
    override val viewModelClass = NoteDetailsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val returnImageButton = view.findViewById<ImageButton>(R.id.returnImageButton)
        returnImageButton.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}
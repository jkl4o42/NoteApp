package jkl4o4.noteapp.details.sl

import jkl4o4.noteapp.details.presentation.NoteDetailsViewModel
import jkl4o4.noteapp.main.sl.Module

class NoteDetailsModule : Module<NoteDetailsViewModel> {
    override fun viewModel() = NoteDetailsViewModel()
}
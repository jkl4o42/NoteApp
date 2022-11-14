package jkl4o4.noteapp.notes.sl

import jkl4o4.noteapp.main.sl.Module
import jkl4o4.noteapp.main.sl.ProvideNavigation
import jkl4o4.noteapp.notes.presentation.NotesViewModel

class NotesModule(private val provideNavigation: ProvideNavigation) : Module<NotesViewModel.Base> {
    override fun viewModel(): NotesViewModel.Base {
        return NotesViewModel.Base(provideNavigation.provideNavigation())
    }
}
package jkl4o4.noteapp.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jkl4o4.noteapp.R
import jkl4o4.noteapp.details.presentation.NoteDetailsFragment
import jkl4o4.noteapp.note.presentation.NotesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, NoteDetailsFragment()).commit()
    }
}
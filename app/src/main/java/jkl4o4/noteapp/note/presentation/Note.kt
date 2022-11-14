package jkl4o4.noteapp.note.presentation

import jkl4o4.noteapp.main.presentation.Mapper

data class NoteUi(private val id: Int, private val note: String) : Mapper<Boolean, NoteUi> {

    fun <T> map(mapper: Mapper<T>): T = mapper.map(id, note)

    interface Mapper<T> {
        fun map(id: Int, note: String): T
    }

    override fun map(source: NoteUi): Boolean = source.id == id
}

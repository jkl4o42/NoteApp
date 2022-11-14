package jkl4o4.noteapp.note.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jkl4o4.noteapp.R
import jkl4o4.noteapp.main.presentation.Mapper

class NotesAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<NoteViewHolder>(), Mapper.Unit<List<NoteUi>> {

    private val list = mutableListOf<NoteUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.number_layout, parent, false),
        clickListener
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    override fun map(source: List<NoteUi>) {
        val diff = DiffUtilCallback(list, source)
        val result = DiffUtil.calculateDiff(diff)
        list.clear()
        list.addAll(source)
        result.dispatchUpdatesTo(this)
    }
}

class NoteViewHolder(view: View, private val onClick: ClickListener) :
    RecyclerView.ViewHolder(view) {
    private val itemTextView = itemView.findViewById<TextView>(R.id.itemTextView)
    private val mapper = ListItemUi(itemTextView)

    fun bind(model: NoteUi) {
        model.map(mapper)
        itemView.setOnClickListener { onClick.onClick(model) }
    }

}

interface ClickListener {
    fun onClick(item: NoteUi)
}

class ListItemUi(
    private val itemText: TextView
) : NoteUi.Mapper<Unit> {
    override fun map(id: Int, note: String) {
        itemText.text = note
    }
}

class DiffUtilCallback(
    private val oldList: List<NoteUi>,
    private val newList: List<NoteUi>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].map(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].equals(newList[newItemPosition])
}

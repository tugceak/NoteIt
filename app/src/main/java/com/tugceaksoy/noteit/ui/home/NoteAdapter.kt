package com.tugceaksoy.notedapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugceaksoy.noteit.data.model.Note
import com.tugceaksoy.notedapp.databinding.ItemCardDesignBinding

class NoteAdapter(  private val listener: Listener):RecyclerView.Adapter<NoteAdapter.MyHolder>() {
    private var noteList= emptyList<Note>()
    interface Listener {
        fun onItemClick(id: Int)
    }
    class MyHolder(val binding: ItemCardDesignBinding):RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardDesignBinding.inflate(inflater, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var note = noteList[position]
        holder.binding.noteTitleText.text=note.noteInside
        holder.binding.noteInsideText.text=note.noteTitle
        holder.binding.root.setOnClickListener {
            listener.onItemClick(note.noteId)
        }
    }

    override fun getItemCount(): Int {
     return  noteList.size
    }
    fun setNoteList(_noteList: List<Note>) {
       noteList = _noteList
        notifyDataSetChanged()
    }
}
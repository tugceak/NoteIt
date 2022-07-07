package com.tugceaksoy.noteit.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tugceaksoy.noteit.data.local.RoomViewModel
import com.tugceaksoy.noteit.ui.MainActivity
import com.tugceaksoy.notedapp.ui.home.HomeFragmentDirections
import com.tugceaksoy.notedapp.ui.home.NoteAdapter
import com.tugceaksoy.noteit.databinding.FragmentHomeBinding
import com.tugceaksoy.noteit.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
), NoteAdapter.Listener {
    private val roomViewModel: RoomViewModel by viewModels()
    private val adapter: NoteAdapter by lazy { NoteAdapter(this) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).showBottomNav()
        observeNotes()
        initClick()
        initRecycler()
    }

    private fun observeNotes() {
        roomViewModel.readAllData.observe(viewLifecycleOwner, Observer { note ->
            adapter.setNoteList(note)
            setNoDataView(note.isEmpty())
        })
    }
    private fun setNoDataView(listIsEmpty: Boolean) {
        binding.noDataLayout.isVisible = listIsEmpty
    }
    private fun initRecycler() {
        binding.run {
            noteReyclerView.adapter = adapter
            noteReyclerView.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }
    private fun initClick() {
        binding.addNoteButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddNotesFragment()
            findNavController().navigate(action)
        }
    }
    override fun onItemClick(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddNotesFragment()
        findNavController().navigate(action)
    }
}
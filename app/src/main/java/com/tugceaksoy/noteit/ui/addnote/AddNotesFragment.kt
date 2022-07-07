package com.tugceaksoy.noteit.ui.addnote

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tugceaksoy.noteit.data.local.RoomViewModel
import com.tugceaksoy.noteit.data.model.Note

import com.tugceaksoy.noteit.ui.MainActivity
import com.tugceaksoy.noteit.ui.base.BaseFragment
import com.tugceaksoy.noteit.databinding.FragmentAddNotesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@AndroidEntryPoint

class AddNotesFragment : BaseFragment<FragmentAddNotesBinding>(
    FragmentAddNotesBinding::inflate
) {
    private val roomViewModel: RoomViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBottomNav()
        initClick()
    }
    private fun insertDataToDatabase() {
        var tittle = binding.noteTitle.text.toString()
        var inside = binding.note.text.toString()
        if (inputCheck(tittle, inside)){
            val note = Note(0, tittle, inside)
            roomViewModel.addNote(note)
            Toast.makeText(requireContext(),"NOTED",Toast.LENGTH_LONG).show()
            findNavController().popBackStack()
        }else{
            Toast.makeText(requireContext(),"PLEASE FILL OUT ALL FIELDS",Toast.LENGTH_LONG).show()
        }

    }
    private fun initClick(){
        binding.run{
            addButton.setOnClickListener { insertDataToDatabase() }
            backBtn.setOnClickListener {   findNavController().popBackStack() }

        }

    }
    private fun inputCheck(tittle:String ,inside:String):Boolean{
        return !(TextUtils.isEmpty(tittle)&& TextUtils.isEmpty(inside))

    }
}
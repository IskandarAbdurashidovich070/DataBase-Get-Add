package com.example.musoboqa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.musoboqa.databinding.FragmentAdd2Binding
import com.example.musoboqa.db.MyDbHelper
import com.example.musoboqa.models.User

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAdd2Binding
    private lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdd2Binding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(container!!.context)

        binding.btnSave.setOnClickListener {
            val user = User(
                name = binding.edtName.text.toString().trim(),
                number = binding.edtNumber.text.toString().trim()
            )

            if (binding.edtName.text!!.isNotEmpty() && binding.edtNumber.text!!.isNotEmpty()){
                myDbHelper.addContact(user)
                findNavController().popBackStack()
            }

        }


        return binding.root
    }


}
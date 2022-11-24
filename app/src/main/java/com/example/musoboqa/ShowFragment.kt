package com.example.musoboqa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musoboqa.adapters.MyRvAdapter
import com.example.musoboqa.adapters.OnClick
import com.example.musoboqa.databinding.FragmentShowBinding
import com.example.musoboqa.db.MyDbHelper
import com.example.musoboqa.models.User

class ShowFragment : Fragment() {
    private lateinit var binding: FragmentShowBinding
    private lateinit var rvAdapter: MyRvAdapter
    private lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(container!!.context)
        rvAdapter = MyRvAdapter(myDbHelper.getContact(), object : OnClick{
            override fun click(user: User) {
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${user.number}")))
            }

        })

        binding.rv.adapter = rvAdapter




        return binding.root
    }


}
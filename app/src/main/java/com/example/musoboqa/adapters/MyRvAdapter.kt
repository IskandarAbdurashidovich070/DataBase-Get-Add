package com.example.musoboqa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musoboqa.databinding.RvItemBinding
import com.example.musoboqa.models.User

class MyRvAdapter(var list: List<User>, var click: OnClick) : RecyclerView.Adapter<MyRvAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding):RecyclerView.ViewHolder(rvItemBinding.root){
        fun onBind(user: User, position: Int ){
           rvItemBinding.tvName.text = user.name
           rvItemBinding.tvNumber.text = user.number
            rvItemBinding.call.setOnClickListener {
                click.click(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}

interface OnClick{
    fun click(user: User)
}
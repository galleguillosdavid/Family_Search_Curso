package com.example.familysearchcurso.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.familysearchcurso.R
import com.example.familysearchcurso.model.localRoom.BasicoEntity
import kotlinx.android.synthetic.main.basic_item_list.view.*

class BasicAdapter(val mPassTheData: PassTheData) : RecyclerView.Adapter<BasicAdapter.BasicViewHolder>() {

    private var BasicList = emptyList<BasicoEntity>()

    fun updateAdapter(mList: List<BasicoEntity>) {
        BasicList = mList
        notifyDataSetChanged()
    }

    inner class BasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1 = itemView.imageView1
        val text1 = itemView.textView1
        val clickListener = itemView.setOnClickListener {
            mPassTheData.passBasic(BasicList[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.basic_item_list,
                parent, false)
        return BasicViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasicViewHolder, position: Int) {
        val Basic = BasicList[position]
        Glide.with(holder.itemView.context).load(Basic.imagen).into(holder.image1)
        holder.text1.text = Basic.nombre

    }

    override fun getItemCount() = BasicList.size
}

interface PassTheData {
    fun passBasic(mBasicEntity: BasicoEntity)
}
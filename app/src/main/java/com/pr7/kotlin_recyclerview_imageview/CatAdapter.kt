package com.pr7.kotlin_recyclerview_imageview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatAdapter constructor(
    val context: Context,
    val ismlar:Array<String>,
    val rasmlar:Array<Int>
):RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return CatViewHolder(view)
    }
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.textview.text=ismlar.get(position)
        holder.imageview.setImageResource(rasmlar.get(position))
    }

    override fun getItemCount(): Int {
        return ismlar.size
    }
    class CatViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val imageview:ImageView=itemview.findViewById(R.id.imageviewcats)
        val textview:TextView=itemview.findViewById(R.id.textviewname)

    }

}
package com.ikanurfitriani.mykdrama

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikanurfitriani.mykdrama.databinding.ItemRowDramaBinding

class ListDramaAdapter(private val listDrama : ArrayList<Drama>) : RecyclerView.Adapter<ListDramaAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data : Drama)
    }

    fun  setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowDramaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDramaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listDrama.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listDrama[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.itemName.text = name
        holder.binding.itemDescription.text = description
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listDrama[holder.adapterPosition])
        }
    }
}
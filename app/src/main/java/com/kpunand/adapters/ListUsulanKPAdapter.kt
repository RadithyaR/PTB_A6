package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.models.ListMahasiswaKP
import com.kpunand.models.ListUsulanKP

class ListUsulanKPAdapter (private val data:ArrayList<ListUsulanKP>):
    RecyclerView.Adapter<ListUsulanKPAdapter.UsulanKPViewHolder>(){
    private lateinit var UsulanKPListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        UsulanKPListener = listener
    }

    inner class UsulanKPViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val nama: TextView =itemView.findViewById(R.id.namamhs)
        private val nim:  TextView = itemView.findViewById(R.id.nimmhs)

        fun bind(data: ListUsulanKP){
            nama.text = data.nama
            nim.text = data.nim
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanKPViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_mahasiswa, parent, false)
        return UsulanKPViewHolder(view, UsulanKPListener)
    }

    override fun onBindViewHolder(holder: UsulanKPViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
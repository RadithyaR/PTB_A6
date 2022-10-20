package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.models.MahasiswaKP

class MahasiswaKPAdapter (private val data:ArrayList<MahasiswaKP>):
    RecyclerView.Adapter<MahasiswaKPAdapter.MahasiswaKPViewHolder>(){
    private lateinit var MahasiswaKPListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        MahasiswaKPListener = listener
    }

    inner class MahasiswaKPViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val nama: TextView =itemView.findViewById(R.id.namamhs)
        private val nim:  TextView = itemView.findViewById(R.id.nimmhs)

        fun bind(data: MahasiswaKP){
            nama.text = data.nama
            nim.text = data.nim
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaKPViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_mahasiswa, parent, false)
        return MahasiswaKPViewHolder(view, MahasiswaKPListener)
    }

    override fun onBindViewHolder(holder: MahasiswaKPViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.models.UsulanKP

class UsulanKPAdapter (private val data:ArrayList<UsulanKP>):
    RecyclerView.Adapter<UsulanKPAdapter.UsulanKPViewHolder>(){
    private lateinit var UsulanKPListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        UsulanKPListener = listener
    }

    inner class UsulanKPViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView) {
        private val nama: TextView =itemView.findViewById(R.id.namamhsusulan)
        private val nim: TextView = itemView.findViewById(R.id.nimmhsusulan)

        fun bind(data: UsulanKP){
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mahasiswa_usulan_kp, parent, false)
        return UsulanKPViewHolder(view, UsulanKPListener)
    }

    override fun onBindViewHolder(holder: UsulanKPViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    } }

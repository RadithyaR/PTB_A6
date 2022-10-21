package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.models.ListLaporanKP
import com.kpunand.models.ListMahasiswaKP

class ListLaporanKPAdapter (private val data:ArrayList<ListLaporanKP>):
    RecyclerView.Adapter<ListLaporanKPAdapter.LaporanKPViewHolder>(){
    private lateinit var LaporanKPListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        LaporanKPListener = listener
    }

    inner class LaporanKPViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val nama: TextView =itemView.findViewById(R.id.lapnamamhs)
        private val nim:  TextView = itemView.findViewById(R.id.lapnimmhs)
        private val instansi:  TextView = itemView.findViewById(R.id.lapinstansimhs)

        fun bind(data: ListLaporanKP){
            nama.text = data.nama
            nim.text = data.nim
            instansi.text = data.instansi
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanKPViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan_mahasiswa, parent, false)
        return LaporanKPViewHolder(view, LaporanKPListener)
    }

    override fun onBindViewHolder(holder: LaporanKPViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
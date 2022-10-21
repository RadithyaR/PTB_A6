package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.models.ListLaporanKP
import com.kpunand.models.ListLogbook
import com.kpunand.models.ListMahasiswaKP

class ListLogbookAdapter (private val data:ArrayList<ListLogbook>):
    RecyclerView.Adapter<ListLogbookAdapter.LogbookViewHolder>(){
    private lateinit var LogbookListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        LogbookListener = listener
    }

    inner class LogbookViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val hari: TextView =itemView.findViewById(R.id.hari)
        private val tanggal:  TextView = itemView.findViewById(R.id.tanggal)

        fun bind(data: ListLogbook){
            hari.text = data.hari
            tanggal.text = data.tanggal
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogbookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_logbookharian, parent, false)
        return LogbookViewHolder(view, LogbookListener)
    }

    override fun onBindViewHolder(holder: LogbookViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
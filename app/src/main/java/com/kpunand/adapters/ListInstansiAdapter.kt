package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.datamodels.CompaniesItem

class ListInstansiAdapter ()
    : RecyclerView.Adapter<ListInstansiAdapter.InstansiViewHolder>(){

    private lateinit var InstansiListener: clickListener

    var listPerusahaan: List<CompaniesItem> = ArrayList()

    fun setListIntansi(listIntansi: List<CompaniesItem>){
        this.listPerusahaan = listIntansi
        notifyDataSetChanged()
    }

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        InstansiListener = listener
    }

    inner class InstansiViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView){
        val nama: TextView =itemView.findViewById(R.id.namaIntansi)
        val alamat: TextView = itemView.findViewById(R.id.alamatInstansi)
        val status: TextView = itemView.findViewById(R.id.statusInstansi)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstansiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_instansi, parent, false)

        return InstansiViewHolder(view, InstansiListener)
    }

    override fun getItemCount(): Int {
        return listPerusahaan.size
    }

    override fun onBindViewHolder(holder: InstansiViewHolder, position: Int) {
        val item: CompaniesItem = listPerusahaan.get(position)
        holder.nama.text = item.name
        holder.alamat.text = item.address

        if(item.status == 1){
            holder.status.text = "Proposed"
        }
        else if (item.status == 2){
            holder.status.text = "On Field"
        }
    }
}
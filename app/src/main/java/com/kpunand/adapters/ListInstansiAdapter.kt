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

    var listIntansii: List<CompaniesItem> = ArrayList()

    fun setListIntansi(listIntansi: List<CompaniesItem>){
        this.listIntansii = listIntansi
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
        return listIntansii.size
    }

    override fun onBindViewHolder(holder: InstansiViewHolder, position: Int) {
        val item: CompaniesItem = listIntansii.get(position)
        holder.nama.text = item.name
        holder.alamat.text = item.address
        holder.status.text = item.status.toString()
    }
}
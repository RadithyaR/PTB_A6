package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.datamodels.CompaniesItem
import com.kpunand.datamodels.ProposalsItem
import kotlinx.android.synthetic.main.item_mahasiswa_usulan_kp.view.*

class ListUsulanKPAdapter()
    : RecyclerView.Adapter<ListUsulanKPAdapter.UsulanKPViewHolder>(){

    private lateinit var UsulanListener: clickListener

    var listUsulann: List<ProposalsItem> = ArrayList()

    fun setListUsulan(listUsulan: List<ProposalsItem>){
        this.listUsulann = listUsulan
        notifyDataSetChanged()
    }

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        UsulanListener = listener
    }

    inner class UsulanKPViewHolder(itemView: View, listener: clickListener): RecyclerView.ViewHolder(itemView){
        val nama: TextView =itemView.findViewById(R.id.namaProposal)
        val tglMulai: TextView = itemView.findViewById(R.id.mulaiProposal)
        val tglSelesai: TextView = itemView.findViewById(R.id.selesaiProposal)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsulanKPViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mahasiswa_usulan_kp, parent, false)

        return UsulanKPViewHolder(view, UsulanListener)
    }

    override fun getItemCount(): Int {
        return listUsulann.size}

    override fun onBindViewHolder(holder: UsulanKPViewHolder, position: Int) {
        val item: ProposalsItem = listUsulann.get(position)
        holder.nama.text = item.name
        holder.tglMulai.text = item.startAt
        holder.tglSelesai.text = item.endAt
    }


}
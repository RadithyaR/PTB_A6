package com.kpunand.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kpunand.R
import com.kpunand.datamodels.InternshipsItem
import kotlinx.android.synthetic.main.item_mahasiswa_usulan_kp.view.*

class ListMahasiswaKPAdapter()
    : RecyclerView.Adapter<ListMahasiswaKPAdapter.MahasiswaKPViewHolder>(){

    private lateinit var mahasiswaListener: ClickListener

    var listMahasiswaaa: List<InternshipsItem> = ArrayList()

    fun setListMahasiswa(listMahasiswaaa: List<InternshipsItem>){
        this.listMahasiswaaa = listMahasiswaaa
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: ClickListener) {
        mahasiswaListener = listener
    }

    inner class MahasiswaKPViewHolder(itemView: View, listener: ClickListener): RecyclerView.ViewHolder(itemView){
        val nama: TextView =itemView.findViewById(R.id.namaMahasiswa)
        val nim: TextView = itemView.findViewById(R.id.nimMahasiswa)
        val instansi: TextView = itemView.findViewById(R.id.instansi)
        val judul: TextView = itemView.findViewById(R.id.judul)
        val tglMulai: TextView = itemView.findViewById(R.id.tanggalMulai)
        val tglSelesai: TextView = itemView.findViewById(R.id.tanggalSelesai)
        val pembimbing: TextView = itemView.findViewById(R.id.pembimbing)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaKPViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_mahasiswa, parent, false)

        return MahasiswaKPViewHolder(view, mahasiswaListener)
    }

    override fun getItemCount(): Int {
        return listMahasiswaaa.size}

    override fun onBindViewHolder(holder: MahasiswaKPViewHolder, position: Int) {
        val item: InternshipsItem = listMahasiswaaa.get(position)
        holder.nama.text = item.name
        holder.nim.text = item.nim
        holder.instansi.text = item.instansi
        holder.judul.text = item.judul
        holder.tglMulai.text = item.startAt
        holder.tglSelesai.text = item.endAt
        holder.pembimbing.text = item.pembimbing
    }


}
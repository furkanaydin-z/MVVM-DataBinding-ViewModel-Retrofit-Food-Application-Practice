package com.example.yemekleruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemekleruygulamasi.R
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.data.entity.Yemekler
import com.example.yemekleruygulamasi.databinding.CardTasarimSepetBinding
import com.example.yemekleruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.yemekleruygulamasi.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar

class SepetAdapter(var sContext:Context, var sepetList:MutableList<SepeteYemekGetir>, var viewModel: SepetViewModel):
RecyclerView.Adapter<SepetAdapter.CardTasarimTutucuSepet>()
{

    inner class CardTasarimTutucuSepet(var sepet:CardTasarimSepetBinding):RecyclerView.ViewHolder(sepet.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucuSepet {
        val binding:CardTasarimSepetBinding = DataBindingUtil.inflate(LayoutInflater.from(sContext),R.layout.card_tasarim_sepet,parent,false)
        return CardTasarimTutucuSepet(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucuSepet, position: Int) {
        val sepet = sepetList.get(position)
        var b = holder.sepet
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepet.yemek_resim_adi}"
        Glide.with(sContext).load(url).override(500,750).into(b.cardResim)
        b.sepeteYemekEkleme = sepet
        b.tvCardAdet.text = sepet.yemek_siparis_adet.toString()



        b.ivSilSepet.setOnClickListener {
            Snackbar.make(it,"${sepet.yemek_adi} silinsin mi ?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(sepet.sepet_ekleme_id,sepet.kullanici_adi)
                }.show()
        }


    }
    override fun getItemCount(): Int {
        return sepetList.size
    }
    fun guncelle(yeniListe: List<SepeteYemekGetir>) {
        sepetList.clear()
        sepetList.addAll(yeniListe)
        notifyDataSetChanged()
    }

}
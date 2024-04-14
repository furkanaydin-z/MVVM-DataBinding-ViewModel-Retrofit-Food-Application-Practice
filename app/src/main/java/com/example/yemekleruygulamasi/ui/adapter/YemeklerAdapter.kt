package com.example.yemekleruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemekleruygulamasi.R
import com.example.yemekleruygulamasi.data.entity.Yemekler
import com.example.yemekleruygulamasi.databinding.CardTasarimBinding
import com.example.yemekleruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.yemekleruygulamasi.ui.fragment.DetayFragment
import com.example.yemekleruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class YemeklerAdapter(var mContext:Context, var yemeklerList: List<Yemekler>, var viewModel:AnasayfaViewModel)
    :RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
    val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(binding)
    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerList.get(position)
        val t = holder.tasarim

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(500,750).into(t.imageViewYemek)
        t.yemekAnasayfaNesnesi = yemek




        t.cardViewYemek.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
            Log.e("sepet","$yemek")
        }
        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"Geçiş Yapılsın mı",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    Snackbar.make(it,"Geçiş Yapılıyor",Snackbar.LENGTH_SHORT).show()
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yemeklerList.size
    }
}
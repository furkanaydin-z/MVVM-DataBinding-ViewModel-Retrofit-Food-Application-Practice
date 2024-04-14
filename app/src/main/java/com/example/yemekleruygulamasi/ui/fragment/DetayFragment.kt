package com.example.yemekleruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.yemekleruygulamasi.R
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.databinding.FragmentDetayBinding
import com.example.yemekleruygulamasi.ui.viewmodel.DetayViewModel
import com.example.yemekleruygulamasi.ui.viewmodel.SepetViewModel
import com.example.yemekleruygulamasi.util.extension.gecisYap
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
   private var counter = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        binding.yemekDetayFragment = this




        val bundle: DetayFragmentArgs by navArgs()
        val yemek = bundle.yemek
        binding.yemekNesnesi = yemek
        binding.counter = counter
        binding.detayToolbar = yemek.yemek_adi

        val sepetGecisNesnesi = SepeteYemekGetir(1,"","",0,0,"")
        binding.sepeteYemekGetirNesnesi = sepetGecisNesnesi


        var url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,750).into(binding.ivResim)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun fabButtonPlus(yemekAdet:String,yemekGuncelFiyat:String){
        counter++
        binding.counter = counter
        Log.e("toplama","$yemekAdet--$yemekGuncelFiyat")
    }
    fun fabButtonMinus(yemekAdet:String,yemekGuncelFiyat:String){
        counter--
        binding.counter = counter
        Log.e("toplama","$yemekAdet--$yemekGuncelFiyat")
    }
    fun sepeteKaydet(kulllanici_adi:String,yemek_siparis_adet:Int){
        viewModel.kaydet(kulllanici_adi,yemek_siparis_adet)
        binding.buttonEkle.setOnClickListener {
            Navigation.gecisYap(it,R.id.sepetGecis)
            Log.e("butondeneme","$kulllanici_adi---$yemek_siparis_adet")
        }
    }
}
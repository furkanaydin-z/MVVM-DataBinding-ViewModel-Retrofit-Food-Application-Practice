package com.example.yemekleruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yemekleruygulamasi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor (var yrepo:YemeklerRepository):ViewModel() {
   fun kaydet(kullanici_adi:String,yemek_siparis_adet:Int){
       CoroutineScope(Dispatchers.Main).launch {
           yrepo.kaydet(kullanici_adi,yemek_siparis_adet)


       }

    }
}
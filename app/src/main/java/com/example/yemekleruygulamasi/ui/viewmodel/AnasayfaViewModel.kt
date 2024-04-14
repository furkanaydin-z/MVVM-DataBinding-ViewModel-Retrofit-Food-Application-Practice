package com.example.yemekleruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekleruygulamasi.data.entity.Yemekler
import com.example.yemekleruygulamasi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var yrepo:YemeklerRepository):ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    init {
        yemekleriYukle()
    }


     fun yemekleriYukle(){
         CoroutineScope(Dispatchers.Main).launch {
             try {
                 yemeklerListesi.value = yrepo.yemekleriYukle()

             }catch (e:Exception){}
         }
     }
}
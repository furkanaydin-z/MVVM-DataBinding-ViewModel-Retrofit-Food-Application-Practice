package com.example.yemekleruygulamasi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor (var yrepo:YemeklerRepository):ViewModel() {
    var sepetListesi = MutableLiveData<List<SepeteYemekGetir>>()

    init {
        sepetiYukle("furkaaaan")
    }

    fun sil(id:Int, kullanici_adi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.sil(id,kullanici_adi)



        }
    }

     fun sepetiYukle(kullanici_adi: String){
         CoroutineScope(Dispatchers.Main).launch {
             try {
                 sepetListesi.value = yrepo.sepetiYukle(kullanici_adi)




             }catch (e:Exception){}

         }
     }

}
package com.example.yemekleruygulamasi.data.datasource

import android.util.Log
import androidx.navigation.Navigation
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.data.entity.Yemekler
import com.example.yemekleruygulamasi.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var ydao:YemeklerDao) {

    suspend fun sepetiYukle(kullanici_adi: String):List<SepeteYemekGetir> =
        withContext(Dispatchers.IO){

            return@withContext ydao.yemekleriGetir(kullanici_adi).sepet_yemekler
        }

    suspend fun yemekleriYukle():List<Yemekler> =
        withContext(Dispatchers.IO){

            return@withContext ydao.yemekleriYukle().yemekler
        }
    suspend fun kaydet(kullanici_adi: String,yemek_siparis_adet:Int){
        ydao.kaydet(kullanici_adi,yemek_siparis_adet)
    }
   suspend fun sil(id:Int, kullanici_adi:String){
        ydao.sil(id,kullanici_adi)

   }
}
package com.example.yemekleruygulamasi.data.repo

import com.example.yemekleruygulamasi.data.datasource.YemeklerDataSource
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.data.entity.Yemekler

class YemeklerRepository(var yds:YemeklerDataSource) {

   suspend fun kaydet (kullanici_adi: String,yemek_siparis_adet:Int) = yds.kaydet(kullanici_adi,yemek_siparis_adet)
    suspend fun sil(id:Int, kullanici_adi:String) = yds.sil(id,kullanici_adi)
    suspend fun yemekleriYukle():List<Yemekler> = yds.yemekleriYukle()
    suspend fun sepetiYukle(kullanici_adi: String):List<SepeteYemekGetir> = yds.sepetiYukle(kullanici_adi)
}
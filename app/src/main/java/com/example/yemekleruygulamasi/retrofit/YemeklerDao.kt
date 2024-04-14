package com.example.yemekleruygulamasi.retrofit

import com.example.yemekleruygulamasi.data.entity.DeleteSepeteYemekEklemeCevap
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetir
import com.example.yemekleruygulamasi.data.entity.SepeteYemekGetirCevap
import com.example.yemekleruygulamasi.data.entity.YemeklerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle():YemeklerCevap

   // yemekler/sepeteYemekEkle.php
    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun kaydet( @Field("kullanici_adi") kullanici_adi:String= "furkaaaan",
                       @Field("yemek_siparis_adet") yemek_siparis_adet:Int)
                      :DeleteSepeteYemekEklemeCevap

    @POST("http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun sil(@Field ("sepet_yemek_id") id:Int,
                    @Field ("kullanici_adi") kullanici_adi:String= "furkaaaan") : DeleteSepeteYemekEklemeCevap

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun yemekleriGetir(@Field("kullanici_adi") kullanici_adi: String="furkaaaan"):SepeteYemekGetirCevap




}
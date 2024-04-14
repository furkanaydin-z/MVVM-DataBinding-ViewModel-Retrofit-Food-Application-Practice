package com.example.yemekleruygulamasi.data.entity

data class SepeteYemekGetir(var sepet_ekleme_id:Int,
                            var yemek_adi:String,
                            var yemek_resim_adi:String,
                            var yemek_fiyat:Int,
                            var yemek_siparis_adet:Int,
                            var kullanici_adi:String,)

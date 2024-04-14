package com.example.yemekleruygulamasi.util.extension

import android.view.View
import androidx.navigation.Navigation
import com.example.yemekleruygulamasi.R

fun Navigation.gecisYap(it: View,id:Int){
    findNavController(it).navigate(id)

}
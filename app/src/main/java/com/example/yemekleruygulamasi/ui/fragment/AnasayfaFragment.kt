package com.example.yemekleruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemekleruygulamasi.R
import com.example.yemekleruygulamasi.data.entity.Yemekler
import com.example.yemekleruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.yemekleruygulamasi.ui.adapter.YemeklerAdapter
import com.example.yemekleruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.yemekleruygulamasi.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)

        binding.anasayfaToolbar = "Anasayfa"

       viewModel.yemeklerListesi.observe(viewLifecycleOwner){
           val yemeklerAdapter = YemeklerAdapter(requireContext(),it,viewModel)
           binding.yemeklerAdapter = yemeklerAdapter

       }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

}
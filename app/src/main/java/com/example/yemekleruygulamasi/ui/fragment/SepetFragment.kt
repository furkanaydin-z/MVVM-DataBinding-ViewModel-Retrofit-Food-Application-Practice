package com.example.yemekleruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.yemekleruygulamasi.R
import com.example.yemekleruygulamasi.databinding.FragmentSepetBinding
import com.example.yemekleruygulamasi.ui.adapter.SepetAdapter
import com.example.yemekleruygulamasi.ui.viewmodel.SepetViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    private lateinit var adapter:SepetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container,false)
        binding.sepetToolbar = "Sepet"

      /* viewModel.sepetListesi.observe(viewLifecycleOwner){
           Log.e("SepetFragment", "Yeni sepet listesi: $it")
           val sepetAdapter = SepetAdapter(requireContext(),it,viewModel)
           binding.sepetNesnesi = sepetAdapter
       }*/

        viewModel.sepetListesi.observe(viewLifecycleOwner) { yeniListe ->
            Log.e("SepetFragment", "Yeni sepet listesi: $yeniListe")
            adapter = SepetAdapter(requireContext(), mutableListOf(), viewModel)

            binding.sepetNesnesi = adapter
            adapter.guncelle(yeniListe)

        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepetiYukle("furkaaaan")
    }

}
package com.uct.recyclerhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uct.recyclerhouse.databinding.FragmentEducationBinding
import com.uct.recyclerhouse.adapter.EducationTipAdapter

class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    private val educationalTips = listOf(
        "Reduce el uso de plásticos de un solo uso",
        "Composta tus residuos orgánicos",
        "Dona la ropa que ya no uses",
        "Utiliza bolsas reutilizables para tus compras",
        "Repara los objetos en lugar de desecharlos"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = EducationTipAdapter(educationalTips)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.uct.recyclerhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uct.recyclerhouse.databinding.FragmentCentersBinding
import com.uct.recyclerhouse.adapter.RecyclingCenterAdapter
import com.uct.recyclerhouse.model.RecyclingCenter

class CentersFragment : Fragment() {

    private var _binding: FragmentCentersBinding? = null
    private val binding get() = _binding!!

    private val recyclingCenters = listOf(
        RecyclingCenter("Centro de Reciclaje Municipal", "1.2 km"),
        RecyclingCenter("EcoRecicla", "2.5 km"),
        RecyclingCenter("Recicladora Verde", "3.8 km")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCentersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = RecyclingCenterAdapter(recyclingCenters)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

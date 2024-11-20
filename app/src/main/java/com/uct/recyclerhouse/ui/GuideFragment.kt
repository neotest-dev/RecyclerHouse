package com.uct.recyclerhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uct.recyclerhouse.R
import com.uct.recyclerhouse.databinding.FragmentGuideBinding
import com.uct.recyclerhouse.model.WasteType
import com.uct.recyclerhouse.adapter.WasteTypeAdapter

class GuideFragment : Fragment() {

    private var binding: FragmentGuideBinding? = null

    private val wasteTypes = listOf(
        WasteType("Orgánicos", "Restos de comida, cáscaras, etc.", R.drawable.ic_organic),
        WasteType("Plástico", "Botellas, envases, bolsas", R.drawable.ic_plastic),
        WasteType("Vidrio", "Botellas, frascos", R.drawable.ic_glass),
        WasteType("Papel", "Periódicos, revistas, cajas", R.drawable.ic_paper),
        WasteType("Electrónicos", "Baterías, cables, pequeños dispositivos", R.drawable.ic_electronic)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuideBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.adapter = WasteTypeAdapter(this@GuideFragment.context, wasteTypes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

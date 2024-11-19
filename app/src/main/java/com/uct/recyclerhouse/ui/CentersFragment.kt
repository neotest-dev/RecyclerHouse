package com.uct.recyclerhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uct.recyclerhouse.R
import com.uct.recyclerhouse.databinding.FragmentCentersBinding
import com.uct.recyclerhouse.adapter.RecyclingCenterAdapter
import com.uct.recyclerhouse.model.RecyclingCenter

class CentersFragment : Fragment() {

    private var _binding: FragmentCentersBinding? = null
    private val binding get() = _binding!!

    private val recyclingCenters = listOf(
        RecyclingCenter("Consorcio Reciclador del Norte", "17 km", R.drawable.norte, "https://www.google.com/maps/dir/-8.2166918,-78.979217/WX3X%2B62R+Consorcio+Reciclador+del+Norte,+Av.+Cam.+Real,+Trujillo+13007/@-8.156997,-79.041188,13z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91ad17cfa7afac0b:0x32cf7922cd281fbf!2m2!1d-79.0024881!2d-8.0968834?entry=ttu&g_ep=EgoyMDI0MTExMy4xIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("Recicladora Manuelita SAC", "22.8 km", R.drawable.manuelita, "https://www.google.com/maps/dir/-8.2166918,-78.979217/Recicladora+Manuelita+SAC,+Mza.+C2+Lote.+18,+La+Esperanza/@-8.1336702,-79.1040717,12z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91ad3f399238d273:0x3270fc6df71c5f5b!2m2!1d-79.0640931!2d-8.0529703?entry=ttu&g_ep=EgoyMDI0MTExMy4xIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("NINO MULTISERVICIOS SAC", "4.2 km", R.drawable.nino, "https://www.google.com/maps/dir/-8.2166918,-78.979217/EMPRESA+OPERADORA+DE+RESIDUOS+SOLIDOS+NINO+MULTISERVICIOS+SAC,+13600,+Moche+13600/@-8.2006816,-79.0080272,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91ad199addcb172d:0x7b8f16baf7a72582!2m2!1d-78.9954749!2d-8.1842494?entry=ttu&g_ep=EgoyMDI0MTExMy4xIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("Recicladora Evans (Moche)", "6.2 km", R.drawable.evans, "https://www.google.com/maps/dir/-8.2166918,-78.979217/RXHX%2BC55+Recicladora+Evans+(Moche),+Moche+13600/@-8.1934638,-79.0120206,14z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x91ad19f8a0afec31:0xbf473004ef62648d!2m2!1d-79.003572!2d-8.1698138?entry=ttu&g_ep=EgoyMDI0MTExMy4xIKXMDSoASAFQAw%3D%3D"),
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

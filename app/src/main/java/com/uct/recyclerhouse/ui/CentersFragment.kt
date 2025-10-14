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
        RecyclingCenter("Consorcio Reciclador del Norte", "9.2 km", R.drawable.norte, "https://www.google.com/maps/dir/UNIVERSIDAD+CAT%C3%93LICA+DE+TRUJILLO,+Autopista+Panamericana+Norte,+Moche/WX3X%2B62R+Consorcio+Reciclador+del+Norte,+Av.+Cam.+Real,+Trujillo+13007/@-8.1285451,-79.0497,13z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x91ad18025673c245:0x4cfb84e80503a243!2m2!1d-79.0114235!2d-8.1603809!1m5!1m1!1s0x91ad17cfa7afac0b:0x32cf7922cd281fbf!2m2!1d-79.0024881!2d-8.0968834!3e0?entry=ttu&g_ep=EgoyMDI1MTAwOC4wIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("Recicladora Manuelita SAC", "15 km", R.drawable.manuelita, "https://www.google.com/maps/dir/UNIVERSIDAD+CAT%C3%93LICA+DE+TRUJILLO,+Autopista+Panamericana+Norte,+Moche/Recicladora+Manuelita+SAC,+Mza.+C2+Lote.+18,+La+Esperanza/@-8.1307335,-79.0645125,13z/data=!4m13!4m12!1m5!1m1!1s0x91ad18025673c245:0x4cfb84e80503a243!2m2!1d-79.0114235!2d-8.1603809!1m5!1m1!1s0x91ad3f399238d273:0x3270fc6df71c5f5b!2m2!1d-79.0640931!2d-8.0529703?entry=ttu&g_ep=EgoyMDI1MTAwOC4wIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("NINO MULTISERVICIOS SAC", "3.4 km", R.drawable.nino, "https://www.google.com/maps/dir/-8.1605472,-79.0119624/-8.1841978,-78.9958056/@-8.1765119,-79.002115,15z?entry=ttu&g_ep=EgoyMDI1MTAwOC4wIKXMDSoASAFQAw%3D%3D"),
        RecyclingCenter("Recicladora Evans (Moche)", "1.4 km", R.drawable.evans, "https://www.google.com/maps/dir/-8.1601717,-79.0120209/-8.169885,-79.0037378/@-8.1667174,-79.0092524,15.75z?entry=ttu&g_ep=EgoyMDI1MTAwOC4wIKXMDSoASAFQAw%3D%3D"),
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

package com.uct.recyclerhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.uct.recyclerhouse.R
import com.uct.recyclerhouse.adapter.EducationTipAdapter
import com.uct.recyclerhouse.databinding.FragmentEducationBinding

class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    private val educationalTips = mutableListOf(
        "Reduce el uso de plásticos de un solo uso",
        "Composta tus residuos orgánicos",
        "Dona la ropa que ya no uses",
        "Utiliza bolsas reutilizables para tus compras",
        "Repara los objetos en lugar de desecharlos"
    )

    private lateinit var adapter: EducationTipAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EducationTipAdapter(educationalTips) { selectedTip ->
            showTipDetail(selectedTip)
            moveItemToTop(selectedTip)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    private fun showTipDetail(tip: String) {
        binding.detailContainer.visibility = View.VISIBLE
        var tipEdit: String? = null
        var imageResId = R.drawable.ic_placeholder

        when (tip) {
            "Reduce el uso de plásticos de un solo uso" -> {
                tipEdit = """
                $tip
                
                El plástico de un solo uso, como bolsas, botellas y pajillas, tarda cientos de años en descomponerse y genera un gran impacto en los océanos y la fauna marina.
                
                ¿Qué puedes hacer?
                1. Usa botellas reutilizables de acero inoxidable o vidrio.
                2. Lleva tus propios cubiertos y envases cuando comas fuera.
                3. Compra productos a granel para evitar envases innecesarios.
                4. Rechaza productos envueltos en plástico cuando sea posible.
                
                ¡Recuerda que cada pequeño cambio suma!
            """.trimIndent()
                imageResId = R.drawable.ed_plastico
            }
            "Composta tus residuos orgánicos" -> {
                tipEdit = """
                $tip
                
                La composta es un proceso natural que transforma restos de comida y materiales orgánicos en un abono rico en nutrientes para las plantas. Esto reduce la cantidad de basura que enviamos a los vertederos y mejora la salud del suelo.
                
                Pasos para compostar:
                1. Separa los restos orgánicos como cáscaras de frutas, vegetales, café y hojas secas.
                2. Consigue un compostero o haz uno en casa con un contenedor con orificios para ventilación.
                3. Alterna capas de residuos húmedos (restos de comida) con secos (hojas, cartón, aserrín).
                4. Remueve la mezcla cada semana para airearla.
                5. Después de 2 a 3 meses, obtendrás un abono natural para tus plantas.
                
                ¡Contribuye a un ambiente más limpio y a jardines más saludables!
            """.trimIndent()
                imageResId = R.drawable.ed_composta
            }
            "Dona la ropa que ya no uses" -> {
                tipEdit = """
                $tip
                
                Donar ropa es una excelente manera de ayudar a quienes lo necesitan y de reducir el impacto ambiental que genera la industria textil. Millones de toneladas de ropa terminan en vertederos cada año.
                
                Pasos para donar ropa:
                1. Revisa tu guardarropa y selecciona prendas en buen estado que ya no uses.
                2. Lava y ordena las prendas para que estén listas para usarse.
                3. Busca organizaciones, iglesias o refugios locales que acepten donaciones.
                4. También puedes entregar ropa a proyectos de reciclaje textil.
                
                Tip adicional:
                Si tienes prendas dañadas, considera repararlas, usarlas como trapos o llevarlas a centros de reciclaje específicos.
            """.trimIndent()
                imageResId = R.drawable.ed_ropa
            }
            "Utiliza bolsas reutilizables para tus compras" -> {
                tipEdit = """
                $tip
                
                Las bolsas de plástico son una de las principales fuentes de contaminación. Usar bolsas reutilizables es una forma sencilla de reducir este impacto.
                
                Beneficios de las bolsas reutilizables:
                - Reducen la cantidad de plástico en el medio ambiente.
                - Son más resistentes y prácticas.
                - Ahorras dinero evitando comprar bolsas plásticas.
                
                Consejos prácticos:
                1. Compra bolsas de materiales resistentes como algodón, yute o poliéster reciclado.
                2. Mantén varias bolsas reutilizables en tu auto o mochila para no olvidarlas.
                3. Límpialas regularmente para mantenerlas higiénicas.
                
                ¡Haz de las bolsas reutilizables una parte de tu rutina!
            """.trimIndent()
                imageResId = R.drawable.ed_bolsas
            }
            "Repara los objetos en lugar de desecharlos" -> {
                tipEdit = """
                $tip
                
                Reparar en lugar de desechar es una práctica clave para combatir el consumismo y reducir la cantidad de residuos que terminan en los vertederos.
                
                ¿Qué puedes reparar?
                - Electrónicos: Cambia piezas como pantallas o baterías.
                - Ropa: Cose pequeños agujeros o reemplaza botones.
                - Muebles: Refuerza estructuras o líjalos y píntalos para darles una nueva vida.
                
                Pasos básicos para reparar:
                1. Identifica si el objeto tiene solución y cuál es el problema.
                2. Consulta tutoriales en línea o manuales de reparación.
                3. Usa herramientas adecuadas o acude a talleres especializados.
                4. Prueba el objeto reparado antes de usarlo nuevamente.
                
                ¡Dale una segunda vida a tus objetos y ahorra dinero!
            """.trimIndent()
                imageResId = R.drawable.ed_reparar
            }
            else -> {
                tipEdit = "Consejo no reconocido. Por favor, selecciona uno válido."
            }
        }

        binding.tipDetailText.text = tipEdit
        binding.tipImage.setImageResource(imageResId)
    }


    private fun moveItemToTop(selectedTip: String) {
        val index = educationalTips.indexOf(selectedTip)
        if (index >= 0) {
            educationalTips.removeAt(index)
            educationalTips.add(0, selectedTip)
            adapter.notifyItemMoved(index, 0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

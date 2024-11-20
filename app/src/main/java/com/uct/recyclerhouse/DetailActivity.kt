package com.uct.recyclerhouse

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.firestore.FirebaseFirestore

class DetailActivity : AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var general: TextView
    private lateinit var tipos: TextView
    private lateinit var beneficios: TextView
    private lateinit var precauciones: TextView
    private lateinit var message: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        firestore = FirebaseFirestore.getInstance()

        general = findViewById(R.id.txtGeneral)
        tipos = findViewById(R.id.txtTipos)
        beneficios = findViewById(R.id.txtBeneficios)
        precauciones = findViewById(R.id.txtPrecauciones)

        message = intent.getStringExtra("MESSAGE_KEY").toString()
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Reciclaje de " + message)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        loadDataFromFirestore()
    }

    private fun loadDataFromFirestore() {
        var messageChange = message.lowercase()
        messageChange = messageChange.replace("[áÁ]".toRegex(), "a")
            .replace("[éÉ]".toRegex(), "e")
            .replace("[íÍ]".toRegex(), "i")
            .replace("[óÓ]".toRegex(), "o")
            .replace("[úÚ]".toRegex(), "u")
        val documentRef = messageChange.let { firestore.collection("informacion").document(it) }
        documentRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val generalText = documentSnapshot.getString("general")

                    val tiposRaw = documentSnapshot.get("tipos")

                    val tiposText = when (tiposRaw) {
                        is Map<*, *> -> {
                            tiposRaw.entries.joinToString("\n") { "• ${it.key}: ${it.value}" }
                        }

                        is List<*> -> {
                            tiposRaw.joinToString("\n") { "• " + it.toString() }
                        }

                        is Array<*> -> {
                            tiposRaw.joinToString("\n") { "• " + it.toString() }
                        }

                        else -> {
                            "No disponible"
                        }
                    }

                    val beneficiosRaw = documentSnapshot.get("beneficios") as? List<*>
                    val beneficiosText =
                        beneficiosRaw?.joinToString("\n") { "• $it" } ?: "No disponible"

                    val precaucionesRaw = documentSnapshot.get("precauciones") as? List<*>
                    val precaucionesText =
                        precaucionesRaw?.joinToString("\n") { "• $it" } ?: "No disponible"

                    general.text = generalText ?: "No disponible"
                    tipos.text = tiposText
                    beneficios.text = beneficiosText
                    precauciones.text = precaucionesText
                } else {
                    // Si no se encuentra el documento
                    general.text = "Datos no encontrados"
                    tipos.text = "Datos no encontrados"
                    beneficios.text = "Datos no encontrados"
                    precauciones.text = "Datos no encontrados"
                }
            }
            .addOnFailureListener {
                // En caso de error al cargar los datos
                general.text = "Error al cargar los datos"
                tipos.text = "Error al cargar los datos"
                beneficios.text = "Error al cargar los datos"
                precauciones.text = "Error al cargar los datos"
            }
    }
}
package com.example.intentexplicitokotlin
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentexplicitokotlin.databinding.ActivityMainBinding //import requerido
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //para poder llamar a los elementos
        setContentView(binding.root) //necesario

        binding.btnEvaluar.setOnClickListener {
            //si el user escribe algo que no sea número, devuelve null en lugar de dar error
            val mates  = binding.txtMates.text.toString().trim().toIntOrNull()
            val fisica = binding.txtFisica.text.toString().trim().toIntOrNull()
            val quimica= binding.txtQuimica.text.toString().trim().toIntOrNull()

            //Aquí compruebo que las variables son válidas(un poco de seguridad jaja)
            //creo la lista y compruebo que TODAS no sean NI NULAS y que ESTÉN ENTRE EL 0 Y EL 10
            val ok = listOf(mates, fisica, quimica).all { it != null && it in 0..10 }
            //si lo anterior no es verdad, entra en el if siguiente y no hace nada
            if (!ok) return@setOnClickListener

            //Por último, si los 3 están bien= envía un Intent q es un mensaje que indica a android que abrir
            startActivity(
                Intent(this, SegundaActivity::class.java).apply {

                    putExtra("Mates", mates!!) //la exclamacióm se usa para decir "estoy segura de que no es NULL"
                    putExtra("Fisica", fisica!!)
                    putExtra("Quimica", quimica!!)

                }
            )
        }
    }
}
package com.example.intentexplicitokotlin
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentexplicitokotlin.databinding.ActivitySegundaBinding
import kotlin.math.roundToInt
class SegundaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)//convierte el archivo activity_segunda.xml en un objeto Kotlin con acceso directo a sus vistas
        setContentView(binding.root)

        val mates = intent.getIntExtra("Mates", -1) //recoge el valor enviado con la clave Mates
        val fisica = intent.getIntExtra("Fisica", -1)
        val quimica = intent.getIntExtra("Quimica", -1)

        binding.lblNotaMates.text = "Nota de Matemáticas $mates" //Se concatena en kotlin la nota de mates y se pone en el label
        binding.lblNotaFisica.text = "Nota de Física $fisica"
        binding.lblNotaQumica.text = "Nota de Química $quimica"

        val media = ((mates + fisica + quimica) / 3.0).roundToInt() //la media de las notas

        val resultado = if (media < 5) "Suspenso" else "Aprobado"

        binding.lblNotaFinal.text = "$resultado con $media de media"
    }
}

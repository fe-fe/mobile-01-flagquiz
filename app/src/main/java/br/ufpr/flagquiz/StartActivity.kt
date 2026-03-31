package br.ufpr.flagquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartActivity : AppCompatActivity() {

    private val paises = Pais.sortear()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val flagStart = findViewById<ImageView>(R.id.StartFlagView)
        flagStart.setImageResource(paises[0].imagem)

    }

    fun start_game(view: View) {
        val nomeInput = findViewById<EditText>(R.id.NomeInputTextView)
        val nome = nomeInput.text.toString().trim()
        if (nome == "") {
            Toast.makeText(this, "Digite seu nome para começar!", Toast.LENGTH_LONG).show()
            return
        }
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("nome", nome)
        startActivity(intent)
    }
}
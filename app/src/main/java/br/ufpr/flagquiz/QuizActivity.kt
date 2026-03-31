package br.ufpr.flagquiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {

    private val paises = Pais.sortear(5)
    private var indiceAtual = 0
    private var pontuacao = 0
    private lateinit var perguntaText: TextView
    private lateinit var flagImage: ImageView
    private lateinit var flagName: TextView
    private lateinit var input: EditText
    private lateinit var botaoProximo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        perguntaText = findViewById(R.id.PerguntasTextView)
        flagImage = findViewById(R.id.FlagQuizView)
        flagName = findViewById(R.id.NomeTextView)
        input = findViewById(R.id.GuessInputTextView)
        botaoProximo = findViewById(R.id.NextButton)
        mostrarPergunta()
    }

    private fun mostrarPergunta() {
        val paisAtual = paises[indiceAtual]

        flagImage.setImageResource(paisAtual.imagem)
        flagName.text = paisAtual.nome
        perguntaText.text = "Pergunta ${indiceAtual + 1} de ${paises.size}"
        flagName.visibility = View.INVISIBLE
        input.text.clear()
        botaoProximo.visibility = View.GONE
    }

    fun guess_flag(view: View) {
        val resposta = input.text.toString().trim()

        if (resposta == "") {
            Toast.makeText(this, "Digite o nome do país!", Toast.LENGTH_SHORT).show()
            return
        }

        val respostaUsuario = resposta.uppercase()
        val respostaCorreta = paises[indiceAtual].nome.uppercase()

        flagName.visibility = View.VISIBLE

        if (respostaUsuario == respostaCorreta) {
            pontuacao += 20
            flagName.setTextColor(Color.GREEN)
        } else {
            flagName.setTextColor(Color.RED)
        }
        botaoProximo.visibility = View.VISIBLE
    }

    fun nextQuestion(view: View) {
        indiceAtual++
        if (indiceAtual < paises.size) {
            mostrarPergunta()
        } else {
            Toast.makeText(
                this,
                "Fim do quiz! Pontuação: $pontuacao",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
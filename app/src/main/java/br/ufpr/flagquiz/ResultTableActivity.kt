package br.ufpr.flagquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultTableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_table)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tableLayout = findViewById<TableLayout>(R.id.resultsTableLayout)

        val usuariosOrdenados = Usuario.listaUsuarios.sortedByDescending { it.pontuacao }

        for (usuario in usuariosOrdenados) {
            val tableRow = TableRow(this)
            tableRow.setPadding(8, 8, 8, 8)

            val textViewNome = TextView(this)
            textViewNome.text = usuario.nome
            textViewNome.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            textViewNome.setPadding(4, 4, 4, 4)

            val textViewPontuacao = TextView(this)
            textViewPontuacao.text = usuario.pontuacao.toString()
            textViewPontuacao.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)
            textViewPontuacao.gravity = android.view.Gravity.END
            textViewPontuacao.setPadding(4, 4, 4, 4)

            tableRow.addView(textViewNome)
            tableRow.addView(textViewPontuacao)

            tableLayout.addView(tableRow)
        }
    }

    fun voltarParaInicio(view: View) {
        val intent = Intent(this, StartActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}

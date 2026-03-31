package br.ufpr.flagquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pais(val nome: String, val imagem: Int): Parcelable {
    companion object {
        private val paises = listOf(
            Pais("Brasil", R.drawable.br),
            Pais("Itália", R.drawable.it),
            Pais("Angola", R.drawable.ao),
            Pais("Coréia", R.drawable.kr),
            Pais("Alemanha", R.drawable.de),
            Pais("Albania", R.drawable.al),
            Pais("Austrália", R.drawable.au),
            Pais("Grécia", R.drawable.gr),
            Pais("Canadá", R.drawable.ca),
            Pais("Luxemburgo", R.drawable.lu),
            Pais("Porto Rico", R.drawable.pr),
            Pais("Rússia", R.drawable.ru),
            Pais("Finlândia", R.drawable.fi),
            Pais("Egito", R.drawable.eg),
            Pais("Suíça", R.drawable.ch),
            Pais("França", R.drawable.fr),
            Pais("Gana", R.drawable.gh),
            Pais("Reino Unido", R.drawable.gb),
            Pais("Japão", R.drawable.jp),
            Pais("Botsuana", R.drawable.bw),
        )

        fun sortear(limite: Int = paises.size): List<Pais> {
            val paisesSorteados = paises.shuffled()
            return paisesSorteados.take(limite)
        }
    }
    // gerado automaticamente
}

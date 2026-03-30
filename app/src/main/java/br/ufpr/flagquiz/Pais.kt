package br.ufpr.flagquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pais(val nome: String, val imagem: Int): Parcelable {
    companion object {
        private val paises = listOf(
            Pais("Brazil", R.drawable.br),
            Pais("Italia", R.drawable.it),
            Pais("Angola", R.drawable.ao),
            Pais("Coréia", R.drawable.kr),
            Pais("Alemanha", R.drawable.de)
        )

        fun embaralhar(limite: Int = paises.size): List<Pais> {
            val paises_embaralhados = paises.shuffled()
            return paises_embaralhados.take(limite)
        }
    }
    // gerado automaticamente
}

package br.ufpr.flagquiz

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(val nome: String, val pontuacao: Int) : Parcelable {
    companion object {
        val listaUsuarios = mutableListOf<Usuario>()
    }
}

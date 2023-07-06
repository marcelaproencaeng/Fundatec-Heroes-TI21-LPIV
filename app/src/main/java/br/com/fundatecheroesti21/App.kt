package br.com.fundatecheroesti21

import android.app.Application
import android.content.Context


class App : Application() {

    companion object {
        private lateinit var instance: App
        val context: Context
            get() = instance
    }

    init {
        instance = this
    }
}
////    Tela de splash deve consultar no banco de dados se já existe um usuário se existir
////    e o tempo do ultimo login for maior que 10 minutos devemos
////    levar o usuário para a tela de login, caso não exista o usuário no banco de dados devemos levar
////    o usuário direto para tela de login
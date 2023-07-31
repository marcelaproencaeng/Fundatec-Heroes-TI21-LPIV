package br.com.fundatecheroesti21.profile.data.local

import android.content.Context
import br.com.fundatecheroesti21.App
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class LocalData {
    private val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    val p = App.context.getSharedPreferences("bd", Context.MODE_PRIVATE)

    fun getUserId(): Int {
        val userString = p.getString("user", "")
        val characterFromPreferences: User = moshi.adapter(User::class.java)
            .fromJson(userString)!!
        return characterFromPreferences.id
    }

    fun saveUser(user: User) {
        val userString = moshi.adapter(User::class.java).toJson(user)
        p.edit().putString("user", userString).commit()
    }
}
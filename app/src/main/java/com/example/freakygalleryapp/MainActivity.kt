package com.example.freakygalleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.freakygalleryapp.databinding.FotosBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fotosBinding = FotosBinding.inflate(layoutInflater)
        setContentView(fotosBinding.root)

        var lista = mutableListOf<Foto>()
        for(i in 0 until 100){
            var random = Random.nextInt()
            var url = "https://loremflickr.com/320/240?lock=$random"
            lista.add(Foto(url))
        }

        fotosBinding.vistafotos.adapter = fotosAdapter(
            lista,
            object : fotoPulsadaListener {
                override fun fotoPulsada(fotos: Foto) {
                    //Al pulsar un contacto, nos marca el número para hacer una llamada
                    if(fotosBinding.fotoSola.visibility == View.GONE){
                        Glide.with(fotosBinding.root.context)
                            .load(fotos.url)
                            .into(fotosBinding.fotoSola)
                        fotosBinding.fotoSola.visibility = View.VISIBLE
                        fotosBinding.linearL.visibility = View.GONE
                    }
                }
            }
        )

        fotosBinding.fotoSola.setOnClickListener {
            fotosBinding.fotoSola.visibility = View.GONE
            fotosBinding.linearL.visibility = View.VISIBLE
        }
    }
}
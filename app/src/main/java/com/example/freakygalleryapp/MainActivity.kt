package com.example.freakygalleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.freakygalleryapp.databinding.FotosBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fotosBinding = FotosBinding.inflate(layoutInflater)
        setContentView(fotosBinding.root)

        fotosBinding.vistafotos.adapter = fotosAdapter(
            listOf(
                Foto(url = "https://loremflickr.com/320/240?lock=1"),
                Foto(url = "https://loremflickr.com/320/240?lock=2"),
                Foto(url = "https://loremflickr.com/320/240?lock=3"),
                Foto(url = "https://loremflickr.com/320/240?lock=4"),
                Foto(url = "https://loremflickr.com/320/240?lock=5"),
                Foto(url = "https://loremflickr.com/320/240?lock=6"),
                Foto(url = "https://loremflickr.com/320/240?lock=7"),
                Foto(url = "https://loremflickr.com/320/240?lock=8"),
                Foto(url = "https://loremflickr.com/320/240?lock=9"),
            ),
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
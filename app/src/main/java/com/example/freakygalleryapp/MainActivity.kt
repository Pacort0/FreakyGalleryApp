package com.example.freakygalleryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.freakygalleryapp.databinding.FotosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fotos = FotosBinding.inflate(layoutInflater)
        setContentView(fotos.root)

        fotos.vistafotos.adapter = fotosAdapter(
            listOf(
                Foto(url = "https://loremflickr.com/320/240?lock=1", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=2", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=3", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=4", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=5", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=6", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=7", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=8", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=9", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=10", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=11", descripcion = "Foto rechulona"),
                Foto(url = "https://loremflickr.com/320/240?lock=12", descripcion = "Foto rechulona"),
            )
        )

    }
}
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

        //Creamos la lista de fotos que se le pasará al adapter
        var lista = mutableListOf<Foto>()
        //Rellenamos la lista con enlaces aleatorios
        for(i in 0 until 100){
            //Generamos y guardamos número aleatorio
            var random = Random.nextInt()
            //Asignamos el valor aleatorio al enlace predeterminado
            var url = "https://loremflickr.com/320/240?lock=$random"
            //Añadimos la foto a la lista
            lista.add(Foto(url))
        }

        //Pasamos al adapter la lista completa y la función de la Interfaz sobreescrita
        fotosBinding.vistafotos.adapter = fotosAdapter(
            lista,
            object : fotoPulsadaListener {
                //Sobreescribimos la función
                override fun fotoPulsada(fotos: Foto) {
                    //Si la foto no está en grande
                    if(fotosBinding.fotoSola.visibility == View.GONE){
                        //Insertamos la foto de internet mediante un glide
                        Glide.with(fotosBinding.root.context)
                            .load(fotos.url)
                            .into(fotosBinding.fotoSola)
                        //Cambiamos la visibilidad de la foto en grande a visible
                        fotosBinding.fotoSola.visibility = View.VISIBLE
                        //Cambiamos la visibilidad de la galería de fotos a gone
                        fotosBinding.linearL.visibility = View.GONE
                    }
                }
            }
        )

        //Cada vez que se haga click en la foto en grande, cambiamos las visibilidades de ésta y de la galería
        fotosBinding.fotoSola.setOnClickListener {
            fotosBinding.fotoSola.visibility = View.GONE
            fotosBinding.linearL.visibility = View.VISIBLE
        }
    }
}
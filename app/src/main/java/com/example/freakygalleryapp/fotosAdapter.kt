package com.example.freakygalleryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freakygalleryapp.databinding.ItemfotosBinding

//Clase fotosAdapter, desde la que controlaremos la galería de fotos
//Recibe por parámetros una lista de fotos y una función de tipo fotoPulsadaListener
class fotosAdapter(private val fotos: List<Foto>,
    private val fotoPulsadaListener: fotoPulsadaListener) :
    RecyclerView.Adapter<fotosAdapter.ViewHolder>() {
    //Creamos la clase ViewHolder, que recibe una variable binding de tipo ItemfotosBinding
    class ViewHolder(val binding: ItemfotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //Función bind, recibe un objeto de tipo foto y muestra la imagen correspondiente a su URL en la galería
        fun bind(foto: Foto) {
            Glide.with(binding.root.context)
                .load(foto.url)
                .into(binding.fotoGaleria)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemfotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return fotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(fotos[position])
        //Cuando se pulse una foto, llamamos a la función fotoPulsadaListener
        holder.itemView.setOnClickListener {
            fotoPulsadaListener.fotoPulsada(fotos[position])
        }
    }
}
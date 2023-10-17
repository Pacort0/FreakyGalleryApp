package com.example.freakygalleryapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freakygalleryapp.databinding.ItemfotosBinding

class fotosAdapter(private val fotos : List<Foto>):
    RecyclerView.Adapter<fotosAdapter.ViewHolder>() {
        class ViewHolder(val binding: ItemfotosBinding ):
                RecyclerView.ViewHolder(binding.root){
                    fun bind (foto: Foto){
                        binding.descripcion.text=foto.descripcion
                        Glide.with(binding.root.context)
                            .load(foto.url)
                            .into(binding.foto)
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
    }
}
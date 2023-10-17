package com.example.freakygalleryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.freakygalleryapp.databinding.ItemfotosBinding

class fotosAdapter(private val fotos: List<Foto>) :
    RecyclerView.Adapter<fotosAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemfotosBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foto: Foto) {
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
        var isImageFitToScreen = false

        holder.bind(fotos[position])
        holder.binding.foto.setOnClickListener {
            if (isImageFitToScreen) {
                isImageFitToScreen = false
                holder.binding.foto.layoutParams =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                holder.binding.linearL.setPadding(0,10,0,0)
                holder.binding.foto.adjustViewBounds = false
            } else {
                isImageFitToScreen = true
                holder.binding.foto.layoutParams =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                holder.binding.linearL.setPadding(0,0,0,0)
                holder.binding.foto.adjustViewBounds = true
            }
        }
    }
}
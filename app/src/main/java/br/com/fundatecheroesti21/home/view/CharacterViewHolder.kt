package br.com.fundatecheroesti21.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatecheroesti21.databinding.CharacterListItemBinding
import br.com.fundatecheroesti21.home.presentation.model.CharacterModel
import com.bumptech.glide.Glide

class CharacterViewHolder(private val binding: CharacterListItemBinding) :

    RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterModel) {
        binding.tvName.text = character.name
        Glide.with(binding.root.context)
            .load(character.url)
            .into(binding.imgHeroe)
    }

}
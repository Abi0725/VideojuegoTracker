package com.miranda.videojuegotracker.ui.game.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.miranda.videojuegotracker.data.model.GameModel
import com.miranda.videojuegotracker.databinding.GameItemBinding

class GameRecyclerViewHolder(private val binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(game: GameModel, clickListener: (GameModel) -> Unit) {
        binding.titleTextView.text = game.name
        binding.genderTextView.text = game.gender

        binding.gameItemCardView.setOnClickListener {
            clickListener(game)
        }
    }
}
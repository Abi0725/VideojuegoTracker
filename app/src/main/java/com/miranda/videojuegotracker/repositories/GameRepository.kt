package com.miranda.videojuegotracker.repositories

import com.miranda.videojuegotracker.data.model.GameModel

class GameRepository(private val games: MutableList<GameModel>) {
     fun getGames() = games

    //To add a list in dummyData
    fun addGames(game: GameModel) = games.add(game)
}
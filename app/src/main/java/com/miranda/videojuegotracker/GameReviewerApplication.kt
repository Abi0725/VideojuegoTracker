package com.miranda.videojuegotracker

import android.app.Application
import com.miranda.videojuegotracker.data.games
import com.miranda.videojuegotracker.repositories.GameRepository

class GameReviewerApplication: Application() {
    val gameRepository: GameRepository by lazy { GameRepository(games) }
}
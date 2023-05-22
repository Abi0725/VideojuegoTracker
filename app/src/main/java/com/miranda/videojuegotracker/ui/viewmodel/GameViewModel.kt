package com.miranda.videojuegotracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miranda.videojuegotracker.GameReviewerApplication
import com.miranda.videojuegotracker.data.model.GameModel
import com.miranda.videojuegotracker.repositories.GameRepository

class GameViewModel(private val repository: GameRepository): ViewModel() {
    var name = MutableLiveData("")
    val gender = MutableLiveData("")

    fun getGames()= repository.getGames()

    private fun addGames(game:GameModel) = repository.addGames(game)

    fun createGame() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val game = GameModel(
            name.value!!,
            gender.value!!
        )

        addGames(game)
        clearData()

        status.value = GAME_CREATED
    }

    private fun validateData(): Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            gender.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        name.value =""
        gender.value =""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun selectedGame(game: GameModel){
        name.value = game.name
        gender.value = game.gender
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as GameReviewerApplication
                GameViewModel(app.gameRepository)
            }
        }
        const val GAME_CREATED = "Game Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}
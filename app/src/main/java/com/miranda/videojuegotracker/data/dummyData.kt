package com.miranda.videojuegotracker.data

import com.miranda.videojuegotracker.data.model.GameModel

val name = "Call of Duty"
val gender = "War"

val name2 = "Clash Of Clans"
val gender2 = "War"


var games = mutableListOf(
    GameModel(name, gender),
    GameModel(name2, gender2)
)
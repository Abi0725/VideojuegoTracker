package com.miranda.videojuegotracker.ui.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.miranda.videojuegotracker.R
import com.miranda.videojuegotracker.data.model.GameModel
import com.miranda.videojuegotracker.ui.game.recyclerview.GameRecyclerViewAdapter
import com.miranda.videojuegotracker.ui.viewmodel.GameViewModel

class GameFragment : Fragment() {
    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    private lateinit var adapter: GameRecyclerViewAdapter

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewMovie.setOnClickListener {
            gameViewModel.clearData()
            it.findNavController().navigate(R.id.action_gameFragment_to_newGameFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = GameRecyclerViewAdapter { selectedGame ->
            showSelectedItem(selectedGame)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies() {
        adapter.setData(gameViewModel.getGames())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(game: GameModel) {
        gameViewModel.setSelectedGame(game)
        findNavController().navigate(R.id.action_gameFragment_to_descriptionGameFragment)
    }

}
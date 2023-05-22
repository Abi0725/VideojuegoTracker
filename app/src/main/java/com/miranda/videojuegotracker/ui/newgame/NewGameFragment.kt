package com.miranda.videojuegotracker.ui.newgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.miranda.videojuegotracker.ui.viewmodel.GameViewModel


class NewGameFragment : Fragment() {

    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    private lateinit var binding: FragmentNewGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragementNewGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = gameViewModel
    }

    private fun observeStatus() {
        gameViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(GameViewModel.WRONG_INFORMATION) -> {
                    gameViewModel.clearStatus()
                }
                status.equals(GameViewModel.GAME_CREATED) -> {
                    gameViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}
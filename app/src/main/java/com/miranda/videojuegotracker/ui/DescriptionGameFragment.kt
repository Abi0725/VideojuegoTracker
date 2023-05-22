package com.miranda.videojuegotracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.miranda.videojuegotracker.ui.viewmodel.GameViewModel


class DescriptionGameFragment : Fragment() {

    private val gameViewModel: GameViewModel by activityViewModels {
        GameViewModel.Factory
    }

    private lateinit var binding: FragmentDescriptionGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = gameViewModel
    }

}
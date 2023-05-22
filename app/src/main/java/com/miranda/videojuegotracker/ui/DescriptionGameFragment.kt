package com.miranda.videojuegotracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miranda.videojuegotracker.R


class DescriptionGameFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description_game, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            DescriptionGameFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
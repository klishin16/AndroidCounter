package com.example.fragments.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.fragments.R

class HomeFragment : Fragment() {
    private var firstCounter: Int = 0;
    private var showCounter: Boolean = false
    private lateinit var counterIncreaseButton: Button;
    private lateinit var showCounterButton: Button;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        counterIncreaseButton = view.findViewById(R.id.increaseFirstCounterButton)
        showCounterButton = view.findViewById(R.id.showFirstCounterButton)

        counterIncreaseButton.setOnClickListener {
            firstCounter++;
        }

        showCounterButton.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToHomeCounterFragment(firstCounter)
            findNavController().navigate(action)
            firstCounter = 0
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("firstCounter", firstCounter)
        outState.putBoolean("showFirstCounter", showCounter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            firstCounter = savedInstanceState.getInt("firstCounter")
        }
    }

}
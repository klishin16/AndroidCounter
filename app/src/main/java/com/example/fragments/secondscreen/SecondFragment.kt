package com.example.fragments.secondscreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.fragments.R


class SecondFragment : Fragment() {
    private var secondCounter: Int = 0;

    private lateinit var counterIncreaseButton: Button;
    private lateinit var showCounterButton: Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        counterIncreaseButton = view.findViewById(R.id.increaseSecondCounterButton)
        showCounterButton = view.findViewById(R.id.showSecondCounterButton)


        counterIncreaseButton.setOnClickListener {
            secondCounter++;
        }

        showCounterButton.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToSecondCounterFragment(secondCounter)
            findNavController().navigate(action)
            secondCounter = 0
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("secondCounter", secondCounter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            secondCounter = savedInstanceState.getInt("secondCounter")
        }
    }
}
package com.example.fragments.thirdscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.fragments.R
import com.example.fragments.secondscreen.SecondFragmentDirections

class ThirdFragment : Fragment() {
    private var thirdCounter: Int = 0;
    private lateinit var showCounterButton: Button;

    private lateinit var counterIncreaseButton: Button;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        counterIncreaseButton = view.findViewById(R.id.increaseThirdCounterButton)
        showCounterButton = view.findViewById(R.id.showThirdCounterButton)

        counterIncreaseButton.setOnClickListener {
            thirdCounter++;
        }

        showCounterButton.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToThirdCounterFragment(thirdCounter)
            findNavController().navigate(action)
            thirdCounter = 0
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("thirdCounter", thirdCounter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            thirdCounter = savedInstanceState.getInt("thirdCounter")
        }
    }
}
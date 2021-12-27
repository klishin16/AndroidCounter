package com.example.fragments.fourthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.fragments.R
import com.example.fragments.thirdscreen.ThirdFragmentDirections


class FourthFragment : Fragment() {
    private var fourthCounter: Int = 0;

    private lateinit var counterIncreaseButton: Button;
    private lateinit var showCounterButton: Button;


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        counterIncreaseButton = view.findViewById(R.id.increaseFourthCounterButton)
        showCounterButton = view.findViewById(R.id.showFourthCounterButton)

        counterIncreaseButton.setOnClickListener {
            fourthCounter++;
        }

        showCounterButton.setOnClickListener {
            val action = FourthFragmentDirections.actionFourthFragmentToFouthCounterFragment(fourthCounter)
            findNavController().navigate(action)
            fourthCounter = 0
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("fourthCounter", fourthCounter)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            fourthCounter = savedInstanceState.getInt("fourthCounter")
        }
    }
}
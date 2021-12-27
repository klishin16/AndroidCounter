package com.example.fragments.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.fragments.R

class HomeCounterFragment : Fragment() {
    private val args: HomeCounterFragmentArgs by navArgs()

    private lateinit var counterTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_counter, container, false)
        counterTextView = view.findViewById(R.id.firstCounterView)
        counterTextView.text = args.counterValue.toString()

        return view
    }
}
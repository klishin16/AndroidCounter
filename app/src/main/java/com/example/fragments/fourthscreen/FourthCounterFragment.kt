package com.example.fragments.fourthscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.fragments.R
import com.example.fragments.firstscreen.HomeCounterFragmentArgs


class FourthCounterFragment : Fragment() {
    private lateinit var counterTextView: TextView;
    private val args: HomeCounterFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fouth_counter, container, false)
        counterTextView = view.findViewById(R.id.fourthCounterView)
        counterTextView.text = args.counterValue.toString()
        return view
    }
}
package com.example.newclasswork.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.newclasswork.R
import com.example.newclasswork.viewmodel.FantViewModel

class FantFragment : Fragment() {

    companion object {
        fun newInstance() = FantFragment()
    }

    private lateinit var viewModel: FantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fant_fragment, container, false)
    }

}

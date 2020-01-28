package com.example.newclasswork.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.newclasswork.R

import com.example.newclasswork.network.UserResponse
import com.example.newclasswork.viewmodel.FantViewModel

class FantFragment : Fragment() {

    companion object {

        const val ID_KEY = "ID_KEY"

        fun newInstance(id: Int): FantFragment{
            val fragment = FantFragment()
            val bundle = Bundle()
            bundle.putInt(ID_KEY, id)
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var viewModel: FantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fant_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ID_KEY)


        viewModel =ViewModelProviders.of(this).get(FantViewModel::class.java)
        viewModel.getUser(id)
        viewModel.userListLiveData.observe(viewLifecycleOwner, userListObserver)

    }

    private val userListObserver = Observer<UserResponse> {
        it.result
        
    }
}
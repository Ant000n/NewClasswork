package com.example.newclasswork.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newclasswork.DataAdapter
import com.example.newclasswork.MainActivity
import com.example.newclasswork.R
import com.example.newclasswork.network.ResultItem
import com.example.newclasswork.network.UserListResponse
import com.example.newclasswork.viewmodel.BlanViewModel
import kotlinx.android.synthetic.main.recycler_view.*

class BlanFragment : Fragment(), DataAdapter.DataCallback {

    companion object {
        fun newInstance() = BlanFragment()
    }

    private lateinit var viewModel: BlanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_view, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlanViewModel::class.java)
        viewModel.getUserList()
        viewModel.userListLiveData.observe(viewLifecycleOwner, userListObserver)


    }

    override fun itemClicked(item: ResultItem) {
        (activity as MainActivity).showProfile(item.id!!)
    }

    private fun showData(list: List<ResultItem>?) {
        if (list != null) {
            val dataAdapter = DataAdapter(this)
            dataAdapter.list = list
            recycler_view.adapter = dataAdapter
            recycler_view.layoutManager =
                LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        }
    }

    private val userListObserver = Observer<UserListResponse> { result ->
        showData(result.result)
    }
}
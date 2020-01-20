package com.example.newclasswork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newclasswork.network.ResultItem
import kotlinx.android.synthetic.main.item_data.view.*

class DataAdapter(
    private val callback: DataCallback?
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    var list = emptyList<ResultItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            callback?.itemClicked(list[holder.adapterPosition])
        }
    }

    override fun getItemCount() = list.size


    class DataViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val textId = itemView.item_id
        private val firstName = itemView.first_name
        private val lastName = itemView.last_name

        fun bind(data: ResultItem) {
            textId.text = data.id.toString()
            firstName.text = data.firstName
            lastName.text = data.lastName

        }
    }

    interface DataCallback {
        fun itemClicked(item: ResultItem)
    }
}
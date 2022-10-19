package org.group.dird.cleanarchitecturepractice.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.group.dird.cleanarchitecturepractice.databinding.RecyclerCardBinding
import org.group.dird.core.data.Post

class MainAdapter(
    private val items: List<Post>
): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(val binding:RecyclerCardBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]

        holder.binding.title.text = item.title
        holder.binding.body.text = item.body
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
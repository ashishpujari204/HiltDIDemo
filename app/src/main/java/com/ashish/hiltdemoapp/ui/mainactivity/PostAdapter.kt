package com.ashish.hiltdemoapp.ui.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ashish.hiltdemoapp.R
import com.ashish.hiltdemoapp.databinding.PostItemViewBinding
import com.ashish.hiltdemoapp.model.Posts

class PostAdapter(
    items: ArrayList<Posts>,
    private val onItemClick: (weather: Posts) -> Unit
) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private var items = ArrayList<Posts>()

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var postObject: Posts
        private val binding = PostItemViewBinding.bind(itemView)
        fun bind(weather: Posts) = with(itemView) {
            postObject = weather
            weather.apply {
                binding.titleText.text = (postObject.title)
                binding.bodyText.text = (postObject.body)
            }
            setOnClickListener {
                onItemClick(weather)
            }
        }
    }
}
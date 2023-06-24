package uz.codial.listadapter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.codial.listadapter.databinding.ItemBinding
import uz.codial.listadapter.model.User

class RvAdapter : ListAdapter<User, RvAdapter.RvViewHolder>(MyDiffUtil()) {

    inner class RvViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    class MyDiffUtil : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.equals(newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val user = getItem(position)
        holder.binding.tv.text = user.name

        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 5000
        holder.binding.root.startAnimation(animation)

    }

}
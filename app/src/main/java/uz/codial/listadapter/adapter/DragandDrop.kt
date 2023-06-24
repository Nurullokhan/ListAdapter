package uz.codial.listadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.codial.listadapter.databinding.ItemBinding
import uz.codial.listadapter.model.User
import uz.codial.listadapter.ItemTouchHelperAdapter
import java.util.Collections

class DragandDrop(
    private var itemsList: ArrayList<User>
) : RecyclerView.Adapter<DragandDrop.DragViewHolder>(), ItemTouchHelperAdapter {

    inner class DragViewHolder(var itemBinding: ItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragViewHolder {
        return DragViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: DragViewHolder, position: Int) {
        holder.itemBinding.tv.text = itemsList[position].name
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(itemsList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(itemsList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        itemsList.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }


}
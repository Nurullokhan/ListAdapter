package uz.codial.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.codial.listadapter.adapter.DragandDrop
import uz.codial.listadapter.adapter.RvAdapter
import uz.codial.listadapter.databinding.ActivityMainBinding
import uz.codial.listadapter.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: RvAdapter

//    private lateinit var dragAdapter: DragandDrop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        adapter = RvAdapter()
//        val list = ArrayList<User>()
//
//        binding.save.setOnClickListener {
//            val name: String = binding.edt.text.toString()
//
//            val user = User(name)
//            list.add(user)
//            adapter.submitList(list)
//            adapter.notifyDataSetChanged()
//            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
//        }
//        binding.recyclerView.adapter = adapter
//

        val list = ArrayList<User>()
        list.add(User("Nurulloxon"))
        list.add(User("Abdulloh"))
        list.add(User("Muzaffarjon"))
        list.add(User("Oyatulloh"))
        list.add(User("Salohiddin"))
        list.add(User("Abdubosit"))
        list.add(User("Otabek"))
        list.add(User("Diloromxon"))

        adapter = RvAdapter()
        adapter.submitList(list)
        binding.recyclerView.adapter = adapter

//        dragAdapter = DragandDrop(list)
//        binding.recyclerView.adapter = dragAdapter
//
//        val itemTouchHelper = object : ItemTouchHelper.Callback() {
//            override fun getMovementFlags(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder
//            ): Int {
//                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
//                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
//                return makeMovementFlags(dragFlags, swipeFlags)
//            }
//
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                dragAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
//                return true
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                dragAdapter.onItemDismiss(viewHolder.adapterPosition)
//            }
//        }
//        val itemTouch = ItemTouchHelper(itemTouchHelper)
//        itemTouch.attachToRecyclerView(binding.recyclerView)
    }
}
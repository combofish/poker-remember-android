package com.example.pokerrem2.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokerrem2.R
import com.example.pokerrem2.adapter.MyRecycleViewAdapter.MyViewHolder


class MyRecycleViewAdapter(private var pokers: MutableList<String>, private val context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {

    private val TAG = "MyRecycleViewAdapter"
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = View.inflate(context, R.layout.item_rv, null)
        return MyViewHolder(view)
    }

    fun changePokers(newPoker: MutableList<String>){
        pokers = newPoker
        // notifyItemMoved(0,5)
        notifyItemRangeChanged(0,newPoker.size)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val poker = pokers[position]
        val selectString = poker.substring(0, 6)
        Log.i(TAG,"Select String: ${selectString}")

        when (selectString) {
            "classE" -> {
                holder.tv.setText("")
                holder.iv.setImageResource(R.drawable.poker_big_y)
            }
            "classF" -> {
                holder.tv.setText("")
                holder.iv.setImageResource(R.drawable.poker_little_y)
            }
            "classA" -> {
                holder.tv.setText(poker.substring(6))
                holder.iv.setImageResource(R.drawable.poker_black_spades)
            }
            "classB" -> {
                holder.tv.setText(poker.substring(6))
                holder.iv.setImageResource(R.drawable.poker_red_shade)
            }
            "classC" -> {
                holder.tv.setText(poker.substring(6))
                holder.iv.setImageResource(R.drawable.poker_three_shadow)
            }
            "classD" -> {
                holder.tv.setText(poker.substring(6))
                holder.iv.setImageResource(R.drawable.poker_rand)
            }
        }
        Log.i("TAG", "getPosition: $position")
    }

    override fun getItemCount(): Int {
        return pokers.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView
        val tv: TextView
        val btn: Button? = null

        init {
            tv = itemView.findViewById(R.id.tv1)
            iv = itemView.findViewById(R.id.iv1)

            // btn = itemView.findViewById(R.id.btn1);
            itemView.setOnClickListener {
                mOnItemCLickListener?.onRecycleItemClick(adapterPosition)
            }
        }
    }

    var mOnItemCLickListener: OnRecycleItemClickListener? =
        null

    fun setRecycleItemClickListener(listener: OnRecycleItemClickListener?) {
        mOnItemCLickListener = listener
    }

    interface OnRecycleItemClickListener {
        fun onRecycleItemClick(position: Int)
    }
}
package com.asparagas.crytoapp_retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asparagas.crytoapp_retrofit.databinding.RecyclerRowLayoutBinding
import com.asparagas.crytoapp_retrofit.model.Crypto

class RecyclerViewAdapter(
    private val cryptoList: ArrayList<Crypto>,
    private val listener: Listener
) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onClickItem(cryto: Crypto)
    }

    class RowHolder(val binding: RecyclerRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cryto: Crypto, listener: Listener) {
            itemView.setOnClickListener {
                listener.onClickItem(cryto)
            }
            binding.textName.text = cryto.currency
            binding.textPrice.text = cryto.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding =RecyclerRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int = cryptoList.size

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], listener)
    }
}
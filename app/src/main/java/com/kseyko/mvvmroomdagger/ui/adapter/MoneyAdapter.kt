package com.kseyko.mvvmroomdagger.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kseyko.mvvmroomdagger.R
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import com.kseyko.mvvmroomdagger.databinding.ItemMoneyBinding
import javax.inject.Inject


class MoneyAdapter @Inject constructor() :
    ListAdapter<MoneyModel, MoneyAdapter.MoneyViewHolder>(DiffCallBack) {

    companion object {

        val DiffCallBack = object : DiffUtil.ItemCallback<MoneyModel>() {
            override fun areItemsTheSame(oldItem: MoneyModel, newItem: MoneyModel): Boolean =
                oldItem.currency == newItem.currency

            override fun areContentsTheSame(oldItem: MoneyModel, newItem: MoneyModel): Boolean =
                oldItem == newItem

        }
    }


    private var onItemClickListener: ((MoneyModel) -> Unit)? = null

    fun setOnItemClickListener(onItemClickListener: ((MoneyModel) -> Unit)) {
        this.onItemClickListener = onItemClickListener
    }


    class MoneyViewHolder(private val moneyBinding: ItemMoneyBinding) :
        RecyclerView.ViewHolder(moneyBinding.root) {
        fun bind(moneyModel: MoneyModel, onItemClickListener: ((MoneyModel) -> Unit)?) {
            moneyBinding.apply {
                this.moneyModel = moneyModel
                root.setOnClickListener { onItemClickListener?.invoke(moneyModel) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder =
        MoneyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_money,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClickListener)


}

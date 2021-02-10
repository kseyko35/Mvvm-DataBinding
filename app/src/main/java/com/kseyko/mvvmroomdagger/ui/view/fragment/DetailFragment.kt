package com.kseyko.mvvmroomdagger.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kseyko.mvvmroomdagger.R
import com.kseyko.mvvmroomdagger.data.model.MoneyModel
import com.kseyko.mvvmroomdagger.databinding.DetailFragmentBinding


class DetailFragment : Fragment() {

    private var moneyModel: MoneyModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val detailBinding = DataBindingUtil.inflate<DetailFragmentBinding>(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )
        detailBinding.moneyModel = moneyModel
        return detailBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            moneyModel = it.getParcelable("moneymodel") as MoneyModel?
        }

    }


}
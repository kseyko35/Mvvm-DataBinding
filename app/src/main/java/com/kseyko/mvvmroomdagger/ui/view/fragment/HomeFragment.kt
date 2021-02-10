package com.kseyko.mvvmroomdagger.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.kseyko.mvvmroomdagger.R
import com.kseyko.mvvmroomdagger.databinding.HomeFragmentBinding
import com.kseyko.mvvmroomdagger.ui.adapter.MoneyAdapter
import com.kseyko.mvvmroomdagger.ui.viewmodel.HomeViewModel
import com.kseyko.mvvmroomdagger.util.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var homeFragmentBinding: HomeFragmentBinding


    @Inject
    lateinit var moneyAdapter: MoneyAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        Log.e("1", "onCreateView")
        return homeFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        Log.e("1", "onViewCreated")
        homeViewModel.getMoneyFromApi.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    homeFragmentBinding.progressbar.visibility = View.VISIBLE
                }
                Status.SUCCES -> {
                    moneyAdapter.submitList(it.data)
                    homeFragmentBinding.progressbar.visibility = View.INVISIBLE
                }
                Status.ERROR -> {
                    Log.e("ERROR", "${it.exception}")
                }
            }
        }
    }

    private fun initializeRecyclerView() {
        homeFragmentBinding.recyclerView.setHasFixedSize(true) //we used match parent for height, so we can improve performance with this code.
        homeFragmentBinding.recyclerView.adapter = moneyAdapter

        moneyAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putParcelable("moneymodel", it)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

}
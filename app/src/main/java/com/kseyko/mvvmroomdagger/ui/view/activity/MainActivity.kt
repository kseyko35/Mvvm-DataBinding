package com.kseyko.mvvmroomdagger.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import com.kseyko.mvvmroomdagger.R

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity :
    AppCompatActivity(R.layout.activity_main) //Once Hilt is set up in your Application class and an application-level component is available,
//Hilt can provide dependencies to other Android classes that have the @AndroidEntryPoint annotation:


//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)




package com.jozze.things.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.jozze.core.common.Resource
import com.jozze.core.common.log
import com.jozze.things.R
import com.jozze.things.databinding.ActivityMainBinding
import com.jozze.things.domain.repository.ThingsRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository1 by inject<ThingsRepository>()

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel.addThing().onEach {
            when(it) {
                is Resource.Loading -> {
                    if (it.loading)
                        log("loading the thing")
                    else
                        log("loaded the thing")
                }
                is Resource.Failure -> {
                    log("failed adding the thing")
                }
                is Resource.Success -> {
                    log("added the thing")
                }
            }
        }.launchIn(lifecycleScope)
    }
}
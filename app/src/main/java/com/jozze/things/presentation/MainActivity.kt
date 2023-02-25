package com.jozze.things.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.jozze.core.common.Resource
import com.jozze.core.common.log
import com.jozze.things.R
import com.jozze.things.data.remote.dto.TestModel
import com.jozze.things.data.remote.dto.json
import com.jozze.things.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding

    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val moshi = Moshi.Builder().build()
//        val adapter: JsonAdapter<TestModel> = moshi.adapter(TestModel::class)
        val noteDto = moshi.adapter<TestModel>().fromJson(json)
        val noteJsonString = moshi.adapter<TestModel>().toJson(noteDto)
        log(noteJsonString)
        return


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
package com.alaahossam.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), ActivityViewContract<DB> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getLayoutResourceId() != 0) {
            val binding: DB = DataBindingUtil.setContentView(this, getLayoutResourceId())
            onBindData(binding)
        } else {
            throw IllegalArgumentException("layout resource cannot be null")
        }
        initView()
    }

    open fun initView() {}

    override fun onBindData(binding: DB) {}
}

interface ActivityViewContract<DB> {
    fun getLayoutResourceId(): Int
    fun onBindData(binding: DB)
}
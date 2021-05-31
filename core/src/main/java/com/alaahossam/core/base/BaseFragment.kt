package app.hatrick.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<DB : ViewDataBinding> : Fragment(),
    BindingFragmentViewContract<DB> {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getLayoutResourceId() != 0) {
            val binding: DB =
                DataBindingUtil.inflate(inflater, getLayoutResourceId(), container, false)
            binding.setLifecycleOwner { lifecycle }
            onBindData(binding)
            return binding.root
        } else {
            throw IllegalArgumentException("layout resource cannot be null")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView() {}

    override fun onBindData(binding: DB) {}
}

interface BindingFragmentViewContract<DB> {
    fun getLayoutResourceId(): Int
    fun onBindData(binding: DB)
}
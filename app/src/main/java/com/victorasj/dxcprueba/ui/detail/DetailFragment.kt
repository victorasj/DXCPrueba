package com.victorasj.dxcprueba.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.victorasj.dxcprueba.databinding.DetailFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : ScopeFragment() {

    private lateinit var binding : DetailFragmentBinding

    private val args : DetailFragmentArgs by navArgs()

    private val viewModel: DetailViewModel by viewModel { parametersOf(args.id) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.photo.observe(viewLifecycleOwner, Observer (::UpdateUI))
    }

    private fun UpdateUI(model : DetailViewModel.UiModel){
        when(model){
            is DetailViewModel.UiModel.ContentPhoto -> {
                with(binding){
                }
            }
        }
    }

}
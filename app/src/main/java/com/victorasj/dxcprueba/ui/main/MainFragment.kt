package com.victorasj.dxcprueba.ui.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorasj.dxcprueba.EventObserver
import com.victorasj.dxcprueba.R
import com.victorasj.dxcprueba.databinding.MainFragmentBinding
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : ScopeFragment() {

    private lateinit var binding : MainFragmentBinding

    private lateinit var adapter: PhotoAdapter
    private lateinit var navController: NavController

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        adapter = PhotoAdapter (viewModel::onPhotoClick)
        binding.recyclerViewPhotos.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPhotos.adapter = adapter
        viewModel.photos.observe(viewLifecycleOwner, Observer (::updateUi))
        viewModel.navigateToPhoto.observe(viewLifecycleOwner, EventObserver {
            navController.navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(it.id))
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val searchMenu = menu.findItem(R.id.photo_search)
        val searchViewName = searchMenu.actionView as SearchView
        searchViewName.queryHint =  getString(R.string.photo_search)
        searchViewName.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(value: String?): Boolean {
                viewModel.search(value)
                return true
            }

            override fun onQueryTextChange(value: String?): Boolean {
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun updateUi(model : MainViewModel.UiModel) {
        binding.progress.visibility = if(model is MainViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when(model) {
            is MainViewModel.UiModel.Content -> adapter.photos = model.photos
        }
    }


}
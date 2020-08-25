package com.example.project_api.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_api.vo.Resource
import com.example.project_api.R
import com.example.project_api.domain.DataSource
import com.example.project_api.data.model.bebida
import com.example.project_api.database
import com.example.project_api.domain.DaoBebida
import com.example.project_api.domain.ImplRepo
import com.example.project_api.ui.VM.MainVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_fav_fragment.*
import javax.inject.Inject

@AndroidEntryPoint
class Fav_fragment : Fragment(), MainAdapter.OnbebidaClickListener {
    private lateinit var adapter: MainAdapter
    private val viewModel by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fav_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        setupOb()
    }
    private fun setupOb(){
        viewModel.getBebidaFav().observe(viewLifecycleOwner, Observer {result->
            when (result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val lista = result.data.map {
                        bebida(it.bebidaId,it.image,it.title,it.describe)
                    }
                    rv_bebidas_fav.adapter = MainAdapter(requireContext(),lista, this)

                }
                is Resource.Failure -> {
                }
            }
        })
    }
    private fun setupRv(){
        rv_bebidas_fav.layoutManager = LinearLayoutManager(requireContext())
        rv_bebidas_fav.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))

    }

    override fun onbebidaClick(bebida: bebida) {

    }

}
package com.example.project_api.views.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_api.R
import com.example.project_api.models.bebida
import com.example.project_api.vo.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main_.*
import androidx.appcompat.widget.SearchView
import com.example.project_api.adapters.MainAdapter
import com.example.project_api.viewmodels.MainViewModel

@AndroidEntryPoint
class MainFragment : Fragment(), MainAdapter.OnbebidaClickListener { private val viewModel by viewModels<MainViewModel>()
    private lateinit var mainAdapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        setupObs()
    }

    private fun setupObs() {
        viewModel.fetchBebidaList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    pgsBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    pgsBar.visibility = View.GONE
                    rv_bebidas.adapter = MainAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    pgsBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Error al cargar los datos ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
        val itemSearch = menu.findItem(R.id.search)
        var ViewBusqueda = itemSearch?.actionView as SearchView
        ViewBusqueda.queryHint = "Buscar"

        ViewBusqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setBebida(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.setBebida(newText!!)
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                findNavController().navigate(R.id.action_main_Fragment_to_fav_fragment)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onbebidaClick(bebida: bebida) {
        val bundle = Bundle()
        bundle.putParcelable("bebida", bebida)
        findNavController().navigate(R.id.action_main_Fragment_to_detail_Fragment_Bebida, bundle)
    }

    private fun setupRV() {
        rv_bebidas.layoutManager = LinearLayoutManager(requireContext())
        rv_bebidas.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}
package com.example.project_api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_api.vo.Resource
import com.example.project_api.R
import com.example.project_api.domain.DataSource
import com.example.project_api.data.model.bebida
import com.example.project_api.database
import com.example.project_api.domain.ImplRepo
import com.example.project_api.ui.VM.MainVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main_.*

@AndroidEntryPoint
class Main_Fragment : Fragment(), MainAdapter.OnbebidaClickListener {

    private val viewModel by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        setupBusView()
        setupObs()
        btn_fav.setOnClickListener{
            findNavController().navigate(R.id.action_main_Fragment_to_fav_fragment)
        }

    }
    private fun setupObs(){
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
    private fun setupBusView(){
        busquedaView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setBebida(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
    override fun onbebidaClick(bebida: bebida) {
        val bundle = Bundle()
        bundle.putParcelable("bebida", bebida)
        findNavController().navigate(R.id.action_main_Fragment_to_detail_Fragment_Bebida,bundle)
    }

    private fun setupRV(){
        rv_bebidas.layoutManager = LinearLayoutManager(requireContext())
        rv_bebidas.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }
}
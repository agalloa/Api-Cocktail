package com.example.project_api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.project_api.R
import com.example.project_api.data.model.bebida
import com.example.project_api.ui.VM.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_drinks_details.*

@AndroidEntryPoint
class DrinkDetailFragment : Fragment() {
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var bebida: bebida

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            bebida = it.getParcelable("bebida")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drinks_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(bebida.image).into(img_bebida)
        title_bebida.text = bebida.title
        describe_txt.text = bebida.describe
        btn_guardar_bebida.setOnClickListener {
            viewModel.savebebida(
                bebida(
                    bebida.bebidaId,
                    bebida.image,
                    bebida.title,
                    bebida.describe
                )
            )
            Toast.makeText(
                requireContext(),
                "La bebida se ha añadido a favoritos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
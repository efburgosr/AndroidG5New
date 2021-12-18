package com.example.recorridocafetero.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.recorridocafetero.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lugar = args.lugar
        with(detailBinding){
            nombreTextView.text = lugar.nombre
            detalleTextView.text = lugar.detalle
            direccionTextView.text = lugar.ubicacion
            horaTextView.text = lugar.horario
            numeroTextView.text = lugar.telefono
            webTextView.text = lugar.paginaWeb
            com.squareup.picasso.Picasso.get().load(lugar.urlDetalle).into(photoImageView)

            mapButton.setOnClickListener {
                launchMap(lugar.latitud, lugar.longitud)
            }

        }
    }

    private fun launchMap(lat: Double, lon: Double) {
        val geo = "geo: $lat, $lon"
        val gmmIntentUri = Uri.parse(geo)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}
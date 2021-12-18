package com.example.recorridocafetero.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("calificacion")
    val calificacion: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("detalle")
    val detalle: String,
    @SerializedName("horario")
    val horario: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("paginaWeb")
    val paginaWeb: String,
    @SerializedName("telefono")
    val telefono: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("urlDetalle")
    val urlDetalle: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double,
    @SerializedName("zoom")
    val zoom: String
) : Serializable
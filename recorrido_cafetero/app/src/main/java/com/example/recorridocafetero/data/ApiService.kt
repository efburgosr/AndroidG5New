package com.example.recorridocafetero.data

import com.example.recorridocafetero.model.Lugar
import retrofit2.http.GET

interface ApiService {
    @GET("GroupAndroidMTC/AndroidG5/lugares")
    suspend fun getLugares(): Lugar


}
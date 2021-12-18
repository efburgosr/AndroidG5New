package com.example.recorridocafetero.data

class LugaresRepository {

    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}
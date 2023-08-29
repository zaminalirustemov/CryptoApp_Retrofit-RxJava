package com.asparagas.crytoapp_retrofit.service

import com.asparagas.crytoapp_retrofit.model.Crypto
import io.reactivex.Observable
import retrofit2.http.GET

interface CryptoAPI {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():Observable<List<Crypto>>
}
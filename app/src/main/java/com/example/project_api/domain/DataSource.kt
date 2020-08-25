package com.example.project_api.domain

import com.example.project_api.data.model.bebida
import com.example.project_api.data.model.bebidaEntity
import com.example.project_api.database
import com.example.project_api.vo.ClienteRetro
import com.example.project_api.vo.Resource
import javax.inject.Inject

interface DataSource {
       suspend fun getBebidaNombre(bebidaName: String) : Resource<List<bebida>>
       suspend fun savebebidaroom(bebida:bebidaEntity)
       suspend fun getbebidafav(): Resource<List<bebidaEntity>>

    /*
       val generarListBebida = Resource.Success(listOf(
        bebida("https://www.thecocktaildb.com/images/media/drink/3z6xdi1589574603.jpg","Mojito", "Muddle mint leaves with sugar and lime juice. Add a splash of soda water and fill the glass with cracked ice."),
        bebida("https://www.thecocktaildb.com/images/media/drink/xsqsxw1441553580.jpg","Pysch Vitamin Light","Shake with ice."),
        bebida("https://www.thecocktaildb.com/images/media/drink/quksqg1582582597.jpg","Godmother", "Pour vodka and amaretto into an old-fashioned glass over ice and serve.")
    ))
     */
}

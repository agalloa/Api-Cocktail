package com.example.project_api.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class bebida(
    @SerializedName("idDrink")
    val bebidaId: String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val title: String = "",
    @SerializedName("strInstructions")
    val describe: String = ""
): Parcelable

data class BebidaList(
    @SerializedName("drinks")
    val bebidaList: List<bebida>
)

@Entity(tableName = "EntityBebida")
data class bebidaEntity(
    @PrimaryKey
    val bebidaId: String,
    @ColumnInfo(name = "image_bebida")
    val image: String = "",
    @ColumnInfo(name = "nombre_bebida")
    val title: String = "",
    @ColumnInfo(name = "describe_bebida")
    val describe: String = ""
)

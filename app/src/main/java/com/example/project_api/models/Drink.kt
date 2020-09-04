package com.example.project_api.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "EntityBebida")
data class bebida(
    @SerializedName("idDrink")
    @PrimaryKey
    val bebidaId: String = "",
    @SerializedName("strDrinkThumb")
    @ColumnInfo(name = "image_bebida")
    val image: String = "",
    @SerializedName("strDrink")
    @ColumnInfo(name = "nombre_bebida")
    val title: String = "",
    @SerializedName("strInstructions")
    @ColumnInfo(name = "describe_bebida")
    val describe: String = ""
): Parcelable

data class BebidaList(
    @SerializedName("drinks")
    val bebidaList: List<bebida>
)

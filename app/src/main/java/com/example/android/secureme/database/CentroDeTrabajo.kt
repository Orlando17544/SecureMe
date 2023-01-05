package com.example.android.secureme.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "centro_de_trabajo_table")
data class CentroDeTrabajo (
    @PrimaryKey
    @ColumnInfo(name = "centroDeTrabajoId")
    var centro_de_trabajo_id: Int,

    @ColumnInfo(name = "nombre")
    var nombre: String?,

    @ColumnInfo(name = "turno")
    var turno: String?,

    @ColumnInfo(name = "zonaEscolar")
    var zona_escolar: Int?,

    @ColumnInfo(name = "municipio")
    var municipio: String?,

    @ColumnInfo(name = "area")
    var area: String?,

    @ColumnInfo(name = "longitud")
    var longitud: Float?,

    @ColumnInfo(name = "latitud")
    var latitud: Float?,

    @ColumnInfo(name = "docentes")
    var docentes: Int?,

    @ColumnInfo(name = "nivel")
    var nivel: String?,

    @ColumnInfo(name = "modalidad")
    var modalidad: String?
        )
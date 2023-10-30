package com.example.api_documentos.data.remote.dto

import androidx.room.PrimaryKey


data class DocumentosDto (
    @PrimaryKey
    var Numero : Int?=null,
    var NombreCliente: String = "",
    var Rnc: String = "",
    var Precio: Double = 0.0,
    var Cantidad: Double = 0.0,
    var Monto: Double = 0.0,
    var Fecha: String = "",
    var Ncf: String = "",
    var VencimientoNcf: String = "",

)

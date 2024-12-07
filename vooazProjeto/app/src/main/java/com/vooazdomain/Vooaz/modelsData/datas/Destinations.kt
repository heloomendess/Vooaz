package com.vooazdomain.Vooaz.modelsData.datas



data class Destinations(
    val destinationId: Int,
    val name: String,
    val category: String,
    val location: String,
    val city: String,
    val state: String,
    val rating: Int,
    val country: String,
    val phone: String,
    val schedules: String,
    val imageRes: Int,
    val description: String,
    val userComments: List<Comments>, // nome de usuario e comentario do usuario {user: User.name, "Lugar lindo cheio de natureza"}
    val accessibility: Acessibilidade

)

data class Acessibilidade(
    val VisualImpairment: Boolean,
    val HearingImpairment: Boolean
)

data class Comments(val nome:String, val Comment:String,val Rating: Int)
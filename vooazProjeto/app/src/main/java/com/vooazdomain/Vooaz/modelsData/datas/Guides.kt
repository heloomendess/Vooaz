package com.vooazdomain.Vooaz.modelsData.datas

import androidx.compose.ui.graphics.painter.Painter

data class TourismGuide(
    val tourismGuideId: Int,
    val name: String,
    val specialty: String,
    val country: String,
    val flagCountry:Int,
    val state: String,
    val city: String,
    val neighborhood: String,
    val languages: List<String>,
    val rating: Double,
    val email: String,
    val contact: String,
    val type: String,
    val disabilitySpecialty: String,
    val gender: String,
    val feedbackCount: Int,
    val age: Int,
    val imageRes: Int,
    val AboutGuide: String,
)

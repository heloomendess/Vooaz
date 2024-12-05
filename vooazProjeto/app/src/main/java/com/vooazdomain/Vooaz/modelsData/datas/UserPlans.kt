package com.vooazdomain.Vooaz.modelsData.datas

import java.util.Date


data class User(
    val userId: Int,
    val name: String,
    val country: String,
    val flagCountry:Int,
    val state: String,
    val city: String,
    val age: Int,
    val imageRes: Int,
    val AboutUser: String,
    val neighborhood: String,
    val languages: List<String>,
    val email: String,
    val password: String,
    val disabilityType: String,
    val birthDate: Date,
    val gender: String,
    val userPlans: Plans,
    val conected_users: List<User>,
)

data class Plans(
    val planId: Int,
    val planName: String,
    val monthlyFee: Double,
    val annualFee: Double,
    val benefits: List<String>
)
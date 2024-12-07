package com.vooazdomain.Vooaz.modelsData.ListOfValues

import ObjectDestination
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.constantsData.PlansConstant

import com.vooazdomain.Vooaz.modelsData.constantsData.UsersConts2

import com.vooazdomain.Vooaz.modelsData.datas.Acessibilidade
import com.vooazdomain.Vooaz.modelsData.datas.Comments
import com.vooazdomain.Vooaz.modelsData.datas.User
import java.util.Date
import com.vooazdomain.Vooaz.modelsData.datas.Destinations
import java.util.Objects


fun getOthersUsersList(): List<User?>{
    val desfault_destination by lazy {
        Destinations(
            destinationId = 1,
            name = "Avenida Paulista",
            category = "Atração Urbana",
            location = "Avenida Paulista, São Paulo",
            city = "São Paulo",
            state = "SP",
            rating = 5,
            country = "Brasil",
            phone = "+55 11 0000-0000",
            schedules = "Aberto 24h",
            imageRes = R.drawable.paulista,
            description = "A avenida mais icônica de São Paulo, repleta de museus, centros culturais e eventos.",
            userComments = listOf(
                Comments(
                    nome = "Default",
                    Comment = "Lugar maravilhoso para passear e tirar fotos!", Rating = 5
                ),
                Comments(
                    nome =  "Default",
                    Comment = "Ótimo para uma caminhada.", Rating = 5
                )
            ),
            accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
        )
    }
    var initialFlightPlan = PlansConstant.Plans.get(0)
    return listOf<User>(
        User(
            userId = 3,
            name = "Lucas Almeida",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Bahia",
            city = "Salvador",
            age = 35,
            imageRes = R.drawable.lucasalmeida,
            AboutUser = "Chef de cozinha especializado em comidas típicas.",
            neighborhood = "Barra",
            languages = listOf("Português", "Espanhol"),
            email = "lucas.almeida@gmail.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1988 - 1900, 11, 10), // 10 de Dezembro de 1988
            gender = "Masculino",
            userPlans = initialFlightPlan,
            conected_users = null,
            historicTravels = listOf<Destinations>(
                ObjectDestination().getDestinationById(2)?: desfault_destination,ObjectDestination().getDestinationById(1)?: desfault_destination,ObjectDestination().getDestinationById(2)?: desfault_destination
            )
        ),
        // Mulheres
        User(
            userId = 4,
            name = "Maria Oliveira",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "São Paulo",
            city = "Campinas",
            age = 28,
            imageRes = R.drawable.mariaoliveira,
            AboutUser = "Engenheira de software e amante de tecnologia.",
            neighborhood = "Cambuí",
            languages = listOf("Português", "Inglês"),
            email = "maria.oliveira@gmail.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1995 - 1900, 7, 25), // 25 de Agosto de 1995
            gender = "Feminino",
            userPlans = initialFlightPlan,
            conected_users = null,
            historicTravels = listOf<Destinations>(
                ObjectDestination().getDestinationById(2)?: desfault_destination,ObjectDestination().getDestinationById(1)?: desfault_destination,ObjectDestination().getDestinationById(2)?: desfault_destination
            )
        ),
        User(
            userId = 5,
            name = "Ana Souza",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Rio Grande do Sul",
            city = "Porto Alegre",
            age = 31,
            imageRes = R.drawable.anasouza,
            AboutUser = "Médica apaixonada por viagens culturais.",
            neighborhood = "Moinhos de Vento",
            languages = listOf("Português", "Francês"),
            email = "ana.souza@gmail.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1992 - 1900, 9, 5), // 5 de Outubro de 1992
            gender = "Feminino",
            userPlans = initialFlightPlan,
            conected_users = null,
            historicTravels = listOf<Destinations>(
                ObjectDestination().getDestinationById(2)?: desfault_destination,ObjectDestination().getDestinationById(1)?: desfault_destination,ObjectDestination().getDestinationById(2)?: desfault_destination
            )

    )
    )
}
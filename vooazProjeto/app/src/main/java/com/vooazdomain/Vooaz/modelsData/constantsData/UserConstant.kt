package com.vooazdomain.Vooaz.modelsData.constantsData

import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.datas.User
import java.util.Date

var initialFlightPlan = PlansConstant.Plans.get(0)
var explorerPlan = PlansConstant.Plans.get(1)

object UsersConts {
    val users = listOf(
        User(
            userId = 1,
            name = "Danilo de Santana Alcantara",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "São Paulo",
            city = "São Paulo",
            age = 30,
            imageRes = R.drawable.daniloalcantara, // Substitua pelo recurso real
            AboutUser = "Amo explorar novos lugares e fazer trilhas.",
            neighborhood = "Vila Mariana",
            languages = listOf("Português"),
            email = "danilo.alcantara.2003y@email.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1993 - 1900, 5, 15), // 15 de Junho de 1993
            gender = "Masculino",
            userPlans = initialFlightPlan,
            conected_users = UsersConts2.otherusers // Será atualizado posteriormente
        ),
        User(
            userId = 2,
            name = "Carlos Pereira",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Rio de Janeiro",
            city = "Rio de Janeiro",
            age = 27,
            imageRes = R.drawable.carlospereira,
            AboutUser = "Designer apaixonado por arte e fotografia.",
            neighborhood = "Copacabana",
            languages = listOf("Português", "Inglês"),
            email = "carlos.pereira@gmail.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1996 - 1900, 2, 20), // 20 de Março de 1996
            gender = "Masculino",
            userPlans = initialFlightPlan,
            conected_users = UsersConts2.otherusers
        ),
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
            conected_users = UsersConts2.otherusers
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
            conected_users = UsersConts2.otherusers
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
            conected_users = UsersConts2.otherusers
        )
    )
}


object UsersConts2 {
    val otherusers = listOf(
                User(
                    userId = 7,
                    name = "Gabriel Oliveira",
                    country = "Brasil",
                    flagCountry = R.drawable.ico_flag_brasil,
                    state = "São Paulo",
                    city = "São Paulo",
                    age = 25,
                    imageRes = R.drawable.gabrieloliveira,
                    AboutUser = "Apaixonado por tecnologia e viagens, Gabriel adora explorar lugares novos e conhecer pessoas interessantes.",
                    neighborhood = "Jardins",
                    languages = listOf("Português", "Inglês"),
                    email = "gabriel.oliveira@example.com",
                    password = "123456",
                    disabilityType = "Nenhuma",
                    birthDate = Date(1998 - 1900, 3, 12),
                    gender = "Masculino",
                    userPlans =initialFlightPlan,
                    conected_users = listOf() // Inicialmente sem conexões
                ),
        User(
            userId = 8,
            name = "Larissa Souza",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Rio de Janeiro",
            city = "Rio de Janeiro",
            age = 28,
            imageRes = R.drawable.larissasouza,
            AboutUser = "Designer gráfica que ama fotografar paisagens e criar conteúdos artísticos.",
            neighborhood = "Copacabana",
            languages = listOf("Português", "Espanhol"),
            email = "larissa.souza@example.com",
            password = "123456",
            disabilityType = "Deficiência auditiva",
            birthDate = Date(1995 - 1900, 6, 25),
            gender = "Feminino",
            userPlans = initialFlightPlan,
            conected_users = listOf() // Inicialmente sem conexões
        ),
        User(
            userId = 9,
            name = "Vinícius Santana",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Bahia",
            city = "Salvador",
            age = 32,
            imageRes = R.drawable.viniciussantana,
            AboutUser = "Engenheiro ambiental apaixonado pela preservação da natureza e ecoturismo.",
            neighborhood = "Pituba",
            languages = listOf("Português", "Inglês"),
            email = "vinicius.santana@example.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1991 - 1900, 2, 14),
            gender = "Masculino",
            userPlans =initialFlightPlan,
            conected_users = listOf() // Inicialmente sem conexões
        ),
        User(
            userId = 10,
            name = "Clara Martins",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Minas Gerais",
            city = "Belo Horizonte",
            age = 27,
            imageRes = R.drawable.claramartins,
            AboutUser = "Chef de cozinha especializada em pratos típicos mineiros e apaixonada por cultura regional.",
            neighborhood = "Savassi",
            languages = listOf("Português", "Francês"),
            email = "clara.martins@example.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1996 - 1900, 11, 5),
            gender = "Feminino",
            userPlans = initialFlightPlan,
            conected_users = listOf() // Inicialmente sem conexões
        ),
        User(
            userId = 11,
            name = "Rafael Costa",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Paraná",
            city = "Curitiba",
            age = 29,
            imageRes = R.drawable.rafaelcosta,
            AboutUser = "Publicitário que adora viajar, especialmente para destinos frios e montanhosos.",
            neighborhood = "Batel",
            languages = listOf("Português", "Espanhol"),
            email = "rafael.costa@example.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1994 - 1900, 4, 20),
            gender = "Masculino",
            userPlans =initialFlightPlan,
            conected_users = listOf() // Inicialmente sem conexões
        ),
        User(
            userId = 12,
            name = "Isabela Ribeiro",
            country = "Brasil",
            flagCountry = R.drawable.ico_flag_brasil,
            state = "Pernambuco",
            city = "Recife",
            age = 26,
            imageRes = R.drawable.isabelaribeiro,
            AboutUser = "Jornalista apaixonada por música, cultura popular e festas tradicionais brasileiras.",
            neighborhood = "Boa Viagem",
            languages = listOf("Português", "Inglês"),
            email = "isabela.ribeiro@example.com",
            password = "123456",
            disabilityType = "Nenhuma",
            birthDate = Date(1997 - 1900, 9, 15),
            gender = "Feminino",
            userPlans = initialFlightPlan,
            conected_users = listOf() // Inicialmente sem conexões
        )
    )

}
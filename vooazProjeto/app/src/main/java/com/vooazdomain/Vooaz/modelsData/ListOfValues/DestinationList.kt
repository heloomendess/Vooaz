package com.vooazdomain.Vooaz.modelsData.ListOfValues

import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.constantsData.UsersConts

import com.vooazdomain.Vooaz.modelsData.datas.Acessibilidade
import com.vooazdomain.Vooaz.modelsData.datas.Comments
import com.vooazdomain.Vooaz.modelsData.datas.Destinations

fun getDestinationList(): List<Destinations>{
    return listOf<Destinations>(
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
                
                nome =  "Default",
                Comment = "Lugar maravilhoso para passear e tirar fotos!",  Rating = 5
            ),
            Comments(
                nome =  "Default",
                Comment = "Ótimo para uma caminhada.",  Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 2,
        name = "Parque do Ibirapuera",
        category = "Parque",
        location = "Av. Pedro Álvares Cabral, São Paulo",
        city = "São Paulo",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 11 0000-1111",
        schedules = "6h às 22h",
        imageRes = R.drawable.ibirapuera,
        description = "Parque icônico com áreas para lazer, museus e eventos culturais.",
        userComments = listOf(
            Comments( "Default", Comment = "Perfeito para relaxar!",  Rating = 5),
            Comments(
                nome =  "Default",
                Comment = "Um dos meus lugares favoritos.",  Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 3,
        name = "Mercadão Municipal",
        category = "Gastronomia",
        location = "R. da Cantareira, 306",
        city = "São Paulo",
        state = "SP",
        rating = 4,
        country = "Brasil",
        phone = "+55 11 0000-2222",
        schedules = "8h às 18h",
        imageRes = R.drawable.mercadao,
        description = "Famoso pela gastronomia, incluindo o sanduíche de mortadela.",
        userComments = listOf(
            Comments("Default", Comment = "Comida deliciosa!",  Rating = 5),
            Comments(
                "Default",
                Comment = "Lugar tradicional e vibrante.",  Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = false, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 4,
        name = "Museu de Arte de São Paulo (MASP)",
        category = "Museu",
        location = "Av. Paulista, 1578",
        city = "São Paulo",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 11 0000-3333",
        schedules = "10h às 18h",
        imageRes = R.drawable.masp,
        description = "Famoso por sua arquitetura única e obras renomadas.",
        userComments = listOf(
            Comments(
                nome = "Default",
                Comment = "Um passeio incrível para os amantes de arte!",  Rating = 5
            ),
            Comments("Default", Comment = "Acervo impressionante.",  Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 5,
        name = "Catedral da Sé",
        category = "Arquitetura Religiosa",
        location = "Praça da Sé, São Paulo",
        city = "São Paulo",
        state = "SP",
        rating = 4,
        country = "Brasil",
        phone = "+55 11 0000-4444",
        schedules = "9h às 17h",
        imageRes = R.drawable.catedral_se,
        description = "Uma das maiores igrejas góticas do Brasil, localizada no coração de São Paulo.",
        userComments = listOf(
            Comments( "Default", Comment = "Lugar muito bonito e cheio de história.", Rating = 5),
            Comments( "Default", Comment = "A arquitetura é incrível!", Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 6,
        name = "Liberdade",
        category = "Bairro Cultural",
        location = "Bairro da Liberdade, São Paulo",
        city = "São Paulo",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 11 0000-5555",
        schedules = "Aberto 24h",
        imageRes = R.drawable.liberdade,
        description = "Bairro tradicional japonês com feiras, lojas temáticas e restaurantes típicos.",
        userComments = listOf(
            Comments("Default", Comment = "Ótima comida e cultura vibrante.", Rating = 5),
            Comments( "Default", Comment = "Adorei os mercados e as decorações.", Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = false)
    ),
    Destinations(
        destinationId = 7,
        name = "Edifício Altino Arantes (Farol Santander)",
        category = "Ponto Panorâmico",
        location = "R. João Brícola, 24",
        city = "São Paulo",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 11 0000-6666",
        schedules = "9h às 20h",
        imageRes = R.drawable.farol_santander,
        description = "Edifício histórico com vistas panorâmicas e exposições artísticas.",
        userComments = listOf(
            Comments( "Default", Comment = "A vista da cidade é fantástica!", Rating = 5),
            Comments( "Default", Comment = "Ótimo lugar para fotos e cultura.", Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 8,
        name = "Jardim Botânico de São Paulo",
        category = "Natureza",
        location = "Av. Miguel Estéfano, 3031",
        city = "São Paulo",
        state = "SP",
        rating = 4,
        country = "Brasil",
        phone = "+55 11 0000-7777",
        schedules = "9h às 17h",
        imageRes = R.drawable.jardim_botanico,
        description = "Local tranquilo com trilhas, jardins e estufas de plantas tropicais.",
        userComments = listOf(
            Comments( "Default", Comment = "Lugar ótimo para relaxar e conectar com a natureza.", Rating = 5),
            Comments("Default", Comment = "Perfeito para um passeio em família.", Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = false, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 9,
        name = "Theatro Municipal de São Paulo",
        category = "Arte e Cultura",
        location = "Praça Ramos de Azevedo, São Paulo",
        city = "São Paulo",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 11 0000-8888",
        schedules = "10h às 18h",
        imageRes = R.drawable.theatro_municipal,
        description = "Teatro histórico com espetáculos e uma arquitetura deslumbrante.",
        userComments = listOf(
            Comments("Default", Comment = "Assistir a um espetáculo aqui é inesquecível.", Rating = 5),
            Comments("Default", Comment = "Um ícone da cultura paulista.", Rating = 5)
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 10,
        name = "Praia de Maresias",
        category = "Praia",
        location = "Maresias, São Sebastião",
        city = "São Sebastião",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 12 0000-4444",
        schedules = "Aberto 24h",
        imageRes = R.drawable.maresias,
        description = "Famosa por suas ondas perfeitas para surfe e uma vida noturna animada.",
        userComments = listOf(
            Comments(
                nome = "Default",
                Comment = "Praia maravilhosa, perfeito para surfar!",
                Rating = 5
            ),
            Comments(
                nome = "Default",
                Comment = "O pôr do sol aqui é incrível.",
                Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = false, HearingImpairment = false)
    ),
    Destinations(
        destinationId = 11,
        name = "Praia de Juquehy",
        category = "Praia",
        location = "Juquehy, São Sebastião",
        city = "São Sebastião",
        state = "SP",
        rating = 4,
        country = "Brasil",
        phone = "+55 12 0000-5555",
        schedules = "Aberto 24h",
        imageRes = R.drawable.juquehy,
        description = "Uma praia tranquila, ideal para famílias e banhos de mar.",
        userComments = listOf(
            Comments(
                nome = "Default",
                Comment = "Ótimo lugar para relaxar com a família.",
                Rating = 5
            ),
            Comments(
                nome =  "Default",
                Comment = "Areia limpa e mar calmo, perfeito para crianças.",
                Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 12,
        name = "Praia do Guarujá",
        category = "Praia",
        location = "Centro, Guarujá",
        city = "Guarujá",
        state = "SP",
        rating = 4,
        country = "Brasil",
        phone = "+55 13 0000-6666",
        schedules = "Aberto 24h",
        imageRes = R.drawable.guaruja,
        description = "Conhecida como a 'Pérola do Atlântico', possui diversas opções de lazer e gastronomia.",
        userComments = listOf(
            Comments(
                nome =  "Default",
                Comment = "Muitas opções de quiosques e comida deliciosa.",
                Rating = 5
            ),
            Comments(
                nome = "Default",
                Comment = "Movimentada, mas ainda assim muito bonita.",
                Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = false, HearingImpairment = true)
    ),
    Destinations(
        destinationId = 13,
        name = "Ilhabela - Praia do Curral",
        category = "Praia",
        location = "Praia do Curral, Ilhabela",
        city = "Ilhabela",
        state = "SP",
        rating = 5,
        country = "Brasil",
        phone = "+55 12 0000-7777",
        schedules = "Aberto 24h",
        imageRes = R.drawable.curral,
        description = "Praia badalada com infraestrutura e águas cristalinas.",
        userComments = listOf(
            Comments(
                nome =  "Default",
                Comment = "Amei a infraestrutura, ótimo para passar o dia.",
                Rating = 5
            ),
            Comments(
                nome =  "Default",
                Comment = "Vista espetacular e água perfeita para nadar.",
                Rating = 5
            )
        ),
        accessibility = Acessibilidade(VisualImpairment = true, HearingImpairment = false)
    )
    )
}

package com.vooazdomain.Vooaz.telas.settingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily
import BottomNavigation
import androidx.compose.ui.draw.clip
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, shared: SharedModel) {
var user = shared.selectedUser
    val headerBackgroundColor = Color(0xFF3B5998)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.configurações, "Configurações"),
                        color = MaterialTheme.colorScheme. onSecondaryContainer,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = headerBackgroundColor)
            )
        },
        bottomBar = {
            BottomNavigation(navController, user)
        },
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),

        ) {
            // Header
            item {
                HeaderSection(navController, user, shared)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            // Configurações
            item {
                SectionTitle("Configurações")
            }
            item {
                SettingsOption(
                    label =stringResource(R.string.infoPessoais, "Informações pessoais"),
                    image = painterResource(id = R.drawable.profileicon),
                    navigation = navController,
                    navroute = "PersonalInfoScreen",shared
                )
            }
            // Ícone fictício substituído por outro válido
            item {
                SettingsOption(
                    label =stringResource(R.string.viagens, "Viagens"),
                    image = painterResource(id = R.drawable.malaviagem),
                    navigation = navController,
                    navroute = "TravelHistoryScreen",shared
                )
            }
            item {
                SettingsOption(
                    label =stringResource(R.string.ajustes, "Ajustes"),
                    image = painterResource(id = R.drawable.adjustsicon),
                    navigation = navController,
                    navroute = "AdjustsScreen",shared
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            // Assinatura
            item {
                SectionTitle("Sobre nós")
            }
            item {
                SettingsOption(
                    label = stringResource(R.string.about_us),
                    image = painterResource(id = R.drawable.ico_check),
                    navigation = navController,
                    navroute = "AboutUsScreen",shared
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            // Atendimento
            item {
                SectionTitle("Atendimento")
            }
            item {
                SettingsOption(
                    label = stringResource(R.string.ajuda,"Central de ajuda"),
                    image = painterResource(id = R.drawable.sinalinterrogacao),
                    navigation = navController,
                    navroute = "HelpCenterScreen",
                    shared
                )
            }
            item {
                SettingsOption(
                    label = stringResource(R.string.feedback,"Enviar seu feedback"),
                    image = painterResource(id = R.drawable.lapis),
                    navigation = navController,
                    navroute = "FeedbackScreen",shared
                )
            }
            item {
                Spacer(modifier = Modifier.height(15.dp))
                SectionTitle("Sair")
            }
            item {
                SettingsOption(
                    label = "Sair da conta",
                    image = painterResource(id = R.drawable.close),
                    navigation = navController,
                    navroute = "InputScreen",
                    shared = shared
                )
            }
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }

        }

    }
}

@Composable
fun HeaderSection(navController: NavController, user: User?, shared: SharedModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth().clickable {

                navController.navigate("ProfileScreen")
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


            Image(
                modifier = Modifier
                    .width(87.dp).clip(shape = RoundedCornerShape(200.dp))
                    .height(87.dp),
                painter = painterResource(user?.imageRes?: R.drawable.personicon),

                contentDescription = stringResource(R.string.imagem,"Imagem do usuario"),

                contentScale = ContentScale.FillBounds
            )

        Spacer(modifier = Modifier.width(12.dp))

        // Nome e botão
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(R.string.nome,user?.name ?: "Nome padrao"),
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(

                text = stringResource(R.string.perfil,"Mostrar perfil"),
                color = MaterialTheme.colorScheme.onSecondary,
              

            )
        }

        Image(
            painterResource(R.drawable.walkingstickicon),
            contentDescription = stringResource(R.string.icone,"walking stick"),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        IconButton(onClick = {
            navController.navigate("ProfileScreen")
        }) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = stringResource(R.string.perfil,"Ver perfil"),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontFamily = poppinsFontFamily,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onSecondary,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun SettingsOption(label: String, image: Painter, navigation: NavController, navroute: String,shared: SharedModel) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Row(
            Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 10.dp)
                .height(70.dp)
                .background(
                    color = if (label != "Sair da conta") {
                        MaterialTheme.colorScheme.onBackground
                    } else {
                        Color.Red
                    }, shape = RoundedCornerShape(size = 15.dp)
                ).clickable {
                    if (navroute != "InputScreen") {
                        navigation.navigate(navroute)
                    } else {

                        shared.setSelectedUser(null)
                        shared.setSelectedOtherUser(null)
                        shared.setSelectedDestination(null)
                        shared.setSelectedGuide(null)
                        navigation.popBackStack(route = navroute, inclusive = false)
                    }
                },
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                Image(
                    painter = image,
                    contentDescription = stringResource(R.string.imagem, "image description"),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.padding(start = 20.dp)
                        .size(30.dp).fillMaxHeight()

                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                Text(
                    text = label,
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(500),
                        color = MaterialTheme.colorScheme.inverseOnSurface,

                        ),
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
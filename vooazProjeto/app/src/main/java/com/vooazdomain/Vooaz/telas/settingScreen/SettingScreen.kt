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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import navigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    // Cores e estilos personalizados
    val backgroundColor = Color(0xFFECECEC) // Cinza claro
    val headerBackgroundColor = Color(0xFF3B5998) // Azul
    val white = Color.White

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Configurações",
                        color = white,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Ação ao voltar */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = white
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = headerBackgroundColor)
            )
        },
        bottomBar = {
            navigationBar(navController)
        },
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Header
            item {
                HeaderSection(navController)
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
                    label = "Informações pessoais",
                    image = painterResource(id = R.drawable.profileicon),
                    navigation = navController,
                    navroute = "PersonalInfoScreen"
                )
            }
            // Ícone fictício substituído por outro válido
            item {
                SettingsOption(
                    label = "Viagens",
                    image = painterResource(id = R.drawable.malaviagem),
                    navigation = navController,
                    navroute = "ForgotPasswordPin"
                )
            }
            item {
                SettingsOption(
                    label = "Ajustes",
                    image = painterResource(id = R.drawable.adjustsicon),
                    navigation = navController,
                    navroute = "ForgotPasswordPin"
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
                    label = "Sobre nós",
                    image = painterResource(id = R.drawable.ico_check),
                    navigation = navController,
                    navroute = "ForgotPasswordPin"
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
                    label = "Central de ajuda",
                    image = painterResource(id = R.drawable.sinalinterrogacao),
                    navigation = navController,
                    navroute = "ForgotPasswordPin"
                )
            }
            item {
                SettingsOption(
                    label = "Enviar seu feedback",
                    image = painterResource(id = R.drawable.lapis),
                    navigation = navController,
                    navroute = "ForgotPasswordPin"
                )
            }

        }

    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagem do perfil

            // Substitua por um ImageLoader ou Coil para imagens reais
            Image(
                modifier = Modifier
                    .width(87.dp)
                    .height(87.dp),
                painter = painterResource(id = R.drawable.examplepeopleprofile),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )

        Spacer(modifier = Modifier.width(12.dp))

        // Nome e botão
        Column(modifier = Modifier.weight(1f).clickable {
navController.navigate("ProfileScreen")
        }) {
            Text(
                text = "Lais Ribeiro",
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Mostrar perfil",
                color = Color.Black,

            )
        }

        Image(
            painterResource(R.drawable.walkingstickicon),
            contentDescription = "walking stick",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        IconButton(onClick = {
            navController.navigate("ProfileScreen")
        }) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Ver perfil",
                tint = Color(0xFF3B5998)
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        color = Color.Black,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun SettingsOption(label: String, image: Painter, navigation: NavController, navroute: String) {
    Row(
        Modifier
            .width(350.dp)
            .padding(start = 30.dp, top = 10.dp)
            .height(70.dp)
            .background(color = Color(0xFF4059AD), shape = RoundedCornerShape(size = 15.dp)).clickable {
    navigation.navigate(navroute)
            },
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Image(
                painter = image,
                contentDescription = "image description",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(start = 20.dp)
                    .size(30.dp).fillMaxHeight()

            )
        }
        Spacer(modifier = Modifier.width(30.dp))
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFECECEE),

                    ),
            )
        }
    }
}
@Composable
@Preview
fun SettingsScreenPreview(){
    SettingsScreen(rememberNavController())
}
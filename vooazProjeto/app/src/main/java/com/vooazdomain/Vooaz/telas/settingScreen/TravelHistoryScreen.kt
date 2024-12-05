package com.vooazdomain.Vooaz.telas.settingScreen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelHistoryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.voltar),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(top = 2.dp)
                            .clickable { navController.popBackStack() }
                    )
                },
                title = { Text("Minhas Viagens") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onBackground,
                    titleContentColor = Color.White
                )
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF5F5F5))
                    .padding(paddingValues)
            ) {
                TravelList()
            }
        }
    )
}

@Composable
fun TravelList() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            var historico = getSampleTravels()
            historico.forEach() { travel ->
                TravelCard(travel)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun TravelCard(travel: Travel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            // Background Image
            Image(
                painter = painterResource(id = travel.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Text Overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(8.dp)
            ) {
                Column {
                    Text(
                        text = travel.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = travel.description,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

data class Travel(
    val title: String,
    val description: String,
    val imageResId: Int
)

fun getSampleTravels(): List<Travel> {
    return listOf(
        Travel(
            title = "Avenida Paulista",
            description = "O coração de São Paulo, repleto de cultura e história.",
            imageResId = R.drawable.paulista
        ),
        Travel(
            title = "Parque do Ibirapuera",
            description = "Oásis verde no meio da cidade, ideal para relaxar e se conectar com a natureza.",
            imageResId = R.drawable.ibirapuera
        ),
        Travel(
            title = "Mercadão Municipal",
            description = "Conheça o famoso pastel de bacalhau e outras delícias paulistas.",
            imageResId = R.drawable.mercadao
        ),
        Travel(
            title = "Liberdade",
            description = "Explore a cultura japonesa e aproveite comidas típicas únicas.",
            imageResId = R.drawable.liberdade
        )
    )
}

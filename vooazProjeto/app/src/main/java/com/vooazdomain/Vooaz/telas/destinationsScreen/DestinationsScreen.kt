package com.vooazdomain.Vooaz.telas.destinationsScreen

import BottomNavigation
import ObjectDestination
import com.vooazdomain.Vooaz.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.Destinations
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@Composable
fun DestinationsScreen(navController: NavController, destinations: List<Destinations>, sharedModel: SharedModel, category: String = "São Paulo") {
    var expanded = remember { mutableStateOf(false) }
    var selectDestination = remember { mutableStateOf(category) }
    Scaffold(
        topBar = {
            HeaderSectionDestinations()
        },
        bottomBar ={BottomNavigation(navController, sharedModel.selectedUser)},
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer,

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(end = 30.dp)) {
                Spacer(modifier = Modifier.width(20.dp))

            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    HeaderDestinationFilter(
                        MaterialTheme.colorScheme.onTertiary,
                        expanded,
                        selectDestination
                    )
                }
                if (selectDestination.value == "São Paulo") {
                    destinations.forEach { destinations ->
                        item {
                            CardItem(destination = destinations, navController, sharedModel)
                        }
                    }
                } else {
                    ObjectDestination().getDestinationsByCategory(selectDestination.value)
                        .forEach { destinations ->
                            item {
                                CardItem(destination = destinations, navController, sharedModel)
                            }
                        }

                }
            }
            }
        }
    }
@Composable
fun CardItem(destination: Destinations, navController: NavController,  sharedModel: SharedModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp).clickable {
                sharedModel.setSelectedDestination(destination)
                navController.navigate("DestinationDetailsScreen")
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {

            Image(
                painter = painterResource(id = destination?.imageRes?: R.drawable.ico_flag_brasil),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
                    .padding(8.dp)
            ) {
                Column {
                    Text(
                        text = destination.name ?:"Default",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = destination.description ?:"Defaul",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun HeaderDestinationFilter(primaryColor: Color, expanded: MutableState<Boolean>, selectedDestination: MutableState<String>) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Spacer(modifier = Modifier.height(3.dp))
        Box(modifier = Modifier
            .width(240.dp)
            .height(55.dp)
            .background(
                color = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .clickable {

                expanded.value = !expanded.value
            }, contentAlignment = Alignment.Center
        ) {
            Text(
                text = selectedDestination.value,
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier
                    .width(240.dp)
                    .padding(start = 20.dp)
                    .height(90.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        shape = RoundedCornerShape(size = 15.dp)
                    )
            ) {
                listOf(
                    "São Paulo",
                    "Atração Urbana",
                    "Parque",
                    "Gastronomia",
                    "Museu",
                    "Arquitetura Religiosa",
                    "Bairro Cultural",
                    "Ponto Panorâmico",
                    "Natureza",
                    "Arte e Cultura",
                    "Praia"
                ).forEach { category ->
                    DropdownMenuItem(
                        text = { Text(category) },
                        onClick = {
                            selectedDestination.value = category
                            expanded.value = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderSectionDestinations() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = R.drawable.logoaz),
            contentDescription = "Logo",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop,
        )


        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ico_bell_blue),
                contentDescription = "Notificações",
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

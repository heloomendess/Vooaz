package com.vooazdomain.Vooaz.telas.azconnect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu

import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectionsSearchScreen(navController: NavController, connections: List<connections>) {

    val primaryColor = Color(0xFFFFC107) // Amarelo


    Scaffold(
        topBar = {
            Row(modifier = Modifier.background(MaterialTheme.colorScheme.onSecondaryContainer).padding(top=20.dp)) {


                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.voltar),
                    modifier = Modifier.size(60.dp).padding(start = 20.dp, top = 15.dp).clickable {
                        navController.popBackStack()
                    },
                    tint =MaterialTheme.colorScheme.onSecondary
                )


                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.padding(end = 60.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.logoaz),
                            contentDescription = stringResource(R.string.logo_description,"image description"),
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(75.dp)
                                .height(73.dp)
                        )
                    }
                }
            }}
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize().background(Color.White)
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Text(
                    text = stringResource(R.string.az,"AZ Conecta"),
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontSize = 29.sp,
                        lineHeight = 28.24.sp,
                        fontWeight = FontWeight(800),
                        color = MaterialTheme.colorScheme.onSecondary,
                        textAlign = TextAlign.Center,

                        ),
                    modifier = Modifier
                        .width(173.dp)
                        .height(28.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            // Campo de busca
            item {
                SearchField()
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
            // Lista de destinos dinâmica
            item {
                ConnectionsGrid(connections = connections, primaryColor = primaryColor, navController)
            }
            }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField() {
    var searchQuery by remember { mutableStateOf("") }

    SearchBar(
        colors = SearchBarDefaults.colors(containerColor = Color(0xFF9AB8D2)),
        query = "",
        onQueryChange = {},
        placeholder = {
            Text("Pesquise destinos")
        },
        onSearch = {},
        active = false,
        onActiveChange = {},
        leadingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "" // Add a valid content description
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "" // Add a valid content description
                )
            }
        }
    ) { }
}

@Composable
fun ConnectionsGrid(connections: List<connections>, primaryColor: Color, controller: NavController) {
    Column {
        connections.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                rowItems.forEach { connections ->
                    ConnectionsCard(connections = connections, primaryColor = primaryColor, controller = controller)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ConnectionsCard(connections: connections, primaryColor: Color, controller: NavController) {
    Column(
        modifier = Modifier
            .width(158.dp).height(191.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(primaryColor)
            .clickable {
                controller.navigate(connections.route)
            }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagem de perfil simulada
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiary),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = connections.img),
                contentDescription = stringResource(R.string.imagem,"image description"),
                contentScale = ContentScale.FillBounds
            , modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Nome do destino
        Text(
            text = connections.name,
            fontFamily = poppinsFontFamily,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 14.56.sp,

                fontWeight = FontWeight(700),
                color=MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center,
            ),
                modifier = Modifier
                    .width(192.dp)
                    .height(14.dp)

        )
        Spacer(modifier = Modifier.height(4.dp))
        // Localização do destino
        Text(
            text = connections.location,
            fontFamily = poppinsFontFamily,
            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}

// Classe de dados para os destinos
data class connections(
    val name: String,
    val location: String,
    val img: Int,
    val route: String
)

// Pré-visualização da tela
@Preview(showBackground = true)
@Composable
fun ConnectionsSearchScreenPreview() {
    val sampleDestinations = listOf(
        connections("Fabio Nascimento", "Paris, França", R.drawable.ic_profile_placeholder, ""),
        connections("Maria Valentina", "São Paulo, Brasil", R.drawable.examplepeopleprofile, ""),
        connections("Lucas Amorim", "Santa Catarina, Brasil", R.drawable.ic_profile_placeholder3, ""),
        connections("Alessandra Luz", "Veneza, Itália", R.drawable.ic_profile_placeholder4, ""),
        connections("João Silva", "Lisboa, Portugal", R.drawable.ic_profile_placeholder5, "")
    )
    ConnectionsSearchScreen(rememberNavController(),connections = sampleDestinations)
}

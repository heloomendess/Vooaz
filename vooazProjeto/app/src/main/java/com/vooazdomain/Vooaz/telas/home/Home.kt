package com.vooazdomain.Vooaz.telas.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import BottomNavigation
import ObjectDestination
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.Destinations
import com.vooazdomain.Vooaz.modelsData.datas.User


@Composable
fun HomePageScreen(navController: NavController, sharedModel: SharedModel) {
    var user = sharedModel.selectedUser

    Scaffold(
        topBar = {
            // Cabeçalho com logo e notificações
            HeaderSection(user, navController)
        },
        bottomBar = {
            BottomNavigation(navController, user)
        },
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .verticalScroll(rememberScrollState())

        ) {


            // Título principal
            SectionTitle("Qual será sua próxima aventura?")

            // Carrossel horizontal para viagens em destaque
            HighlightedTripsSection(navController,sharedModel)

            // Turismo perto de você
            SectionTitle("Turismo perto de você: São Paulo Capital:")
            NearbyPlacesSection(navController, sharedModel)

            // Praias perto de você
            SectionTitle("Praias:")
            BeachSection(navController, sharedModel)
            //Spacer(modifier = Modifier.height(72.dp))

        }
    }
}

@Composable
fun HeaderSection(user: User?, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logoaz),
            contentDescription = "Logo",
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Crop,
        )

        // Notificações e avatar
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ico_bell_blue),
                contentDescription = "Notificações",
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            val imageRes = user?.imageRes ?: R.drawable.ico_emoji
            Image(
                painter = painterResource(imageRes),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape).clickable {
                        navController.navigate("ProfileScreen")
                    }
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
        fontFamily = poppinsFontFamily
    )
}

@Composable
fun HighlightedTripsSection(navController: NavController, sharedModel: SharedModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 30.dp)
    ) {

        repeat(5) { // Simulação de múltiplos cartões
            Spacer(modifier = Modifier.width(36.dp))
            ObjectDestination().getAllDestination().forEach { destination ->
                HighlightedTripCard(
                    navController = navController,
                    destination, sharedModel
                )
                Spacer(modifier = Modifier.width(36.dp))
            }
        }
    }
}

@Composable
fun HighlightedTripCard(navController: NavController,destinations: Destinations, sharedModel: SharedModel) {

    Card(
        modifier = Modifier
            .width(300.dp)
            .background(MaterialTheme.colorScheme.onBackground, RoundedCornerShape(19.dp))
            .shadow(12.dp, RoundedCornerShape(19.dp))
            .clip(RoundedCornerShape(12.dp))
            .clickable {
            sharedModel.setSelectedDestination(destinations)
                navController.navigate("DestinationDetailsScreen")  },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground),
    ) {

        Column(

        ) {
            Image(
                painter = painterResource(destinations.imageRes),
                contentDescription = destinations.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = destinations.name,
                style = TextStyle(
                    fontSize = 17.sp,
                    lineHeight = 19.48.sp,
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center,

                    ),
                maxLines = 1,
                modifier = Modifier
                    .width(301.dp)
                    .height(19.dp)
            )


        }
        Spacer(modifier = Modifier.height(15.dp))


    }

}


@Composable
fun NearbyPlacesSection(navController: NavController, sharedModel: SharedModel) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .align(Alignment.End)
                .width(90.dp)
                .height(34.dp)
        ) {
            Text(
                "Ver mais",
                fontFamily = poppinsFontFamily,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ObjectDestination().getAllDestination().forEach { destination ->
                    Spacer(modifier = Modifier.width(8.dp))
                    PlaceCard(destination, navController =navController, sharedModel = sharedModel )
                    Spacer(modifier = Modifier.width(8.dp))
            }
        }

    }
}


@Composable
fun BeachSection(navController: NavController, sharedModel: SharedModel) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .align(Alignment.End)
                .width(90.dp)
                .height(34.dp)
        ) {
            Text(
                "Ver mais",
                fontFamily = poppinsFontFamily,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ObjectDestination().getAllDestination().forEach { destination ->
                if (destination.category == "Praia") {

                    Spacer(modifier = Modifier.width(8.dp))
                    PlaceCard(destination, navController = navController, sharedModel = sharedModel)
                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun PlaceCard(destinations: Destinations, sharedModel: SharedModel, navController: NavController) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .shadow(4.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable {
                sharedModel.setSelectedDestination(destinations)
                navController.navigate("DestinationDetailsScreen")
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(destinations.imageRes),
                contentDescription = destinations.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = destinations.name,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 19.48.sp,
                    fontWeight = FontWeight(600),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily

                ),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(19.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

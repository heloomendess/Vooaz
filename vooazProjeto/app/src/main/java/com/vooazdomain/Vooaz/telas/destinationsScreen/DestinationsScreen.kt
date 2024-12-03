package com.vooazdomain.Vooaz.telas.destinationsScreen

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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@Composable
fun CapitalScreen(navController: NavController  ,destinations: List<DestinationCard>) {
    val backgroundColor = Color(0xFFECECEC) // Light gray background
    val primaryColor = Color(0xFF0E2C8F) // Blue color for cards and header
    val textColor = Color(0xFFECECEC)
    Scaffold(
        topBar = {
            TopBar(primaryColor = primaryColor)
        },
        containerColor = backgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderText(primaryColor = textColor)

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(destinations.size) { index ->
                    CardItem(destination = destinations[index], primaryColor = primaryColor)
                }
            }
        }
    }
}

@Composable
fun TopBar(primaryColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth().height(100.dp)
            .background(MaterialTheme.colorScheme.onSecondaryContainer)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.voltar,"Voltar"),
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.size(35.dp).clickable {

            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.logoaz),
            contentDescription = stringResource(R.string.logo,"Logo"),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painterResource(R.drawable.ico_bell_blue),
            contentDescription =stringResource(R.string.imagem, "image description"),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding()
                .size(40.dp).fillMaxHeight()

        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Image(
                painterResource(R.drawable.ico_profileblue),
                contentDescription = stringResource(R.string.imagem,"image description"),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding()
                    .size(40.dp).fillMaxHeight()

            )
        }
    }
}

@Composable
fun HeaderText(primaryColor: Color) {
    Spacer(modifier = Modifier.height(3.dp))
    Box(modifier = Modifier
        .width(240.dp)
        .height(55.dp)
        .background(color = MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(size = 20.dp)), contentAlignment = Alignment.Center) {
        Text(
            text = "SP - Capital",
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )
    }
}

@Composable
fun CardItem(destination: DestinationCard, primaryColor: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { /* Handle click */ },
        colors = CardDefaults.cardColors(containerColor = primaryColor)
    ) {
        Column(
horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = destination.imageRes),
                contentDescription = destination.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth()
                    .height(280.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = destination.title,
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontSize = 24.sp,
                    lineHeight = 19.48.sp,
                    fontWeight = FontWeight(600),
                    color =MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center,

                ),
                maxLines = 1,
                modifier = Modifier
                        .width(231.dp)
                    .height(19.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

// Data class for destination items
data class DestinationCard(val title: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun CapitalScreenPreview() {
    val sampleDestinations = listOf(
        DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
        DestinationCard("Museu Catavento", R.drawable.museucatavento),
                DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
        DestinationCard("Museu Catavento", R.drawable.museucatavento),
        DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
        DestinationCard("Museu Catavento", R.drawable.museucatavento),
                DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
        DestinationCard("Museu Catavento", R.drawable.museucatavento),
    )
    CapitalScreen(rememberNavController(),destinations = sampleDestinations)
}

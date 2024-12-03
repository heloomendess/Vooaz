package com.vooazdomain.Vooaz.telas.guidesSearch

import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Guide
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
import com.vooazdomain.Vooaz.telas.destinationsScreen.TopBar
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

import navigationBar

@Composable
fun GuidesScreen(navController: NavController) {
    Scaffold(

        topBar = {
            TopBar()
        },
        bottomBar = {
            navigationBar(navController)
        },
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) { innerpadding ->
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme. outlineVariant).padding(innerpadding),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {




                // Lista de Guias
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Spacer(
                        modifier = Modifier.height(16.dp))
                    Row (modifier = Modifier.padding(end = 30.dp)){

                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(R.string.back, "back"), modifier = Modifier.padding(end = 30.dp).size(40.dp))
                        HeaderGuidesFilter(MaterialTheme.colorScheme.onTertiary)
                    }
                    Spacer(modifier = Modifier.height(16.dp))


                    val guides = listOf(
                        Guide(
                            "Marina Guimarães",
                            5.0,
                            550,
                            32,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        ),
                        Guide(
                            "Priscila Furlan",
                            5.0,
                            200,
                            28,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        ),
                        Guide(
                            "Henrique Costa",
                            4.9,
                            679,
                            45,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        ),
                        Guide(
                            "Valentina Almeida",
                            4.9,
                            143,
                            22,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        ),
                        Guide(
                            "Justino",
                            4.7,
                            130,
                            26,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        ),
                        Guide(
                            "Rose Santos",
                            4.7,
                            30,
                            23,
                            "São Paulo - Capital",
                            R.drawable.ic_profile_placeholder2
                        )
                    )

                    guides.forEach { guide ->
                        GuideCard(guide)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(72.dp))

        }
    }
}


@Composable
fun HeaderGuidesFilter(primaryColor: Color) {
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("Selecione seu gênero") }
    Spacer(modifier = Modifier.height(3.dp))
    Box(modifier = Modifier
        .width(240.dp)
        .height(55.dp)
        .background(color= MaterialTheme.colorScheme.onSurface, shape = RoundedCornerShape(size = 20.dp)).clickable {
            
            expanded= !expanded
        }, contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(R.string.guias,"Guias"),
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
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(240.dp).padding(start = 20.dp)
                .height(90.dp)
                .background(color = MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(size = 15.dp))
        ) {
            listOf("Masculino", "Feminino", "Outro").forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender) },
                    onClick = {
                        selectedGender = gender
                        expanded = false
                    }
                )
            }
        }
    }
}
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp).height(80.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoaz),
            contentDescription = stringResource(R.string.logo,"Logo"),
            modifier = Modifier.size(68.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Bell Action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ico_bell_blue),
                contentDescription = stringResource(R.string.iconNotificações ,"Notificações"),
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.ico_profile_blue),
            contentDescription = stringResource(R.string.iconPerfil,"Perfil"),
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
fun GuideCard(guide: Guide) {
    Row(
        modifier = Modifier
            .fillMaxWidth().border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme. onSecondaryContainer, RoundedCornerShape(12.dp))
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = guide.imageRes),
            contentDescription = guide.name,
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = guide.name,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row() {
                Icon(imageVector = Icons.Default.Star, contentDescription = "estrela", modifier =Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "${guide.rating} (${guide.feedbackCount} avaliações)",
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    color= MaterialTheme.colorScheme.surfaceContainerLowest
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Idade: ${guide.age}",
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = "Local: ${guide.location}",
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

// Modelo de dados para guia
data class Guide(
    val name: String,
    val rating: Double,
    val feedbackCount: Int,
    val age: Int,
    val location: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun GuidesScreenPreview() {
    GuidesScreen(rememberNavController())
}

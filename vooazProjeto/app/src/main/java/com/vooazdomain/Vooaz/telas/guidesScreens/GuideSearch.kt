package com.vooazdomain.Vooaz.telas.guidesScreens

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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.datas.TourismGuide
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


import BottomNavigation
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel

@Composable
fun GuideSearch(navController: NavController, shareModel: SharedModel) {
    var user  = shareModel.selectedUser
    var expanded = remember { mutableStateOf(false) }
    var selectedGender = remember { mutableStateOf("Selecione seu gênero") }
    Scaffold(

        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigation(navController, user)
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
                        modifier = Modifier.height(16.dp)
                    )
                    Row(modifier = Modifier.padding(end = 30.dp)) {
                        Spacer(modifier = Modifier.width(20.dp))
                        HeaderGuidesFilter(
                            MaterialTheme.colorScheme.onTertiary,
                            expanded,
                            selectedGender
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    val guides = GuidesContants.guidesObj

                    guides.forEach { guide ->
                        when (selectedGender.value) {
                            "Selecione seu gênero" -> {
                                GuideCard(guide, shareModel, navController)
                                Spacer (modifier = Modifier.height(12.dp))
                            }
                            "Outro" -> {
                                GuideCard(guide,shareModel,  navController)
                                Spacer (modifier = Modifier.height(12.dp))
                            }
                            "Masculino" -> {

                                if (guide.gender == "Masculino"){
                                    GuideCard(guide,shareModel,  navController)
                                    Spacer (modifier = Modifier.height(12.dp))
                                }
                            }
                            "Feminino" -> {
                                if (guide.gender == "Feminino"){
                                    GuideCard(guide,shareModel,  navController)
                                    Spacer (modifier = Modifier.height(12.dp))
                                }
                            }



                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(72.dp))

        }
    }
}


@Composable
fun HeaderGuidesFilter(primaryColor: Color, expanded:MutableState<Boolean>, selectedGender:MutableState<String>) {

    Spacer(modifier = Modifier.height(3.dp))
    Box(modifier = Modifier
        .width(240.dp)
        .height(55.dp)
        .background(color= MaterialTheme.colorScheme.onSurface, shape = RoundedCornerShape(size = 20.dp)).clickable {

            expanded.value= !expanded.value
        }, contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(R.string.guias,"Guias"),
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
            modifier = Modifier.width(240.dp).padding(start = 20.dp)
                .height(90.dp)
                .background(color = MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(size = 15.dp))
        ) {
            listOf("Masculino", "Feminino", "Outro").forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender) },
                    onClick = {
                        selectedGender.value = gender
                        expanded.value = false
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
fun GuideCard(guide: TourismGuide,shared:SharedModel, navController: NavController) {



    Row(
        modifier = Modifier
            .fillMaxWidth().border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme. onSecondaryContainer, RoundedCornerShape(12.dp))
            .padding(16.dp).clickable {
            shared.setSelectedGuide(guide)
                navController. navigate("GuidesProfile")
            },

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
                color = MaterialTheme.colorScheme.onSecondary
            )
            Text(
                text = "Local: ${guide.state}",
                fontSize = 14.sp,
                fontFamily = poppinsFontFamily,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

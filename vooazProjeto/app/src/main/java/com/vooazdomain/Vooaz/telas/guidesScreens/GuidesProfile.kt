package com.vooazdomain.Vooaz.telas.guidesScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.TourismGuide
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily
@Composable

fun GuidesProfile(navController: NavHostController, selectedModel: SharedModel) {
    val backgroundColor = Color(0xFFF4B942) // Fundo do cabeçalho
    val containerColor = Color(0xFFF5F5F5) // Fundo geral da tela
    val whatsappIcon = painterResource(R.drawable.ic_whatsapp)
    val instagramIcon = painterResource(R.drawable.instagram)
    val facebookIcon = painterResource(R.drawable.facebook)
var guide = selectedModel.selectedGuides
    Scaffold(
        containerColor = backgroundColor,
        topBar = {
            Row(modifier = Modifier.background(containerColor).padding(top = 20.dp)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    modifier = Modifier.size(60.dp).padding(start = 20.dp, top = 15.dp).clickable {
                        navController.popBackStack()
                    },
                    tint = MaterialTheme.colorScheme.onSecondary
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.padding(end = 60.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.logoaz),
                            contentDescription = "Logo VooAz",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(75.dp)
                                .height(73.dp)
                        )
                    }
                }
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Cabeçalho
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backgroundColor)
                            .padding(15.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            // Imagem de perfil
                            Image(
                                painter = painterResource(guide?.imageRes?: 1),
                                contentDescription = "Imagem do Guia",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(128.dp)
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        shape = CircleShape
                                    )
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            // Informações principais
                            Column(modifier = Modifier.width(210.dp)) {
                                Row {
                                    Text(
                                        text = guide?.name ?: "Default",
                                        style = TextStyle(
                                            fontFamily = poppinsFontFamily,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Image(
                                        painter = painterResource(R.drawable.hearingaidicon),
                                        contentDescription = "Ícone",
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(guide?.flagCountry?: 1),
                                        contentDescription = "Bandeira do País",
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "${guide?.city}, ${guide?.country}",
                                        fontFamily = poppinsFontFamily,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Button(
                                    onClick = { /* Ação de conectar */ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF3366FF)
                                    ),
                                    modifier = Modifier.padding(start = 20.dp)
                                ) {
                                    Text(
                                        text = "Conectar",
                                        fontFamily = poppinsFontFamily,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }

                // Sobre o Guia
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(size = 3.dp)
                            )
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Sobre ${guide?.name}:",
                            fontFamily = poppinsFontFamily,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        )
                        Spacer(modifier = Modifier.height(28.dp))
                        Text(
                            text = guide?.AboutGuide?: "Default",
                            style = TextStyle(
                                fontFamily = poppinsFontFamily,
                                fontSize = 19.sp,
                                lineHeight = 18.36.sp,
                                fontWeight = FontWeight(400),
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Justify,
                            ),
                            modifier = Modifier
                                .width(270.dp)
                                .heightIn(351.dp, 900.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

                // Contatos
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backgroundColor)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Entre em contato",
                            fontFamily = poppinsFontFamily,
                            style = TextStyle(
                                fontSize = 21.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                textAlign = TextAlign.Center
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { /* Ação WhatsApp */ }) {
                                Icon(
                                    painter = whatsappIcon,
                                    contentDescription = "WhatsApp",
                                    modifier = Modifier.size(30.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            IconButton(onClick = { /* Ação Instagram */ }) {
                                Icon(
                                    painter = instagramIcon,
                                    contentDescription = "Instagram",
                                    modifier = Modifier.size(55.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            IconButton(onClick = { /* Ação Facebook */ }) {
                                Icon(
                                    painter = facebookIcon,
                                    contentDescription = "Facebook",
                                    modifier = Modifier.size(30.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

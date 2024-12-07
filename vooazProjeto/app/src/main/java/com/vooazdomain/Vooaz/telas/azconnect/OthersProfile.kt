package com.vooazdomain.Vooaz.telas.profile

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.User
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@Composable
fun OthersProfile(navController: NavHostController, shared:SharedModel) {
    val backgroundColor = Color(0xFF4059AD)
    val flagIcon = painterResource(R.drawable.ic_flag_brazil)
    val whatsappIcon = painterResource(R.drawable.ic_whatsapp)
    val instagramIcon = painterResource(R.drawable.instagram)
    val facebookIcon = painterResource(R.drawable.facebook)
    val containerColor = Color(0xFFF5F5F5)
    var user = shared.selectedOtherUsers
    Scaffold(
        topBar = {
            Row(modifier = Modifier.background(containerColor).padding(top=20.dp)) {


                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    modifier = Modifier.size(60.dp).padding(start = 20.dp, top= 15.dp).clickable {
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
                            contentDescription = "image description",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .width(75.dp)
                                .height(73.dp)
                        )
                    }
                }

            }
        },
        content =  { padding ->
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
                            .height(170.dp)
                            .background(backgroundColor,shape = RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            ))
                            .padding(15.dp),

                        ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            // Imagem de perfil
                            val imageRes = user?.imageRes ?: R.drawable.ico_profileblue
                            Image(
                                painter = painterResource(imageRes),
                                contentDescription = stringResource(R.string.imagem,"image description"),
                                contentScale = ContentScale.FillBounds,

                                modifier = Modifier
                                    .width(128.dp)
                                    .height(120.dp).clip(CircleShape)
                                    .border(
                                        width = 2.dp,
                                        color = MaterialTheme.colorScheme. onBackground,
                                        shape = RoundedCornerShape(size = 158.dp)
                                    )
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            // Informações do usuário
                            Column(modifier = Modifier.width(210.dp)) {
                                Row() {
                                    Text(
                                        text = stringResource(R.string.nome, user?.name ?: "UserInfo"),
                                        style = TextStyle(
                                            fontFamily = poppinsFontFamily,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Image(painterResource(R.drawable.walking_stick_white
                                    ), contentDescription = "walkingstick" ,modifier =Modifier.size(30.dp))
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(user?.flagCountry ?: R.drawable.ic_flag_brazil),
                                        contentDescription = stringResource(R.string.localização,"Localização"),
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = stringResource(R.string.localização,user?.country?:"Brasil"),
                                        style = TextStyle(fontFamily = poppinsFontFamily, fontSize = 14.sp, color =MaterialTheme.colorScheme.onSecondaryContainer)
                                    )
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Button(
                                    onClick = { /* Ação conectar */ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.onTertiary
                                    ),
                                    modifier = Modifier.padding(start = 20.dp)
                                ) {
                                    Text(text = stringResource(R.string.conexões,"Conexões"), color = MaterialTheme.colorScheme.onSecondaryContainer)
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            // Botão conectar

                        }
                    }
                }


                item {

                    Column(
                        modifier = Modifier
                            .width(411.dp)
                            .height(453.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainerHighest,
                                shape = RoundedCornerShape(size = 3.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Sobre mim:",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                        )
                        Spacer(modifier = Modifier.height(28.dp))
                        Text(
                            text = stringResource(R.string.apresentação,user?.AboutUser?: "Sobre mim"),
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
                                .height(351.dp)
                        )
                    }
                }

                // Ícones de contato
                item {

                    Box(modifier = Modifier.fillMaxSize().background(backgroundColor)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(

                                text = stringResource(R.string.mensagem,"Entre em contato"),
                                style = TextStyle(
                                    fontFamily = poppinsFontFamily,
                                    fontSize = 21.sp,
                                    lineHeight = 17.28.sp,
                                    fontWeight = FontWeight(700),
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    textAlign = TextAlign.Justify,
                                )
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 32.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                IconButton(onClick = { /* Ação WhatsApp */ }) {
                                    Icon(
                                        painter = whatsappIcon,
                                        contentDescription = stringResource(R.string.whatsApp,"WhatsApp"),
                                        modifier = Modifier.size(30.dp),
                                        tint = Color.Unspecified
                                    )
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                IconButton(onClick = { /* Ação Instagram */ }) {
                                    Icon(
                                        painter = instagramIcon,
                                        contentDescription =stringResource(R.string.instagram, "Instagram"),
                                        modifier = Modifier.size(55.dp),
                                        tint = Color.Unspecified
                                    )
                                }
                                Spacer(modifier = Modifier.width(16.dp))

                                IconButton(onClick = { /* Ação Facebook */ }) {
                                    Icon(
                                        painter = facebookIcon,
                                        contentDescription = stringResource(R.string.facebook,"Facebook"),
                                        modifier = Modifier.size(30.dp),
                                        tint = Color.Unspecified
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    )
}
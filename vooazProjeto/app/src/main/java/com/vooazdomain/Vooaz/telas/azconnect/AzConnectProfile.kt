package com.example.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@Composable
fun AzConnectProfileScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFF4B942) // Amarelo para o fundo do cabeçalho
    val profileImagePlaceholder =
        painterResource(R.drawable.ic_profile_placeholder) // Ícone substituível
    val flagIcon = painterResource(R.drawable.ic_flag_france) // Bandeira substituível
    val whatsappIcon = painterResource(R.drawable.ic_whatsapp) // Ícone WhatsApp substituível
    val instagramIcon = painterResource(R.drawable.instagram) // Ícone Instagram substituível
    val facebookIcon = painterResource(R.drawable.facebook) // Ícone Facebook substituível
    val containerColor = Color(0xFFF5F5F5) // Fundo da tela (cinza claro)
    Scaffold(
        topBar = {
            Row(modifier = Modifier.background(containerColor).padding(top=20.dp)) {


                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.voltar),
                    modifier = Modifier.size(60.dp).padding(start = 20.dp, top= 15.dp).clickable {
                        navController.popBackStack()
                    },
                    tint =MaterialTheme.colorScheme.onSecondaryContainer
                )


                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Box(modifier = Modifier.padding(end = 60.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.logoaz),
                            contentDescription = stringResource(R.string.LogoAz),
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
                            Image(
                                painter = profileImagePlaceholder,
                                contentDescription = stringResource(R.string.imagem_usuario),
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .width(128.dp)
                                    .height(120.dp)
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
                                        text = stringResource(R.string.nome,"Fabio Nascimento"),
                                        style = TextStyle(
                                            fontFamily =poppinsFontFamily,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold,
                                            color =MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Image(painterResource(R.drawable.hearingaidicon),
                                        contentDescription = stringResource(R.string.icone),
                                        modifier =Modifier.size(30.dp))
                                }
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = flagIcon,
                                        contentDescription = stringResource(R.string.local),
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = stringResource(R.string.paris,"Paris, França"),
                                        fontFamily =poppinsFontFamily,
                                        style = TextStyle(fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                    )
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Button(
                                    onClick = { /* Ação conectar */ },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(
                                            0xFF3366FF
                                        )
                                    ),
                                    modifier = Modifier.padding(start = 20.dp)
                                ) {
                                    Text(text = "Conectar",
                                        fontFamily = poppinsFontFamily,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer)
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            // Botão conectar

                        }
                    }
                }

                // Seção "Sobre Fabio"
                item {

                    Column(
                        modifier = Modifier
                            .width(411.dp)
                            .height(453.dp)
                            .background(
                                color = MaterialTheme.colorScheme.  tertiary,
                                shape = RoundedCornerShape(size = 3.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.sobre,"Sobre Fabio:"),
                            fontFamily = poppinsFontFamily,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color =MaterialTheme.colorScheme.onSecondary
                            )
                        )
                        Spacer(modifier = Modifier.height(28.dp))
                        Text(
                            text = stringResource(R.string.descrição,"Olá! Meu nome é Fábio Nascimento, sou um apaixonado por arte e cultura, vivendo atualmente em Paris, França. Natural do Brasil, encontrei na Cidade Luz um lar inspirador, onde exploro constantemente museus, cafés e a rica história que permeia cada esquina. Sou designer gráfico e adoro combinar minha paixão pela criatividade com a beleza urbana de Paris. Nos meus tempos livres, gosto de escrever sobre minhas experiências e compartilhar dicas sobre a cidade. Estou animado para conectar e trocar ideias com todos vocês!"),
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

                                text = stringResource(R.string.contato,"Entre em contato"),
                                fontFamily = poppinsFontFamily,
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    lineHeight = 17.28.sp,
                                    fontWeight = FontWeight(700),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
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
                                        contentDescription = stringResource(R.string.instagram,"Instagram"),
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

@Composable
@Preview
fun AzConnectProfileScreenPreview() {
    AzConnectProfileScreen(rememberNavController())
}
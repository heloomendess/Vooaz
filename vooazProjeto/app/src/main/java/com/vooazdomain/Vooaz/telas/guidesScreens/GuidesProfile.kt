package com.vooazdomain.Vooaz.telas.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.TourismGuide

import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@Composable
fun GuidesProfile(navController: NavController,sharedModel: SharedModel) {
    var guides = sharedModel.selectedGuides
    Scaffold(
        containerColor = MaterialTheme.colorScheme.onTertiary
    ) { innerPadding ->
        var somepadding = innerPadding
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            //
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
                    .verticalScroll(rememberScrollState())
                    .background(Color.White, shape = RoundedCornerShape(13.dp))
            ) {
                Column(modifier = Modifier.padding(10.dp).heightIn(400.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth().background(Color.White),
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Image(
                            painter = painterResource(
                                id = guides?.imageRes ?: R.drawable.personicon
                            ),
                            contentDescription = "Foto de perfil de ${guides?.name}",
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = guides?.name ?: "Default",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(
                                        id = guides?.flagCountry ?: R.drawable.ico_flag_brasil
                                    ),
                                    contentDescription = "Bandeira do ${guides?.country}",
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "${guides?.city}, ${guides?.state}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Informações adicionais
                    Text(
                        text = "Sobre Mim",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = guides?.AboutGuide ?: "About Default",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                Divider()

                // Dados pessoais

                PersonalGuideInfoSection(guide = guides)

                Divider()
            Spacer(modifier = Modifier.height(50.dp))
            }

        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 23.dp), // Ajuste o espaçamento inferior se necessário
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = "Voltar",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@Composable
fun PersonalGuideInfoSection(guide: TourismGuide?) {
    Column(modifier = Modifier.padding(vertical = 16.dp).padding(10.dp).heightIn(300.dp)) {
        InfoRowGuides(label = "Idade", value = "${guide?.age} anos")
        InfoRowGuides(label = "Gênero", value = guide?.gender ?: "Não informado")
        InfoRowGuides(label = "E-mail", value = guide?.email ?: "Não informado")
        InfoRowGuides(label = "Bairro", value = guide?.neighborhood ?: "Não informado")
        InfoRowGuides(label = "Idiomas", value = guide?.languages?.joinToString(", ") ?: "Não informado")
        InfoRowGuides(label = "Tipo de Deficiência", value = guide?.disabilitySpecialty ?: "Nenhuma")
        InfoRowGuides(label = "Tipo de Especialidade", value = guide?.specialty ?: "Não informado")
        InfoRowGuides(label = "País", value = guide?.country ?: "Não informado")
        InfoRowGuides(label = "Estado", value = guide?.state ?: "Não informado")
        InfoRowGuides(label = "Cidade", value = guide?.city ?: "Não informado")
        InfoRowGuides(label = "Avaliação", value = guide?.rating?.toString() ?: "Não avaliado")
        InfoRowGuides(label = "Número de Contato", value = guide?.contact ?: "Não informado")
        InfoRowGuides(label = "Tipo de Guia", value = guide?.type ?: "Não informado")
    }
    }


@Composable
fun InfoRowGuides(label: String, value: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold
        )
        Text(text = value?:"Default", style = MaterialTheme.typography.bodySmall)
    }
}

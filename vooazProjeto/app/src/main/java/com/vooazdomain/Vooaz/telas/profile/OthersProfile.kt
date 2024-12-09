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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.User
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun OthersProfile(navController: NavController, sharedModel: SharedModel) {
    val user = sharedModel.selectedOtherUsers

    Box(
        modifier = Modifier
            .fillMaxSize() // Faz com que o Box ocupe toda a tela
            .padding(10.dp)
    ) {
        // Conteúdo principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
                .verticalScroll(rememberScrollState())
                .background(Color.White, shape = RoundedCornerShape(13.dp))
        ) {
            Column(modifier = Modifier.heightIn(150.dp).padding(10.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth().background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = user?.imageRes ?: R.drawable.personicon),
                        contentDescription = "Foto de perfil de ${user?.name}",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = user?.name ?: "Default",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = user?.flagCountry ?: R.drawable.ico_flag_brasil),
                                contentDescription = "Bandeira do ${user?.country}",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${user?.city}, ${user?.state}",
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
                    text = user?.AboutUser ?: "About Default",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Divider()

            // Dados pessoais
            PersonalInfoOtherUserSection(user = user)

            Divider()

            // Histórico de viagens
            Text(
                text = "Histórico de Viagens",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, start = 5.dp)
            )

            user?.historicTravels?.forEach { destination ->
                Text(
                    text = destination?.name ?: "Default",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 7.dp, top = 5.dp)
                )
            }

        }

        // Botão fixo na parte inferior
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp), // Ajuste o espaçamento inferior se necessário
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
}
@Composable
fun PersonalInfoOtherUserSection(user: User?) {
    Column(modifier = Modifier.padding(vertical = 16.dp).padding(10.dp)) {
        InfoRowOtherUser(label = "Idade", value = "${user?.age} anos")
        InfoRowOtherUser(label = "Gênero", value = user?.gender)
        InfoRowOtherUser(label = "Data de Nascimento", value = user?.birthDate?.toFormattedStringOtherUser())
        InfoRowOtherUser(label = "E-mail", value = user?.email)
        InfoRowOtherUser(label = "Bairro", value = user?.neighborhood)
        InfoRowOtherUser(label = "Idiomas", value = user?.languages?.joinToString(", "))
        InfoRowOtherUser(label = "Tipo de Deficiência", value = user?.disabilityType ?: "Nenhuma")
        InfoRowOtherUser(label = "Quantidade de Conexões", value = user?.conected_users?.size.toString() ?: "Nenhuma")
    }
}

@Composable
fun InfoRowOtherUser(label: String, value: String?) {
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


fun Date.toFormattedStringOtherUser(): String {
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return format.format(this)
}

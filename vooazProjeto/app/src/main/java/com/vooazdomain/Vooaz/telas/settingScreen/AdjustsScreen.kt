package com.vooazdomain.Vooaz.telas.settingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R


@Composable
fun AdjustsScreen(navController: NavController){
    // Background color for the entire screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)) // Light gray background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Row {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = stringResource(id = R.string.voltar),
                    modifier = Modifier
                        .size(25.dp)
                        .padding(top = 2.dp)
                        .clickable { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Configurações",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            // Category: General
            Text(
                text = "Geral",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SettingItemSwitch(
                title = "Notificações",
                description = "Ativar ou desativar notificações"
            )
            SettingItemSwitch(
                title = "Modo escuro",
                description = "Ativar modo escuro no aplicativo"
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Category: Account
            Text(
                text = "Conta",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SettingItemNavigation(
                title = "Alterar senha",
                description = "Atualize sua senha"
            )
            SettingItemNavigation(
                title = "Gerenciar dispositivos",
                description = "Veja dispositivos conectados"
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Category: About
            Text(
                text = "Sobre",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            SettingItemNavigation(
                title = "Termos de serviço",
                description = "Leia nossos termos"
            )
            SettingItemNavigation(
                title = "Política de privacidade",
                description = "Saiba mais sobre privacidade"
            )
        }
    }
}

@Composable
fun SettingItemSwitch(title: String, description: String) {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Composable
fun SettingItemNavigation(title: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        ClickableText(
            text = AnnotatedString(title),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            ),
            onClick = { /* Navigate to a different screen */ }
        )
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

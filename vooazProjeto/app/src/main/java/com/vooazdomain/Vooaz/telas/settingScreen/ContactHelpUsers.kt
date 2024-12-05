package com.vooazdomain.Vooaz.telas.settingScreen

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R

class HelpCenterActivity : ComponentActivity() {

// depois jogar no backend
     fun openEmail() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:support@yourapp.com")
            putExtra(Intent.EXTRA_SUBJECT, "Ajuda com o aplicativo")
        }
        startActivity(intent)
    }

     fun openChat() {
        // Exemplo: abrir URL ou implementar lógica do chat
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yourapp.com/chat"))
        startActivity(intent)
    }

     fun openFAQ() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yourapp.com/faq"))
        startActivity(intent)
    }
}

@Composable
fun HelpCenterScreen(
    navController: NavController,
    onEmailClick: () -> Unit,
    onChatClick: () -> Unit,
    onFAQClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light gray background
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(enabled = true, state = rememberScrollState())
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
                    text = "Central de Ajuda",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            // Section: Common Help Topics
            Text(
                text = "Tópicos Comuns",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            HelpTopicItem("Como redefinir minha senha?")
            HelpTopicItem("Como alterar minhas informações pessoais?")
            HelpTopicItem("Erro ao realizar pagamento")
            HelpTopicItem("Problemas com o login")

            Divider(modifier = Modifier.padding(vertical = 16.dp))

            // Section: Actions
            Text(
                text = "Precisa de mais ajuda?",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Button(
                onClick = onEmailClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Enviar E-mail para o Suporte")
            }

            Button(
                onClick = onChatClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Abrir Chat com Suporte")
            }

            ClickableText(
                text = AnnotatedString("Acessar FAQ"),
                onClick = { onFAQClick() },
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun HelpTopicItem(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

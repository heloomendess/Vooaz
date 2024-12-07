package com.vooazdomain.Vooaz.telas.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@Composable
fun PrivateChatScreen(navController: NavController, shared:SharedModel) {
    var message by remember { mutableStateOf(TextFieldValue("")) }
    val messages = remember { mutableStateListOf<Pair<String, Boolean>>() } // Lista de mensagens
    Scaffold(
        topBar = {

            TopBar(navController, shared)
        },
        bottomBar = {
            InputBar(
                message = message,
                onMessageChange = { message = it },
                onSendClick = {
                    if (message.text.isNotBlank()) {
                        messages.add(Pair(message.text, true)) // Adiciona a mensagem do usuário
                        message = TextFieldValue("") // Limpa o campo
                    }
                }
            )
        }

    ) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(innerpadding)

                .background(MaterialTheme.colorScheme.tertiary) // Cor do fundo principal
        ) {


            // Lista de mensagens
            MessagesSection(messages)

            // Barra de entrada de mensagem

        }
    }
}
@Composable
fun TopBar(navController: NavController,shared: SharedModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onTertiary) // Cor da barra superior
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack, // Ícone de volta
            contentDescription = stringResource(R.string.voltar),
            modifier = Modifier.size(24.dp).clickable { navController.popBackStack() }
        )
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = painterResource(id = shared.selectedOtherUsers?.imageRes ?: R.drawable.personicon), // Avatar do usuário
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape).clickable {
                    navController.navigate("OthersProfile")
                }
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = shared.selectedOtherUsers?.name ?: "Default User" ,
            fontFamily = poppinsFontFamily,
            style = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onSecondaryContainer)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Image(painterResource(R.drawable.hearingaidicon), contentDescription = "Aparelho auditivo", modifier =Modifier.size(25.dp))
        Spacer(modifier = Modifier.width(42.dp))

        Image(
            painter = painterResource(id = R.drawable.logoaz),
            contentDescription = "Logo",
            modifier = Modifier.size(40.dp)
        )

    }
}

@Composable
fun MessagesSection(messages: List<Pair<String, Boolean>>) {
    Column(
        modifier = Modifier

            .fillMaxWidth().fillMaxHeight()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.Bottom

    ) {
        messages.forEach { (text, isUser) ->
            if (isUser) {
                UserMessage(text)
            } else {
                OtherUserMessage(text)
            }
        }
    }
}

@Composable
fun InputBar(
    message: TextFieldValue,
    onMessageChange: (TextFieldValue) -> Unit,
    onSendClick: () -> Unit
) {

    Row(
        modifier = Modifier

            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondaryContainer)
            .padding(8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ico_gallery),
            contentDescription = "galeria",
            modifier = Modifier.size(34.dp).padding(bottom = 11.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(R.drawable.ico_emoji),
            contentDescription = "emoji",
            modifier = Modifier.size(34.dp).padding(bottom =11.dp)
        )
        BasicTextField(
            value = message,
            onValueChange = onMessageChange,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(size = 19.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp),
            textStyle = TextStyle(fontSize = 16.sp, color =MaterialTheme.colorScheme.onSecondary)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = onSendClick,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground)
        ) {
            Text("Enviar", color = MaterialTheme.colorScheme.onSecondaryContainer)
        }
    }
}

@Composable
fun UserMessage(message: String) {
    Row(
        modifier = Modifier

            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onBackground, shape = CircleShape)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(text = message, color =MaterialTheme.colorScheme.onSecondaryContainer, fontFamily = poppinsFontFamily,fontSize = 14.sp)
        }
    }
}

@Composable
fun OtherUserMessage(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFE0E0E0), shape = CircleShape)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(text = message, color = Color.Black, fontSize = 14.sp)
        }
    }
}


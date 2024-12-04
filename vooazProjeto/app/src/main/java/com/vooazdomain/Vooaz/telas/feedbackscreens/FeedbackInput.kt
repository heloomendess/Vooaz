package com.example.feedbackscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(navController: NavController) {
    val topBarColor = Color(0xFF4059AD)
    val buttonColor = Color(0xFF4059AD)
    val bodyBackgroundColor = Color(0xFFD9D9D9)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.titulo,"Feedback"),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, fontFamily = poppinsFontFamily)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.voltar, "Voltar"),
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = topBarColor)
            )
        },
        containerColor = bodyBackgroundColor
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painterResource(R.drawable.logoaz),
                    contentDescription = stringResource(id = R.string.logo_description),
                    modifier = Modifier.size(250.dp),
                )
            }
            Spacer(modifier = Modifier.height(32.dp))

            // Texto de instrução
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 4.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.pergunta, "Nos conta, como podemos melhorar?"),
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color =MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Caixa de texto para feedback
            var feedbackText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = feedbackText,
                onValueChange = { feedbackText = it },
                placeholder = { Text("Feedback...") },
                modifier = Modifier
                    .border(width = 2.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 19.dp))
                .width(370.dp)
                .height(243.dp)
                .background(color =MaterialTheme.colorScheme.surfaceContainerHigh, shape = RoundedCornerShape(size = 19.dp)),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor= MaterialTheme.colorScheme.onSecondaryContainer,
                    focusedBorderColor = MaterialTheme.colorScheme.onSecondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSecondary
                ),

            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão "Enviar"
            Button(
                onClick = { navController.navigate("FeedbackConfirmScreen")},
                modifier =Modifier
                    .shadow(elevation = 4.dp, spotColor = MaterialTheme.colorScheme.surfaceContainer, ambientColor = MaterialTheme.colorScheme.surfaceContainer)
                    .width(223.dp)
                    .height(39.dp)
                    .background(color =MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(size = 28.dp))
            ) {
                Text(
                    text = stringResource(R.string.enviar,"Enviar"),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = TextStyle(fontFamily = poppinsFontFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão "Voltar"
            Button(
                onClick = { navController.popBackStack()},
                modifier = Modifier
                    .shadow(elevation = 4.dp, spotColor = MaterialTheme.colorScheme.surfaceContainer, ambientColor = MaterialTheme.colorScheme.surfaceContainer)
                    .width(143.dp)
                    .height(39.dp)
                    .background(color = MaterialTheme.colorScheme.onBackground, shape = RoundedCornerShape(size = 28.dp))
            ) {
                Text(
                    text = stringResource(R.string.voltar,"Voltar"),
                    color =MaterialTheme.colorScheme.onSecondaryContainer,
                    style = TextStyle(fontFamily = poppinsFontFamily, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedbackScreenPreview() {
    FeedbackScreen(rememberNavController())
}

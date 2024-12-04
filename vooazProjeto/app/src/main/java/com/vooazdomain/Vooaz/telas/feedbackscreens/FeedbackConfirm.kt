package com.vooazdomain.Vooaz.telas.feedbackscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.feedbackscreen.FeedbackScreen
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackConfirmScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text( stringResource(R.string.feedback,"Feedback"), color = MaterialTheme.colorScheme.onSecondaryContainer, fontWeight = FontWeight.Bold, fontFamily = poppinsFontFamily) },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Voltar",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Fechar ação */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.close), // Substitua pelo seu ícone de fechar
                            contentDescription = stringResource(R.string.fechar,"Fechar"),
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =MaterialTheme.colorScheme.onBackground )
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.surfaceContainerLow) // Cor do fundo
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Caixa de texto
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.  onSecondaryContainer, shape = RoundedCornerShape(12.dp))
                            .padding(16.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.mensagem,"Agradecemos sinceramente pelo seu feedback! Sua opinião é muito importante para nós e nos ajuda a melhorar continuamente nossos serviços. Estamos sempre em busca de maneiras de oferecer a melhor experiência possível.\n\nSe tiver mais sugestões ou comentários, não hesite em entrar em contato!\n\nObrigado mais uma vez!"),
                            style = TextStyle(
                                fontFamily = poppinsFontFamily,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme. onSecondary,
                                lineHeight = 22.sp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Emoji
                    Text(
                        text = stringResource(R.string.emoji,"😊"),
                        style = TextStyle(fontSize = 32.sp),
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Botão Voltar
                    Button(
                        onClick = { navController.navigate("SettingsScreen") },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(0.5f) // Botão ocupa metade da largura
                    ) {
                        Text(
                            text = "Finalizar",
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontSize = 16.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold

                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun FeedbackConfirmPreview() {
    FeedbackScreen(rememberNavController())
}

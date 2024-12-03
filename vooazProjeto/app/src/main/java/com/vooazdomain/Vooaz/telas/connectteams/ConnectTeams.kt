package com.vooazdomain.Vooaz.telas.connectteams

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@Composable
fun ConfirmationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize().background(MaterialTheme.colorScheme.surfaceBright) // Fundo cinza claro (ajustado para mais fidelidade)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Substituindo o Card por um Box
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f) // Largura ajustada
                    .height(400.dp) // Altura ajustada
                    .border(
                        width = 2.dp, // Espessura da borda
                        color = Color.Black, // Cor da borda
                        shape = RoundedCornerShape(16.dp) // Bordas arredondadas
                    )
                    .padding(1.dp) // Espaçamento interno
                    .background ((MaterialTheme.colorScheme. surfaceTint), shape = RoundedCornerShape(16.dp)) // Fundo branco suave com bordas arredondadas
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 15.dp, horizontal = 7.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Logo
                    Image(
                        painter = painterResource(id = R.drawable.logoaz),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(180.dp),
                        contentScale = ContentScale.Fit
                    )

                    Text(
                        text = stringResource(R.string.confirmação,"Tudo Certo!!"),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stringResource(R.string.mensagem,"Nossa equipe entrara em contato em breve para confirmar seus dados fique atento ao seu email."),
                        style = TextStyle(
                            fontFamily = poppinsFontFamily,
                            fontSize = 20.sp,
                            lineHeight = 19.sp,
                            fontWeight = FontWeight(400),
                            color =MaterialTheme.colorScheme.onSecondary ,
                            textAlign = TextAlign.Center,

                        ),
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ConfirmationScreenPreview() {
    ConfirmationScreen()
}

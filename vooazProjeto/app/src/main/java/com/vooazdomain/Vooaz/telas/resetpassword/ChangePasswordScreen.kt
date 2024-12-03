package com.vooazdomain.Vooaz.telas.resetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.VooazTheme
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@Composable
fun BackgroundColorChangePassword(someThemes: ColorScheme)

{
    Box(
        modifier = Modifier
            .background(
                color = someThemes.onBackground
            )
            .fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painterResource(R.drawable.logoaz),
            contentDescription = stringResource(R.string.logo),
            modifier = Modifier.size(350.dp),
        )
    }

}

@Composable
fun ChangePasswordScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var equalsPassword = false
    val context = LocalContext.current
    var someThemes = MaterialTheme.colorScheme

    BackgroundColorChangePassword(someThemes)

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Icon(
            Icons.Filled.Close,
            contentDescription = stringResource(R.string.voltar),
            modifier = Modifier
                .size(50.dp)
                .padding(top = 20.dp)
                .clickable { navController.popBackStack() })
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            stringResource(R.string.crie_uma_nova_senha),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = someThemes.onTertiary,
            modifier = Modifier.padding(bottom = 10.dp),
            fontFamily = poppinsFontFamily // Adicionando a fonte Poppins
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .width(310.dp)
                .height(110.dp)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    "",
                    tint = someThemes.onTertiary,
                    modifier = Modifier.size(30.dp)
                )
            },
            label = {
                Text(
                    stringResource(R.string.nova_senha),
                    fontFamily = poppinsFontFamily // Adicionando a fonte Poppins
                )
            }
        )

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier
                .width(310.dp)
                .height(110.dp)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {
                Icon(
                    Icons.Filled.Lock,
                    "",
                    tint = someThemes.onTertiary,
                    modifier = Modifier.size(30.dp)
                )
            },
            label = {
                Text(
                    stringResource(R.string.confirmar_senha),
                    fontFamily = poppinsFontFamily // Adicionando a fonte Poppins
                )
            }
        )

        Button(
            onClick = {
                navController.navigate("InputScreen")
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(top = 30.dp)
                .width(200.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = someThemes.onTertiary),
        ) {
            Text(
                stringResource(R.string.resetar_senha),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = poppinsFontFamily // Adicionando a fonte Poppins
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun ChangePasswordScreenPreview() {
    VooazTheme {
        ChangePasswordScreen(rememberNavController())
    }
}

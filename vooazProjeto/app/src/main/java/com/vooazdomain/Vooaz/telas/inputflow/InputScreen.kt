package com.vooazdomain.Vooaz.telas.inputflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.VooazTheme
import androidx.compose.ui.res.stringResource
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@Composable
fun BackgroundInputScreen(someTheme: ColorScheme) {

    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.onBackground
            )
            .fillMaxWidth()
            .fillMaxHeight()
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painterResource(R.drawable.logoaz),
            contentDescription = stringResource(id = R.string.logo_description),
            modifier = Modifier.size(350.dp),
        )
    }
}

@Composable
fun InputScreen(navController: NavController) {
    var someTheme = MaterialTheme.colorScheme
    BackgroundInputScreen(someTheme)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate(route = "RegisterAccountScreen") },
            modifier = Modifier
                .width(300.dp)
                .height(90.dp)
                .padding(bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(id = R.string.register),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily
            )
        }
        Button(
            onClick = { navController.navigate(route = "LoginScreen") },
            modifier = Modifier
                .width(300.dp)
                .height(90.dp)
                .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 20.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 40.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
        ) {
            Text(
                text = stringResource(id = R.string.know_more),
                fontWeight = FontWeight.Bold,
                color = someTheme.onSecondary,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(end = 5.dp)
            )

            Text(
                text = stringResource(id = R.string.about_us),
                color = MaterialTheme.colorScheme.onTertiary,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.clickable {
                    navController.navigate("AboutUsScreen")
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun InputScreenPreview() {
    VooazTheme {
        InputScreen(navController = rememberNavController())
    }
}

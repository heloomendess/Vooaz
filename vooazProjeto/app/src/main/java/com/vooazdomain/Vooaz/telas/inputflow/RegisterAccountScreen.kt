package com.vooazdomain.Vooaz.telas.inputflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.material3.MaterialTheme
import com.vooazdomain.Vooaz.ui.theme.*  // Importando as cores do tema

@Composable
fun BackgroundColorRegisterAccountScreen(someThemes: ColorScheme) {
    Box(
        modifier = Modifier
            .background(color = someThemes.onBackground)  // Usando a cor do tema
            .fillMaxWidth()
            .fillMaxHeight()
    )
}

@Composable
fun RegisterAccountContent(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var someThemes = MaterialTheme.colorScheme
    BackgroundColorRegisterAccountScreen(someThemes)

    Box() {
        Icon(
            Icons.Filled.Close,
            contentDescription = stringResource(id = R.string.close_button),
            modifier = Modifier.size(70.dp).padding(top = 25.dp).clickable { navController.popBackStack() }
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.create_account_with),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 15.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(R.drawable.google),
                contentDescription = stringResource(id = R.string.google_logo),
                modifier = Modifier.size(60.dp).padding(end = 20.dp, bottom = 20.dp)
            )
            Image(
                painterResource(R.drawable.instagram),
                contentDescription = stringResource(id = R.string.instagram_logo),
                modifier = Modifier.size(40.dp)
            )
            Image(
                painterResource(R.drawable.facebook),
                contentDescription = stringResource(id = R.string.facebook_logo),
                modifier = Modifier.size(60.dp).padding(start = 30.dp, bottom = 20.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.or_else),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
            )
        }

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.name),
                color = MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                modifier = Modifier.align(Alignment.Start).padding(start = 40.dp, top = 20.dp, bottom = 2.dp),
                fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
            )

            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.width(310.dp).height(50.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        "",
                        tint = MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                        modifier = Modifier.size(30.dp)
                    )
                }
            )

            Text(
                text = stringResource(id = R.string.email),
                color = MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                modifier = Modifier.align(Alignment.Start).padding(start = 40.dp, top = 20.dp, bottom = 2.dp),
                fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.width(310.dp).height(50.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        "",
                        tint =MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                        modifier = Modifier.size(30.dp)
                    )
                }
            )

            Text(
                text = stringResource(id = R.string.password),
                color =MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                modifier = Modifier.align(Alignment.Start).padding(start = 40.dp, top = 20.dp, bottom = 2.dp),
                fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.width(310.dp).height(50.dp),
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = {
                    Icon(
                        Icons.Filled.Lock,
                        "",
                        tint =MaterialTheme.colorScheme.onTertiary,  // Usando a cor amarela do tema
                        modifier = Modifier.size(30.dp)
                    )
                }
            )

            Column(
                modifier = Modifier.padding(top = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 20.dp, start = 5.dp)
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.onTertiary  // Usando a cor amarela do tema
                                )
                            ) {
                                append(stringResource(id = R.string.agree_terms))
                            }
                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)) {
                                append(stringResource(id = R.string.terms_of_use))
                            }
                            withStyle(
                                SpanStyle(
                                    color = MaterialTheme.colorScheme.onTertiary  // Usando a cor amarela do tema
                                )
                            ) {
                                append(stringResource(id = R.string.terms_of_use_e_nosso))
                            }

                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)) {
                                append(stringResource(id = R.string.and_privacy_policy))
                            }
                        },
                        fontFamily = poppinsFontFamily  // Aplicando a fonte Poppins
                    )
                }

                Button(
                    onClick = {  navController.navigate(route = "InputFullRegisterScreen")},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(top = 10.dp).width(310.dp).height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor =MaterialTheme.colorScheme.onTertiary),  // Usando a cor amarela do tema
                ) {
                    Text(
                        text = stringResource(id = R.string.enter),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun RegisterAccountPreview() {
    RegisterAccountContent(navController = rememberNavController())
}

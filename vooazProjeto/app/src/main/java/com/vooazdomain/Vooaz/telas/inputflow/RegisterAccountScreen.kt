package com.vooazdomain.Vooaz.telas.inputflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.withStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.constantsData.UsersConts
import com.vooazdomain.Vooaz.modelsData.datas.User
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
fun RegisterAccountContent(navController: NavController, sharedModel: SharedModel) {
    var name = remember { mutableStateOf("") }
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var desability = remember { mutableStateOf("Selecione seu debilidade") }
    var city = remember { mutableStateOf("") }
    var checked = remember { mutableStateOf(false) }
    var data = remember { mutableStateOf("") }
    var selectedGender = remember { mutableStateOf("Selecione seu gênero") }
    var someThemes = MaterialTheme.colorScheme
    BackgroundColorRegisterAccountScreen(someThemes)

    Column (modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
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

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextFieldWithLabel(
                    label = stringResource(id = R.string.name),
                    placeholder = "Nome...",
                    leadingIcon = Icons.Filled.Person,
                    atribute = name
                )
                TextFieldWithLabel(
                    label = stringResource(id = R.string.email),
                    placeholder = "Email...",
                    leadingIcon = Icons.Filled.Email,
                    atribute = email
                )
                TextFieldWithLabel(
                    label = stringResource(id = R.string.password),
                    placeholder = "Senha...",
                    leadingIcon = Icons.Filled.Lock,
                    atribute = password
                )
                TextFieldWithLabel(
                    label = "Data de nascimento",
                    placeholder = "DD/MM/AAAA",
                    leadingIcon = Icons.Filled.DateRange,
                    atribute = data
                )
                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Genero",
                        style = TextStyle(
                            fontFamily = poppinsFontFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Start,
                        ),
                        modifier = Modifier
                            .width(170.dp)
                            .height(24.dp).padding(start = 10.dp)

                    )
                }
                DropdownField(
                    options = listOf("Masculino", "Feminino", "Outro"),
                    selectedOption = selectedGender.value,
                    onOptionSelected = { selectedGender.value = it },

                    )

                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Deficiencia",
                        style = TextStyle(
                            fontFamily = poppinsFontFamily,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Start,
                        ),
                        modifier = Modifier
                            .width(170.dp)
                            .height(24.dp).padding(start = 10.dp)

                    )
                }
                DropdownField(
                    options = listOf("Visual", "Auditiva", "Motora", "Outra"),
                    selectedOption = desability.value,
                    onOptionSelected = { desability.value = it },
                )
            }

            Column(
                modifier = Modifier.padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 20.dp, start = 5.dp)
                ) {
                    Checkbox(
                        checked = checked.value,
                        onCheckedChange = { checked.value = it }
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
                    onClick = {

                        if (checked.value  && (name.value.length > 5) && (email.value.length > 5) && (password.value.length > 5)) {

                            sharedModel.setSelectedRegisterUser(User(
                                userId = 20,
                                name = name.value,
                                email = email.value,
                                password = password.value,
                                birthDate = null,
                                gender = selectedGender.value,
                                disabilityType = desability.value,
                                country = null,
                                flagCountry = null,
                                state = null,
                                city = null,
                                age = null,
                                imageRes = null,
                                AboutUser = null,
                                neighborhood = null,
                                languages = mutableListOf("Português"),
                                historicTravels = null,
                                userPlans = null,
                                conected_users = null,
                            ))
                            navController.popBackStack()
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(top = 10.dp).width(310.dp).height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary),  // Usando a cor amarela do tema
                ) {
                    Text(
                        text = stringResource(id = R.string.enter),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontFamily = poppinsFontFamily
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithLabel(
    label: String,
    placeholder: String,
    leadingIcon: ImageVector,
    atribute: MutableState<String>
) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = label,
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = MaterialTheme.colorScheme.onTertiary,
                    textAlign = TextAlign.Start,
                ),
                modifier = Modifier
                    .width(170.dp)
                    .height(24.dp).padding(start = 10.dp)

            )
        }
        OutlinedTextField(
            value = atribute.value,
            onValueChange = { atribute.value = it },
            placeholder = { Text(text = placeholder) },
            leadingIcon = {
                Icon(imageVector = leadingIcon, contentDescription = label, tint =MaterialTheme.colorScheme.onTertiary )
            },

            singleLine = true,
            modifier =Modifier
                .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 5.dp)).width(330.dp)
                .height(60.dp)
                .background(color =MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(size = 5.dp)))
        Spacer(modifier = Modifier.height(10.dp))
    }
}
@Composable
fun DropdownField(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    var expanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { expanded.value = true } // Abre o menu ao clicar
            .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = selectedOption.ifEmpty { "Selecione" },
            color = if (selectedOption.isEmpty()) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.onTertiary
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded.value = false
                    }
                )
            }
        }
    }
}

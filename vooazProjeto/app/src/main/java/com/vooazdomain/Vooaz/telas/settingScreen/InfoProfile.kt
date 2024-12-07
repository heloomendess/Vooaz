package com.vooazdomain.Vooaz.telas.settingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.constantsData.UsersConts
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfoScreen(navController: NavController, sharedModel: SharedModel) {
    var enableEdit by remember { mutableStateOf(false) }
    var showDialog = remember { mutableStateOf(false) }
    var verifyPopup = remember {  mutableStateOf(false) }

var user = remember { sharedModel.selectedUser }
    val name = remember { mutableStateOf(user?.name) }
    val country = remember { mutableStateOf(user?.country) }

    val state = remember { mutableStateOf(user?.state) }
    val city = remember { mutableStateOf(user?.city) }
    val aboutUser = remember { mutableStateOf(user?.AboutUser) }
    val neighborhood = remember { mutableStateOf(user?.neighborhood) }
    val email = remember { mutableStateOf(user?.email) }
    val disabilityType = remember { mutableStateOf(user?.disabilityType) }
    val birthDate = remember { mutableStateOf(user?.birthDate) }
    val gender = remember { mutableStateOf(user?.gender) }


    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.onBackground),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        text = "Informações pessoais",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 31.32.sp,
                            fontWeight = FontWeight(900),
                            color = MaterialTheme.colorScheme.surfaceContainerHighest,
                        ),
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = if (enableEdit){ "Salvar"}else{stringResource(R.string.editar)},
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clickable {
                                if (enableEdit) {
                                    enableEdit = !enableEdit
                                    UsersConts().setUserInformations(name.value, country.value, state.value,city.value,aboutUser.value,neighborhood.value,email.value,  disabilityType.value ,gender = gender.value, sharedModel = sharedModel,

                                    )
                                } else {
                                    if (!verifyPopup.value) {
                                        showDialog.value = true
                                    }else {
                                        enableEdit = !enableEdit
                                    }
                                }
                            },
                        color = if (enableEdit) Color.Blue else Color.Gray,
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily
                    )
                }
            }
        }
    ) { paddingValues ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.outlineVariant)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                PopUpVerify(showDialog, sharedModel, onVerificationResult ={ isVerify -> verifyPopup.value = isVerify} )

                Spacer(modifier = Modifier.height(16.dp))
                SectionTitleProfileInfo("Nome completo")
                InputField(name.value, enableEdit) { name.value = it }

                SectionTitleProfileInfo("País")
                InputField(country.value, enableEdit) { country.value = it }

                SectionTitleProfileInfo("Estado")
                InputField(state.value, enableEdit) { state.value = it }

                SectionTitleProfileInfo("Cidade")
                InputField(city.value, enableEdit) { city.value = it }

                SectionTitleProfileInfo("Bairro")
                InputField(neighborhood.value, enableEdit) { neighborhood.value = it }

                SectionTitleProfileInfo("Email")
                InputField(email.value, enableEdit) { email.value = it }

                SectionTitleProfileInfo("Data de Nascimento")
                InputField(birthDate.value.toString(), enableEdit) {
                }
                SectionTitleProfileInfo("Sobre Usuario")
                InputField(aboutUser.value, enableEdit) {
                }

                SectionTitleProfileInfo("Gênero")
                DropdownField(
                    options = listOf("Masculino", "Feminino", "Outro"),
                    selectedOption = gender?.value?:"Default",
                    onOptionSelected = { gender.value = it },
                    enableEdit
                )

                SectionTitleProfileInfo("Sobre a Deficiência")
                DropdownField(
                    options = listOf("Visual", "Auditiva", "Motora", "Outra"),
                    selectedOption = disabilityType?.value ?: "Default",
                    onOptionSelected = { disabilityType.value = it },
                    enableEdit
                )
            }

            item {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = MaterialTheme.colorScheme.surfaceContainer,
                            ambientColor = MaterialTheme.colorScheme.surfaceContainer
                        )
                        .width(143.dp)
                        .height(49.dp)
                        .padding(top = 15.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
                ) {
                    Text(stringResource(R.string.voltar), color = Color.White)
                }
            }
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun SectionTitleProfileInfo(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme. onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 3.dp)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(value: String?, enabled: Boolean, onValueChange: (String) -> Unit) {
    TextField(
        value = value?:"default",
        onValueChange = onValueChange,
        enabled = enabled,
        placeholder = { Text("Digite aqui", color = MaterialTheme.colorScheme.tertiary) },
        modifier = Modifier
            .width(350.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
    )
}

@Composable
fun DropdownField(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    enabled: Boolean // Parâmetro para habilitar/desabilitar o campo
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(350.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .border(
                1.dp,
                if (enabled) MaterialTheme.colorScheme.tertiary else Color.Gray, // Cor da borda ajustada
                RoundedCornerShape(8.dp)
            )
            .background(
                if (enabled) Color.White else Color.LightGray, // Fundo alterado se desabilitado
                RoundedCornerShape(8.dp)
            )
            .clickable(enabled) { expanded = true } // Clique habilitado apenas se `enabled` for true
    ) {
        Text(
            text = if (selectedOption.isEmpty()) "Selecione" else selectedOption,
            modifier = Modifier.padding(16.dp),
            color = if (enabled) {
                if (selectedOption.isEmpty()) Color.Gray else Color.Black
            } else {
                Color.DarkGray
            }
        )
        if (enabled) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onOptionSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopUpVerify(
    showDialog: MutableState<Boolean>,
    sharedModel: SharedModel,
    onVerificationResult: (Boolean) -> Unit
) {
    var senha = remember { mutableStateOf("") }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = { Text("Verificação") },
            text = {
                Column {
                    Text("Digite sua senha: ")

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = senha.value,
                        onValueChange = { senha.value = it },
                        placeholder = { Text("...") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    val isVerified = senha.value == sharedModel.selectedUser?.password
                    onVerificationResult(isVerified)
                    showDialog.value = false // Fecha ao confirmar
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog.value = false // Fecha ao cancelar
                    onVerificationResult(false)
                }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
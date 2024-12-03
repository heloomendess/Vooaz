package com.vooazdomain.Vooaz.telas.inputflow

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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
fun InputFullRegisterScreen(navController: NavController) {
    val backgroundColor = Color(0xFF3B5998) // Fundo azul
    val primaryColor = Color(0xFFFFC107) // Amarelo principal
    val textFieldBackground = Color.White

    Scaffold(
        containerColor = backgroundColor,
        topBar = {
                    Row() {


                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(R.string.voltar, "Voltar"),
                                modifier = Modifier.size(60.dp).padding(start = 20.dp, top= 15.dp),
                                tint = MaterialTheme.colorScheme.onSecondary
                            )


                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(modifier = Modifier.padding(end = 60.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.logoaz),
                                    contentDescription = stringResource(R.string.imagem,"image description"),
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .width(105.dp)
                                        .height(123.dp)
                                )
                            }
                        }

                }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {


            Spacer(modifier = Modifier.height(2.dp))

            // Texto de boas-vindas
            Text(
                text = stringResource(R.string.pergunta, "Queremos\nte conhecer melhor!"),
                style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontSize = 32.sp,
                    lineHeight = 37.32.sp,

                    fontWeight = FontWeight.Bold,
                    color =MaterialTheme.colorScheme.onTertiary ,
                    textAlign = TextAlign.Center,
                ),
                    modifier = Modifier
                        .width(333.dp)
                        .height(74.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            // Formulário
            TextFieldWithLabel(
                label = "Nome completo",
                placeholder = "Digite seu nome",
                leadingIcon = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextFieldWithLabel(
                label = "Nome social",
                placeholder = "Digite seu nome social",
                leadingIcon = Icons.Default.Person
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextFieldWithLabel(
                label = "Data de nascimento",
                placeholder = "DD/MM/AAAA",
                leadingIcon = Icons.Filled.DateRange,
                keyboardType = KeyboardType.Number
            )
            Spacer(modifier = Modifier.height(8.dp))

            GenderDropdown()

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de ação
            Button(
                onClick = { navController.navigate(route = "LoadingScreen/HomePageScreen") },
                modifier = Modifier
                    .width(329.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(size = 15.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurfaceVariant)

            ) {
                Text(
                    text = stringResource(R.string.entrar, "Entrar"),
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(900),
                        color = MaterialTheme.colorScheme.surface,
                        textAlign = TextAlign.Center,
                    ),
                        modifier = Modifier
                            .width(106.dp)
                            .height(30.dp)

                )
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
    keyboardType: KeyboardType = KeyboardType.Text
) {
    var text by remember { mutableStateOf("") }

    Column {
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
                    .height(24.dp)

            )
        }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(text = placeholder) },
            leadingIcon = {
                Icon(imageVector = leadingIcon, contentDescription = label, tint =MaterialTheme.colorScheme.onTertiary )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            singleLine = true,
            modifier =Modifier
                .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 15.dp)).width(330.dp)
                .height(60.dp)
                .background(color =MaterialTheme.colorScheme.surfaceContainerHighest, shape = RoundedCornerShape(size = 15.dp)))
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun GenderDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("Selecione seu gênero") }

    Column {
        Text(
            text = stringResource(R.string.genero, "Gênero"),
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = MaterialTheme.colorScheme. onTertiary,
                textAlign = TextAlign.Center,
            ),
                modifier = Modifier
                    .width(60.dp)
                    .height(24.dp)

        )
        Box(
            Modifier
                .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 15.dp)).clickable {
                    expanded = true
                }
            .width(330.dp)
            .height(54.dp)
            .background(color =MaterialTheme.colorScheme. surfaceContainerHighest, shape = RoundedCornerShape(size = 15.dp))
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(start = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = selectedGender, color =MaterialTheme.colorScheme.onSecondary)
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = stringResource(R.string.Dropdown, "Dropdown"))
            }
        }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(330.dp)
                    .height(90.dp)
                    .background(color = MaterialTheme.colorScheme. surfaceContainerHighest, shape = RoundedCornerShape(size = 15.dp))
                ) {
                    listOf("Masculino", "Feminino", "Outro").forEach { gender ->
                        DropdownMenuItem(
                            text = { Text(gender) },
                            onClick = {
                                selectedGender = gender
                                expanded = false
                            }
                        )
                    }
                }
            }
        }


@Preview
@Composable
fun InputFullRegisterScreenPreview() {
    InputFullRegisterScreen(rememberNavController())

}

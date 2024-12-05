package com.vooazdomain.Vooaz.telas.settingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfoScreen(navController: NavController) {

    Scaffold(
        topBar = {

            Box(modifier = Modifier.fillMaxWidth().height(60.dp).background(MaterialTheme.colorScheme.onBackground)
            , contentAlignment = Alignment.Center) {
                Row (modifier = Modifier.fillMaxSize().padding(15.dp)) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.voltar),
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Informações pessoais",

                        style =
                        TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 31.32.sp,
                            fontWeight = FontWeight(900),
                            color =MaterialTheme.colorScheme.surfaceContainerHighest,
                        ),
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        stringResource(R.string.editar,
                        "editar"), modifier = Modifier.padding(top = 4.dp), fontSize = 20.sp, fontFamily = poppinsFontFamily)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.outlineVariant) // Fundo mais claro
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                SectionTitleProfileInfo("Nome completo")
                InputField(placeholder = "Nome")

                SectionTitleProfileInfo("Nome social")
                InputField(placeholder = "Nome social")

                SectionTitleProfileInfo("Data de nascimento")
                InputField(placeholder = "XX/XX/XXXX")

                SectionTitleProfileInfo("Gênero")
                DropdownField(options = listOf("Masculino", "Feminino", "Outro"))

                SectionTitleProfileInfo("Telefone para contato")
                InputField(placeholder = "+55 (11) XXXXX-XXXX")

                SectionTitleProfileInfo("Informar outro telefone")
                InputField(placeholder = "+55 (11) XXXXX-XXXX")

                SectionTitleProfileInfo("Cidade")
                InputField(placeholder = "São Paulo")

                SectionTitleProfileInfo("Estado")
                InputField(placeholder = "São Paulo")

                SectionTitleProfileInfo("Sobre sua deficiência")
                DropdownField(options = listOf("Visual", "Auditiva", "Motora", "Outra"))
            }

            item {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier =Modifier
                        .shadow(elevation = 4.dp, spotColor = MaterialTheme.colorScheme. surfaceContainer, ambientColor = MaterialTheme.colorScheme. surfaceContainer)
                        .width(143.dp)
                        .height(49.dp).padding(top = 15.dp),

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
fun InputField(
    placeholder: String,
    icon: String? = null,
) {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text(placeholder, color = MaterialTheme.colorScheme.tertiary) },

        modifier = Modifier
            .width(350.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp)) // Borda mais fina
            .background(Color.White, RoundedCornerShape(8.dp)), // Fundo branco
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),

    )
}

@Composable
fun DropdownField(options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .width(350.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .border(1.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp)) // Borda ao redor do dropdown
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { expanded = true }
    ) {
        Text(
            text = if (selectedOption.isEmpty()) "Selecione" else selectedOption,
            modifier = Modifier.padding(16.dp),
            color = if (selectedOption.isEmpty()) Color.Gray else Color.Black
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonalInfoScreen() {
    PersonalInfoScreen(rememberNavController())
}

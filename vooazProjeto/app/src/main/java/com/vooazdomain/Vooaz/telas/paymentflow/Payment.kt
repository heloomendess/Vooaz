package com.vooazdomain.Vooaz.telas.paymentflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.ui.theme.*  // Importando as cores do tema

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pagamento(navController: NavController) {

    val nome = remember { mutableStateOf("") }
    val numeroCartao = remember { mutableStateOf("") }
    val dataExpedicao = remember { mutableStateOf("") }
    val cvc = remember { mutableStateOf("") }
    val cpfcnpj = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    val selectedPais = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    val paises = listOf(
        stringResource(id = R.string.brasil),
        stringResource(id = R.string.united_states),
        stringResource(id = R.string.portugal),
        stringResource(id = R.string.japan),
        stringResource(id = R.string.russia)
    )
    Scaffold(modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.onBackground),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.arrowback),
                            contentDescription = stringResource(id = R.string.voltar),
                            modifier = Modifier.size(50.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.close),
                            contentDescription = stringResource(id = R.string.fechar),
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.tela_pagamento),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.padding(top = 16.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.pagamento),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.padding(top = 0.dp),
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.nome_completo_titular),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(bottom = 0.dp)
                    )
                    OutlinedTextField(
                        value = nome.value,
                        onValueChange = { nome.value = it },
                        label = { Text(stringResource(id = R.string.nome_completo_titular)) },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.user_icon),
                                contentDescription = stringResource(id = R.string.imagem_usuario),
                                modifier = Modifier.size(24.dp),
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = stringResource(id = R.string.numero_cartao),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color =MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(top = 15.dp, bottom = 0.dp)
                    )
                    OutlinedTextField(
                        value = numeroCartao.value,
                        onValueChange = { numeroCartao.value = it },
                        label = { Text(stringResource(id = R.string.numero_cartao)) },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.icon_cartao),
                                contentDescription = stringResource(id = R.string.imagem_cartao),
                                modifier = Modifier.size(24.dp),
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                            unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 6.dp, vertical = 0.dp),
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 10.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = stringResource(id = R.string.data_expedicao),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.onTertiary,
                                modifier = Modifier.padding(top = 15.dp, bottom = 0.dp)
                            )
                            OutlinedTextField(
                                value = dataExpedicao.value,
                                onValueChange = { dataExpedicao.value = it },
                                label = { Text("MM/AA") },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.calendario),
                                        contentDescription = stringResource(id = R.string.expires),
                                        modifier = Modifier.size(24.dp),
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                                    focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                                    unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary,
                                ),
                                modifier = Modifier
                                    .width(150.dp)
                                    .padding(top = 0.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = stringResource(id = R.string.codigo_seguranca),
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onTertiary,
                                modifier = Modifier.padding(top = 15.dp, bottom = 0.dp)
                            )
                            OutlinedTextField(
                                value = cvc.value,
                                onValueChange = { cvc.value = it },
                                label = { Text("CVC") },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.cvc),
                                        contentDescription = stringResource(id = R.string.cvc),
                                        modifier = Modifier.size(24.dp),
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                                    focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                                    focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                                    unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary,
                                ),
                                modifier = Modifier
                                    .width(150.dp)
                                    .padding(top = 0.dp)
                            )
                        }
                    }

                    Text(
                        text = stringResource(id = R.string.cpf_cnpj),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(top = 15.dp, bottom = 4.dp)
                    )
                    OutlinedTextField(
                        value = cpfcnpj.value,
                        onValueChange = { cpfcnpj.value = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                            unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = stringResource(id = R.string.endereco_email),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color =MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.padding(top = 15.dp, bottom = 0.dp)
                    )
                    OutlinedTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text(stringResource(id = R.string.endereco_email)) },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = stringResource(id = R.string.email),
                                modifier = Modifier.size(24.dp),
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                            unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = selectedPais.value,
                        onValueChange = {},
                        label = { Text(stringResource(id = R.string.selecionar_pais)) },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.mundo),
                                contentDescription = stringResource(id = R.string.imagem_fixa),
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { expanded.value = !expanded.value }) {
                                Image(
                                    painter = painterResource(id = if (expanded.value) R.drawable.flecha_cima else R.drawable.flecha_baixo),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                            focusedBorderColor =  MaterialTheme.colorScheme.onTertiary,
                            unfocusedBorderColor =  MaterialTheme.colorScheme.tertiary,
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        paises.forEach { name ->
                            DropdownMenuItem(
                                text = { Text(name) },
                                onClick = {
                                    selectedPais.value = name
                                    expanded.value = false
                                }
                            )
                        }
                    }

                }
            }
        }
    )
}


@Preview(showBackground = true, widthDp = 390, heightDp = 800 )
@Composable
fun PagamentoPreview() {
    VooazTheme {
        Pagamento(rememberNavController())
    }
}
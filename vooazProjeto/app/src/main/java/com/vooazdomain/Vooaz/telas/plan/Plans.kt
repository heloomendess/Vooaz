package com.vooazdomain.Vooaz.telas.plan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.vooazdomain.Vooaz.ui.theme.VooazTheme
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Plans(navController: NavController) {
    val refreshing = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var someThemes = MaterialTheme.colorScheme
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = someThemes.background,
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = someThemes.background),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(id = R.drawable.arrowback),
                            contentDescription =  stringResource(R.string.voltar),
                            modifier = Modifier.size(50.dp)
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        stringResource(R.string.explore_nossos_planos),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = someThemes.onTertiary,
                        modifier = Modifier.padding(top = 16.dp),
                        textAlign = TextAlign.Center
                    )
                }


                //Plano Gratis
                item {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color(0xFF97D8C4), RoundedCornerShape(30.dp))
                            .border(BorderStroke(2.dp, someThemes.onSecondaryContainer), RoundedCornerShape(30.dp))
                            .padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.plano_gratis),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(455.dp)
                                    .padding(top = 20.dp, bottom = 0.dp)
                            )

                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = someThemes.onTertiary,
                                    contentColor = someThemes.onSecondary
                                ),
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(1.dp, someThemes.onSecondary),
                                modifier = Modifier
                                    .padding(top = 14.dp, bottom = 10.dp)

                            ) {
                                Text(
                                    stringResource(R.string.continuar_gratis),
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }


                //Plano Explorador
                item {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(Color(0xFF6B9AC4), RoundedCornerShape(30.dp))
                            .border(BorderStroke(2.dp, someThemes.onSecondaryContainer), RoundedCornerShape(30.dp))
                            .padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.plano_explorador),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(455.dp)
                                    .padding(top = 20.dp, bottom = 0.dp)
                            )

                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF97D8C4),
                                    contentColor = someThemes.onSecondary
                                ),
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(1.dp, someThemes.onSecondary),
                                modifier = Modifier
                                    .padding(top = 14.dp, bottom = 10.dp)

                            ) {
                                Text(
                                    text = stringResource(R.string.obter_plano),
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }

                //Plano Sem Fronteiras
                item {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .background(someThemes.onTertiary, RoundedCornerShape(30.dp))
                            .border(BorderStroke(2.dp, someThemes.onSecondaryContainer), RoundedCornerShape(30.dp))
                            .padding(16.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.plano_sem_fronteiras),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(455.dp)
                                    .padding(top = 20.dp, bottom = 0.dp)
                            )

                            Button(
                                onClick = {},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = someThemes.secondary,
                                    contentColor = someThemes.onSecondary
                                ),
                                shape = RoundedCornerShape(30.dp),
                                border = BorderStroke(1.dp, someThemes.onSecondary),
                                modifier = Modifier
                                    .padding(top = 14.dp, bottom = 10.dp)

                            ) {
                                Text(
                                    text = stringResource(R.string.obter_plano),
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }

        }
    )
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800 )
@Composable
fun PlansPreview() {
    VooazTheme {
        Plans(rememberNavController())
    }
}
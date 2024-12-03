package com.vooazdomain.Vooaz.navigationflow

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app.ui.screens.AzConnectProfileScreen
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.telas.aboutus.AboutUsScreen
import com.vooazdomain.Vooaz.telas.azconnect.Conexoes
import com.vooazdomain.Vooaz.telas.azconnect.ConnectionsSearchScreen
import com.vooazdomain.Vooaz.telas.azconnect.connections
import com.vooazdomain.Vooaz.telas.destinationsScreen.CapitalScreen
import com.vooazdomain.Vooaz.telas.destinationsScreen.DestinationCard
import com.vooazdomain.Vooaz.telas.guidesSearch.GuidesScreen
import com.vooazdomain.Vooaz.telas.home.HomePageScreen
import com.vooazdomain.Vooaz.telas.inputflow.InputFullRegisterScreen
import com.vooazdomain.Vooaz.telas.inputflow.InputScreen
import com.vooazdomain.Vooaz.telas.inputflow.LoginScreen
import com.vooazdomain.Vooaz.telas.plan.PlanSuggestionScreen
import com.vooazdomain.Vooaz.telas.inputflow.RegisterAccountContent
import com.vooazdomain.Vooaz.telas.plan.Plans
import com.vooazdomain.Vooaz.telas.profile.ProfileScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ChangePasswordScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ForgotPasswordPinScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ForgotPasswordScreen
import com.vooazdomain.Vooaz.telas.settingScreen.PersonalInfoScreen
import com.vooazdomain.Vooaz.telas.settingScreen.SettingsScreen
import com.vooazdomain.Vooaz.telas.splashpage.addSplashPage

@Composable
fun NavigationFlowSettings() {
    val navController = rememberNavController()

    val userAutentic: Boolean = false // caso true usuario esta autenticado, aso false não esta
    val destination = if (userAutentic) "HomePageScreen" else "InputScreen"
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            innerPadding
            NavHost(
                navController = navController,
                startDestination = "addSplashPage"
            ) {


                composable("GuidesScreen") {
                    GuidesScreen(navController)
                }
                composable("Conexoes") {
                    Conexoes(navController)
                }
                composable(
                    "LoadingScreen/{route}",  // Definindo o argumento
                    arguments = listOf(navArgument("route") {
                        type = NavType.StringType
                    })  // Tipo de dado
                ) {
                    val route = it.arguments?.getString("route") ?: "Mensagem padrão"
                    LoadingScreen(navController, route)
                }

                val sampleDestinations = listOf(
                    DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
                    DestinationCard("Museu Catavento", R.drawable.museucatavento),
                    DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
                    DestinationCard("Museu Catavento", R.drawable.museucatavento),
                    DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
                    DestinationCard("Museu Catavento", R.drawable.museucatavento),
                    DestinationCard("Museu do Ipiranga", R.drawable.museuimg),
                    DestinationCard("Museu Catavento", R.drawable.museucatavento),
                )

                composable("addSplashPage") {

                    addSplashPage(navController, destination)
                }
                composable("AboutUsScreen") {
                    AboutUsScreen(navController)
                }
                composable("CapitalScreen") {
                    CapitalScreen(navController, sampleDestinations)
                }
                composable("HomePageScreen") {
                    HomePageScreen(navController)
                }
                composable("PersonalInfoScreen") {
                    PersonalInfoScreen(navController)
                }
                composable("PlanScreenSuggestion") {
                    PlanSuggestionScreen(navController)
                }
                composable("ConnectionsSearchScreen") {
                    val sampleconnections = listOf(
                        connections(
                            "Fabio Nascimento",
                            "Paris, França",
                            R.drawable.ic_profile_placeholder,
                            "Fabio"
                        ),
                        connections(
                            "Lais\n" +
                                    "Ribeiro",
                            "São Paulo, Brasil",
                            R.drawable.examplepeopleprofile,
                            "Lais"
                        ),
                        connections(
                            "Lucas Amorim",
                            "Santa Catarina, Brasil",
                            R.drawable.ic_profile_placeholder3,
                            ""
                        ),
                        connections(
                            "Alessandra Luz",
                            "Veneza, Itália",
                            R.drawable.ic_profile_placeholder4,
                            ""
                        ),
                        connections(
                            "João Silva",
                            "Lisboa, Portugal",
                            R.drawable.ic_profile_placeholder5,
                            ""
                        ),
                        connections(
                            "Fabio Nascimento",
                            "Paris, França",
                            R.drawable.ic_profile_placeholder,
                            ""
                        ),
                        connections(
                            "Maria Valentina",
                            "São Paulo, Brasil",
                            R.drawable.ic_profile_placeholder2,
                            ""
                        ),
                        connections(
                            "Lucas Amorim",
                            "Santa Catarina, Brasil",
                            R.drawable.ic_profile_placeholder3,
                            ""
                        ),
                        connections(
                            "Alessandra Luz",
                            "Veneza, Itália",
                            R.drawable.ic_profile_placeholder4,
                            ""
                        ),
                        connections(
                            "João Silva",
                            "Lisboa, Portugal",
                            R.drawable.ic_profile_placeholder5,
                            ""
                        ),
                        connections(
                            "Fabio Nascimento",
                            "Paris, França",
                            R.drawable.ic_profile_placeholder,
                            ""
                        ),
                        connections(
                            "Maria Valentina",
                            "São Paulo, Brasil",
                            R.drawable.ic_profile_placeholder2,
                            ""
                        ),
                        connections(
                            "Lucas Amorim",
                            "Santa Catarina, Brasil",
                            R.drawable.ic_profile_placeholder3,
                            ""
                        ),
                        connections(
                            "Alessandra Luz",
                            "Veneza, Itália",
                            R.drawable.ic_profile_placeholder4,
                            ""
                        ),
                        connections(
                            "João Silva",
                            "Lisboa, Portugal",
                            R.drawable.ic_profile_placeholder5,
                            ""
                        )
                    )

                    ConnectionsSearchScreen(navController, sampleconnections)
                }
                // tela de perfil
                composable("ProfileScreen") {
                    ProfileScreen(navController)
                }

                // tela de perfil de terceiros
                composable("AzConnectProfileScreen") {
                    AzConnectProfileScreen(navController)
                }
                composable("InputFullRegisterScreen") {
                    InputFullRegisterScreen(navController)
                }
                composable("Plans") {
                    Plans(navController)
                }

                composable("ForgotPassword") {
                    ForgotPasswordScreen(navController)
                }
                composable("ForgotPasswordPin") {
                    ForgotPasswordPinScreen(navController)
                }
                composable("ChangePasswordScreen") {
                    ChangePasswordScreen(navController)
                }
                composable("LoginScreen") {
                    LoginScreen(navController)
                }
                composable("RegisterAccountScreen") {
                    RegisterAccountContent(navController)
                }
                composable("InputScreen") {

                    InputScreen(navController)
                }
                composable("SettingsScreen") {
                    SettingsScreen(navController)
                }

            }
        },

        )
}


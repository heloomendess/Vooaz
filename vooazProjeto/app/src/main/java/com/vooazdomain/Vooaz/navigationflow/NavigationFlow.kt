package com.vooazdomain.Vooaz.navigationflow


import DestinationDetailsScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.feedbackscreen.FeedbackScreen
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.constantsData.UsersConts
import com.vooazdomain.Vooaz.telas.aboutus.AboutUsScreen
import com.vooazdomain.Vooaz.telas.azchat.PrivateChatScreen
import com.vooazdomain.Vooaz.telas.azconnect.Conexoes
import com.vooazdomain.Vooaz.telas.azconnect.ChatSearchConectsScreen
import com.vooazdomain.Vooaz.telas.azconnect.GuidesProfile
import com.vooazdomain.Vooaz.telas.destinationsScreen.CapitalScreen
import com.vooazdomain.Vooaz.telas.destinationsScreen.DestinationCard
import com.vooazdomain.Vooaz.telas.feedbackscreens.FeedbackConfirmScreen
import com.vooazdomain.Vooaz.telas.guidesSearch.GuideSearch
//import com.vooazdomain.Vooaz.telas.guidesSearch.GuidesScreen
import com.vooazdomain.Vooaz.telas.home.HomePageScreen
import com.vooazdomain.Vooaz.telas.inputflow.InputFullRegisterScreen
import com.vooazdomain.Vooaz.telas.inputflow.InputScreen
import com.vooazdomain.Vooaz.telas.inputflow.LoginScreen
import com.vooazdomain.Vooaz.telas.plan.PlanSuggestionScreen
import com.vooazdomain.Vooaz.telas.inputflow.RegisterAccountContent
import com.vooazdomain.Vooaz.telas.plan.Plans
import com.vooazdomain.Vooaz.telas.profile.OthersProfile
import com.vooazdomain.Vooaz.telas.profile.ProfileScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ChangePasswordScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ForgotPasswordPinScreen
import com.vooazdomain.Vooaz.telas.resetpassword.ForgotPasswordScreen
import com.vooazdomain.Vooaz.telas.settingScreen.AdjustsScreen
import com.vooazdomain.Vooaz.telas.settingScreen.HelpCenterActivity
import com.vooazdomain.Vooaz.telas.settingScreen.HelpCenterScreen
import com.vooazdomain.Vooaz.telas.settingScreen.PersonalInfoScreen
import com.vooazdomain.Vooaz.telas.settingScreen.SettingsScreen
import com.vooazdomain.Vooaz.telas.settingScreen.TravelHistoryScreen
import com.vooazdomain.Vooaz.telas.splashpage.addSplashPage

@Composable
fun NavigationFlowSettings() {
    val navController = rememberNavController()

    val userAutentic = true // caso true usuario esta autenticado, aso false não esta
    val destination = if (userAutentic) "HomePageScreen" else "InputScreen"

    val sharedViewModelUser: SharedModel = viewModel()


    val selectedModel = sharedViewModelUser
if (userAutentic){
    UsersConts().getUserById(1)?.let { selectedModel.setSelectedUser(it) }
}

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            innerPadding
            NavHost(
                navController = navController,
                startDestination = "addSplashPage"
            ) {

                composable("HelpCenterScreen") {
                    var help_funcs = HelpCenterActivity()
                    HelpCenterScreen(navController, onEmailClick = {help_funcs.openEmail()}, onChatClick = {help_funcs.openChat()}, onFAQClick = {help_funcs.openFAQ()})
                }


                composable("GuidesScreen"){

                    GuideSearch(navController, selectedModel)
                }
                composable("OthersProfile"){

                    OthersProfile(navController, selectedModel)
                }
                composable("DestinationDetailsScreen"){

                    DestinationDetailsScreen(navController = navController, sharedModel= selectedModel)
                }

                composable("TravelHistoryScreen") {
                    TravelHistoryScreen(navController)
                }
                composable("AdjustsScreen") {
                    AdjustsScreen(navController)
                }
                composable("FeedbackScreen") {
                    FeedbackScreen(navController)
                }
                composable("FeedbackConfirmScreen") {
                    FeedbackConfirmScreen(navController)
                }

                composable("Conexoes") {
                    Conexoes(navController)
                }
                composable(
                    "LoadingScreen/{route}",
                    arguments = listOf(
                        navArgument("route") { type = NavType.StringType },
                    )
                ) {
                    val route = it.arguments?.getString("route") ?: "Mensagem padrão"
                    LoadingScreen(navController, route)  // Passando os argumentos para a tela
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


                        HomePageScreen(navController, selectedModel)
                    }

                composable("PersonalInfoScreen") {
                    PersonalInfoScreen(navController)
                }
                composable("PlanScreenSuggestion") {
                    PlanSuggestionScreen(navController)
                }
                composable("ChatSearchConectsScreen") {


                    ChatSearchConectsScreen(navController, selectedModel)
                }
                // tela de perfil
                composable("ProfileScreen"){

                    ProfileScreen(navController, selectedModel)
                }
                composable("PrivateChatScreen"){

                    PrivateChatScreen(navController, selectedModel)
                }




                composable("OthersProfile") {

                    OthersProfile(navController,  selectedModel )
                }
                composable("GuidesProfile") {

                    GuidesProfile(navController, selectedModel)
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
                    LoginScreen(navController, selectedModel)
                }
                composable("RegisterAccountScreen") {
                    RegisterAccountContent(navController)
                }

                composable("InputScreen") {

                    InputScreen(navController)
                }
                composable("SettingsScreen"){

                    SettingsScreen(navController,  selectedModel)

                }

            }
        },

        )
}


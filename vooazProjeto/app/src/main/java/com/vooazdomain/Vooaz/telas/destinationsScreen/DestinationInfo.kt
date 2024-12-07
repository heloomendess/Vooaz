import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vooazdomain.Vooaz.R
import com.vooazdomain.Vooaz.modelsData.SharedModel.SharedModel
import com.vooazdomain.Vooaz.modelsData.datas.Comments
import com.vooazdomain.Vooaz.telas.destinationsScreen.TravelItineraryScreen
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily


@Composable
fun DestinationDetailsScreen(
    navController: NavController,
    sharedModel: SharedModel,
    expandRouteTravel: MutableState<Boolean> = remember { mutableStateOf(false) },
    expanded_hours: MutableState<Boolean> = remember { mutableStateOf(false) },
) {
var destination = sharedModel.selectedDestination
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.onTertiaryContainer)) {
        Box() {
            Image(
                painter = painterResource(destination?.imageRes ?: R.drawable.ic_flag_brazil),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
        }
        // Conteúdo principal
        if (!expandRouteTravel.value){
        Column(
            modifier = Modifier
                .fillMaxWidth().verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier
                .width(240.dp)
                .height(55.dp)
                .background(color = MaterialTheme.colorScheme.onTertiary, shape = RoundedCornerShape(size = 20.dp)).clickable {
                }, contentAlignment = Alignment.Center) {
                Text(
                    text = destination?.name ?: "Name default",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSecondaryContainer

                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )}


Box(modifier =Modifier.padding(top = 10.dp).border(2.dp,MaterialTheme.colorScheme.tertiary , shape = RoundedCornerShape(size = 20.dp)).fillMaxWidth()) {
    Box(modifier = Modifier.padding(20.dp)) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tripdivisor",
                color = MaterialTheme.colorScheme.scrim,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = destination?.location ?:"Localiza")
            Text(text = stringResource(R.string.telefone,"Telefone: ${destination?.phone}"))
            Text(text = stringResource(R.string.horários, "Horários: ${destination?.schedules}"))
            Box(modifier = Modifier.fillMaxWidth().clickable {
                expanded_hours.value =!expanded_hours.value
            }, contentAlignment = Alignment.Center) {
                Icon(

                    imageVector = if (expanded_hours.value) {
                        Icons.Default.KeyboardArrowUp
                    } else {
                        Icons.Default.KeyboardArrowDown
                    }, contentDescription = stringResource(R.string.seta,"seta"),
                    modifier = Modifier.size(30.dp)
                )
            }
        }

    }
}
   if (expanded_hours.value) {
       Box(
           modifier = Modifier.padding(top = 10.dp)
               .border(2.dp, Color.Gray, shape = RoundedCornerShape(size = 20.dp)).fillMaxWidth()
       ) {
           Box(modifier = Modifier.padding(20.dp)) {
               Row {
                   Text(
                       text = stringResource(R.string.agenda,"Terça-feira: 09:00 - 16:00\nQuarta-feira: 09:00 - 16:00\nQuinta-feira: 09:00 - 16:00\nSexta-feira: 09:00 - 16:00\nSábado: 09:00 - 16:00\nDomingo: 13:00 - 16:00\nSegunda-feira: 09:00 - 16:00"),
                       style = TextStyle(
                           fontSize = 12.sp,
                           fontWeight = FontWeight(700),
                           color = MaterialTheme.colorScheme.onSecondary
                       )
                   )
               }
           }
       }
   }
            Spacer(modifier = Modifier.height(8.dp))

            Box(modifier =Modifier.border(2.dp, Color.Gray, shape = RoundedCornerShape(size = 20.dp)).fillMaxWidth()) {
                Box(modifier = Modifier.padding(10.dp)) {// Informações principais
                    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
                        Text(stringResource(R.string.avaliações,"Avaliações"))
                        Image(painterResource(R.drawable.ico_coruja) ,contentDescription = "empresa", modifier = Modifier.size(80.dp))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "4/5\nTripadvisor\n(364 avaliações)",
                            style = TextStyle(
                                fontFamily = poppinsFontFamily,
                                fontSize = 15.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                textDecoration = TextDecoration.Underline,
                            )
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier =Modifier.border(2.dp, Color.Gray, shape = RoundedCornerShape(size = 20.dp)).fillMaxWidth()) {
                Box(modifier = Modifier.padding(10.dp)) {// Informações principais
                    Column (modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){


                        Text(
                            text = destination?.description ?: "Sobre",
                            modifier =Modifier.padding(10.dp),
                            style = TextStyle(
                                fontFamily = poppinsFontFamily,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Center,
                                textDecoration = TextDecoration.Underline,
                            )
                        )

                    }
                }
            }


            // Comentários dos usuários
            Spacer(modifier = Modifier.height(24.dp))
            UserCommentsSection(destination?.userComments ?: listOf(Comments("Dan", "12345", 5)))

            // Botão para ação
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    expandRouteTravel.value = !expandRouteTravel.value
                },
                modifier = Modifier
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 20.dp))
                    .width(192.dp)
                    .height(44.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(stringResource(R.string.roteiro,"Roteiro"))
            }
            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(size = 20.dp))
                .width(272.dp)
                .height(54.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onTertiary),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(stringResource(R.string.visita,"Realizar visita"))
            }
        }
    } else {

    TravelItineraryScreen(expandRouteTravel)
}
}
}
@Composable
fun RatingSection(rating: Float, reviewsCount: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant // Cor da estrela (amarela)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "$rating/5"
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "($reviewsCount avaliações)",
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun UserCommentsSection(comments: List<Comments>) {
    Text(
        text = stringResource(R.string.comentário,"Comentario dos Usuarios"),
        style = TextStyle(
            fontFamily = poppinsFontFamily,
            fontSize = 20.sp,
            lineHeight = 27.37.sp,
            fontWeight = FontWeight(900),
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center,
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    comments.forEach { comment ->
        UserCommentItem(comment)
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun UserCommentItem(comment: Comments) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp,MaterialTheme.colorScheme. outline, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = comment.nome
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = comment.Rating.toString(),
                    color =  MaterialTheme.colorScheme.tertiary
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = comment.Comment,
                color =MaterialTheme.colorScheme.secondaryContainer )

        }
    }
}

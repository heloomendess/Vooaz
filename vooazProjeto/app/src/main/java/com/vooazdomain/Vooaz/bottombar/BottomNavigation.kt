import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vooazdomain.Vooaz.bottombar.BottomNavItem
import com.vooazdomain.Vooaz.bottombar.ConstantsBottomNavItem
import com.vooazdomain.Vooaz.modelsData.datas.User
import com.vooazdomain.Vooaz.ui.theme.poppinsFontFamily
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay

@Composable
fun BottomNavigation(navController: NavController, user: User?) {
    val items = ConstantsBottomNavItem
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(topStart = 55.dp, topEnd = 55.dp)
            )
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.BottomNavItems.forEach { item ->
                val isSelected = currentRoute == item.route

                NavigationItem(
                    item = item,
                    isSelected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@OptIn(InternalCoroutinesApi::class)
@Composable
fun NavigationItem(item: BottomNavItem, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(true) {
            delay(1000)
                }
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.label,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
            modifier = if (isSelected) Modifier.size(29.dp) else Modifier.size(24.dp)
        )
        if (isSelected) {
            Text(
                text = item.label,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = poppinsFontFamily
            )
        }
    }
}
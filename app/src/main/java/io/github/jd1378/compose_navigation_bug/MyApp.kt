package io.github.jd1378.compose_navigation_bug

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import io.github.jd1378.compose_navigation_bug.ui.navigation.MainDestinations
import io.github.jd1378.compose_navigation_bug.ui.navigation.rememberTheNavController
import io.github.jd1378.compose_navigation_bug.ui.screens.addAboutGraph
import io.github.jd1378.compose_navigation_bug.ui.screens.addHomeGraph
import io.github.jd1378.compose_navigation_bug.ui.theme.Compose_navigation_bugTheme

@Composable
fun MyApp () {
    Compose_navigation_bugTheme  {
        val theNavController = rememberTheNavController()

        NavHost(
            navController = theNavController.navController,
            startDestination = MainDestinations.HOME_ROUTE) {
            myAppNavGraph(
                upPress = theNavController::upPress,
                onNavigateToRoute = theNavController::navigateToRoute)
        }
    }
}

private fun NavGraphBuilder.myAppNavGraph(
    upPress: () -> Unit,
    onNavigateToRoute: (String) -> Unit
) {
    addHomeGraph(onNavigateToRoute)
    addAboutGraph(onNavigateToRoute, upPress)
}

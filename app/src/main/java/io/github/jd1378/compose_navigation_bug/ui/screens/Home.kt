package io.github.jd1378.compose_navigation_bug.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.jd1378.compose_navigation_bug.R
import io.github.jd1378.compose_navigation_bug.ui.navigation.MainDestinations

fun NavGraphBuilder.addHomeGraph(
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier
) {
  composable(
      MainDestinations.HOME_ROUTE,
      exitTransition = {
          slideOutOfContainer(
              AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(700)
          )
      },
      enterTransition = {
          slideIntoContainer(
              AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(700)
          )
      },
      popExitTransition = {
          slideOutOfContainer(
              AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(700)
          )
      },
      popEnterTransition = {
          slideIntoContainer(
              AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(700)
          )
      }
  ) {
    Home(onNavigateToRoute, modifier)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onNavigateToRoute: (String) -> Unit, modifier: Modifier) {
  Scaffold(modifier = modifier) { padding ->
    Column(modifier.padding(padding).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
      Button(onClick = { onNavigateToRoute(MainDestinations.ABOUT_ROUTE) }) {
        Text(stringResource(R.string.about))
     }
    }
  }
}

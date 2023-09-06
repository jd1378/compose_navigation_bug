package io.github.jd1378.compose_navigation_bug.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.jd1378.compose_navigation_bug.R
import io.github.jd1378.compose_navigation_bug.ui.components.TitleBar
import io.github.jd1378.compose_navigation_bug.ui.navigation.MainDestinations

fun NavGraphBuilder.addAboutGraph(
    onNavigateToRoute: (String) -> Unit,
    upPress: () -> Unit,
    modifier: Modifier = Modifier
) {
  composable(
      MainDestinations.ABOUT_ROUTE,
      exitTransition = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(700))
      },
      popExitTransition = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.End, animationSpec = tween(700))
      },
      enterTransition = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(700))
      },
      popEnterTransition = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Start, animationSpec = tween(700))
      }) {
        About(onNavigateToRoute, upPress, modifier)
      }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(onNavigateToRoute: (String) -> Unit, upPress: () -> Unit, modifier: Modifier) {
  Scaffold(
      modifier = modifier, topBar = { TitleBar(text = stringResource(R.string.about), upPress) }) {
          padding ->
        Column(modifier.padding(padding), verticalArrangement = Arrangement.Center) {
          Text(text = stringResource(R.string.about_desc))
          Button(onClick = upPress) {
            Text(stringResource(R.string.label_back), modifier= Modifier.fillMaxSize())
          }
        }
      }
}

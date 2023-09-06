package io.github.jd1378.compose_navigation_bug.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
  ) {
    About(onNavigateToRoute, upPress, modifier)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(onNavigateToRoute: (String) -> Unit, upPress: () -> Unit, modifier: Modifier) {
  Scaffold(
      modifier = modifier,
      topBar = {
        TitleBar(text = stringResource(R.string.about), upPress)
      }) { padding ->
        Column(modifier.padding(padding), verticalArrangement = Arrangement.Center) {
          Text(text = stringResource(R.string.about_desc))
        }
      }
}

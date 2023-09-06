package io.github.jd1378.compose_navigation_bug.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.jd1378.compose_navigation_bug.R
import io.github.jd1378.compose_navigation_bug.utils.mirroringBackIcon

@Composable
private fun Up(upPress: () -> Unit) {
  IconButton(
      onClick = upPress,
      modifier =
          Modifier.statusBarsPadding().padding(horizontal = 16.dp, vertical = 10.dp).size(36.dp)) {
        Icon(
            imageVector = mirroringBackIcon(),
            contentDescription = stringResource(R.string.label_back))
      }
}

@Composable
fun TitleBar(text: String, upPress: () -> Unit, showBackButton: Boolean = true) {
  Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
    if (showBackButton) {
        Up(upPress)
    }
    Text(text = text, fontSize = 20.sp, modifier = Modifier.statusBarsPadding())
  }
}

package com.example.pokedex.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.team_full

@Composable
fun FullTeamAlert(
	onDismiss: () -> Unit,
	modifier: Modifier = Modifier
) {
	AlertDialog(
		onDismissRequest = onDismiss,
		title = {
			Text(
				text = "Team Full",
				color = ThemeColors.deepGreen,
				style = Typography.pixelCardTitle(),
				fontSize = 18.sp,
				modifier = Modifier.fillMaxWidth(),
				textAlign = TextAlign.Center
			)
		},
		text = {
			Column(
				modifier = modifier.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Image(
					painter = painterResource(Res.drawable.team_full),
					contentDescription = "Team full",
					modifier = Modifier.size(88.dp)
				)
				Text(
					text = "Your team already has 6 Pokemon. Remove one before adding another.",
					color = ThemeColors.deepGreen,
					textAlign = TextAlign.Center
				)
			}
		},
		confirmButton = {
			Column(
				modifier = Modifier.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Button(
					onClick = onDismiss,
					shape = RoundedCornerShape(999.dp),
					modifier = Modifier
									.widthIn(min = 120.dp),
								colors = ButtonDefaults.buttonColors(
									containerColor = ThemeColors.greenPrimary.copy(alpha = 0.7f),
									contentColor = ThemeColors.white
								)
				) {
					Text(
						text = "OK",
						color = ThemeColors.white,
						style = Typography.pixelCardTitle()
					)
				}
			}
		}
	)
}
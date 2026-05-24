package com.example.pokedex.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.local
import pokedex.composeapp.generated.resources.pokebola

@Composable
fun CaptureLocationDialog(
    location: String,
    onLocationChange: (String) -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Diálogo para inserir a localização onde o Pokémon foi encontrado
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text      = "Capture Location",
                color     = ThemeColors.deepGreen,
                style     = Typography.pixelCardTitle(),
                fontSize  = 18.sp,
                modifier  = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        text = {
            Column(
                modifier            = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    painter            = painterResource(Res.drawable.local),
                    contentDescription = "Capture",
                    modifier           = Modifier.size(200.dp)
                )
                
                Text(
                    text      = "Where did you find this Pokémon?",
                    color     = ThemeColors.deepGreen,
                    textAlign = TextAlign.Center,
                    style     = Typography.descriptionText
                )
                
                OutlinedTextField(
                    value         = location,
                    onValueChange = onLocationChange,
                    placeholder   = { Text("Ex: Route 1, Viridian Forest...", color = Color.Gray.copy(alpha = 0.6f)) },
                    modifier      = Modifier.fillMaxWidth(),
                    shape         = RoundedCornerShape(16.dp),
                    colors        = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor   = ThemeColors.deepGreen,
                        unfocusedBorderColor = ThemeColors.deepGreen.copy(alpha = 0.5f),
                        cursorColor          = ThemeColors.deepGreen,
                        focusedTextColor     = ThemeColors.deepGreen,
                        unfocusedTextColor   = ThemeColors.deepGreen
                    ),
                    singleLine = true
                )
            }
        },
        confirmButton = {
            Column(
                modifier            = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Botão de confirmar para salvar a localização
                Button(
                    // Chama a função de confirmação ao clicar
                    onClick  = onConfirm,
                    // Habilita o botão apenas se a localização não estiver vazia
                    enabled  = location.isNotBlank(),
                    shape    = RoundedCornerShape(999.dp),
                    modifier = Modifier.widthIn(min = 150.dp),
                    colors   = ButtonDefaults.buttonColors(
                        containerColor         = ThemeColors.greenPrimary.copy(alpha = 0.7f),
                        contentColor           = ThemeColors.white,
                        disabledContainerColor = Color.Gray.copy(alpha = 0.3f)
                    )
                ) {
                    Text(
                        text  = "SAVE TO TEAM",
                        color = ThemeColors.white,
                        style = Typography.pixelCardTitle()
                    )
                }
                // Botão de cancelar para fechar o diálogo sem salvar
                TextButton(onClick = onDismiss) {
                    Text(
                        text     = "CANCEL",
                        color    = Color.Gray,
                        style    = Typography.pixelCardTitle(),
                        fontSize = 12.sp
                    )
                }
            }
        }
    )
}
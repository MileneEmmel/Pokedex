package com.example.pokedex.ui.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.permission.PermissionStatus
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.local

@Composable
fun CaptureLocationDialog(
    latitude: Double? = null,
    longitude: Double? = null,
    permissionStatus: PermissionStatus = PermissionStatus.NOT_DETERMINED,
    isLoadingLocation: Boolean = false,
    onRequestLocationPermission: () -> Unit = {},
    onOpenSettings: () -> Unit = {},
    onConfirm: (Double?, Double?) -> Unit,
    onDismiss: () -> Unit,
    photoPath: String? = null,
    onTakePhoto: () -> Unit = {},
    modifier: Modifier = Modifier
) {
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
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(4.dp, ThemeColors.deepGreen, RoundedCornerShape(16.dp))
                        .background(ThemeColors.iceGreen)
                ) {
                    if (photoPath != null) {
                        AsyncImage(
                            model = photoPath,
                            contentDescription = "Captured photo",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter            = painterResource(Res.drawable.local),
                            contentDescription = "Capture placeholder",
                            modifier           = Modifier.fillMaxSize().padding(32.dp)
                        )
                    }
                }

                Text(
                    text      = "Where did you find this Pokemon?",
                    color     = ThemeColors.deepGreen,
                    textAlign = TextAlign.Center,
                    style     = Typography.descriptionText
                )

                // GPS: loading, coordinates, permission request, or settings fallback
                if (isLoadingLocation) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = ThemeColors.greenPrimary,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Getting location...",
                            color = ThemeColors.deepGreen.copy(alpha = 0.7f),
                            fontSize = 12.sp,
                            style = Typography.descriptionText
                        )
                    }
                } else if (permissionStatus == PermissionStatus.GRANTED && latitude != null && longitude != null) {
                    Surface(
                        color = ThemeColors.iceGreen.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "Lat: $latitude\nLng: $longitude",
                            color = ThemeColors.deepGreen,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold,
                            style = Typography.descriptionText,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                } else if (permissionStatus == PermissionStatus.DENIED_ALWAYS) {
                    TextButton(onClick = onOpenSettings) {
                        Text("Enable Location in Settings", color = Color.Red, fontSize = 12.sp)
                    }
                } else {
                    Button(
                        onClick = onRequestLocationPermission,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ThemeColors.greenPrimary,
                            contentColor = ThemeColors.white
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Use My Location (GPS)")
                    }
                }

                if (photoPath != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Photo captured!",
                            color = ThemeColors.deepGreen,
                            style = Typography.descriptionText
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = onTakePhoto) {
                            Text("Retake", color = ThemeColors.deepGreen.copy(alpha = 0.7f), fontSize = 12.sp)
                        }
                    }
                } else {
                    Button(
                        onClick = onTakePhoto,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ThemeColors.greenPrimary,
                            contentColor = ThemeColors.white
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Take a Photo")
                    }
                }
            }
        },
        confirmButton = {
            Column(
                modifier            = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick  = { onConfirm(latitude, longitude) },
                    enabled  = latitude != null && longitude != null && photoPath != null,
                    shape    = RoundedCornerShape(999.dp),
                    modifier = Modifier.widthIn(min = 150.dp),
                    colors   = ButtonDefaults.buttonColors(
                        containerColor = ThemeColors.greenPrimary.copy(alpha = 0.7f),
                        contentColor   = ThemeColors.white,
                        disabledContainerColor = Color.Gray.copy(alpha = 0.3f)
                    )
                ) {
                    Text(
                        text  = "SAVE TO TEAM",
                        color = ThemeColors.white,
                        style = Typography.pixelCardTitle()
                    )
                }
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

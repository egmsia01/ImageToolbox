/*
 * ImageToolbox is an image editor for android
 * Copyright (c) 2024 T8RIN (Malik Mukhametzyanov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * You should have received a copy of the Apache License
 * along with this program.  If not, see <http://www.apache.org/licenses/LICENSE-2.0>.
 */

package ru.tech.imageresizershrinker.feature.bytes_resize.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.tech.imageresizershrinker.core.domain.model.ImageFormat
import ru.tech.imageresizershrinker.core.resources.R
import ru.tech.imageresizershrinker.core.ui.widget.utils.LocalSettingsState

@Composable
fun ImageFormatAlert(format: ImageFormat) {
    val settingsState = LocalSettingsState.current
    AnimatedVisibility(
        visible = !format.canChangeCompressionValue,
        enter = scaleIn() + fadeIn(),
        exit = scaleOut() + fadeOut()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer.copy(
                    alpha = 0.7f
                ),
                contentColor = MaterialTheme.colorScheme.onErrorContainer
            ),
            modifier = Modifier
                .padding(16.dp)
                .border(
                    settingsState.borderWidth,
                    MaterialTheme.colorScheme.onErrorContainer.copy(
                        0.4f
                    ),
                    RoundedCornerShape(24.dp)
                ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = stringResource(R.string.warning_bytes, format.title),
                fontSize = 12.sp,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 14.sp,
                color = LocalContentColor.current.copy(alpha = 0.5f)
            )
        }
    }
}
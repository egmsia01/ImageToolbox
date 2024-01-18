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

package ru.tech.imageresizershrinker.feature.limits_resize.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.tech.imageresizershrinker.core.domain.model.ResizeType
import ru.tech.imageresizershrinker.core.resources.R
import ru.tech.imageresizershrinker.core.ui.widget.buttons.ToggleGroupButton
import ru.tech.imageresizershrinker.core.ui.widget.modifier.container

@Composable
fun LimitsResizeSelector(
    enabled: Boolean,
    value: ResizeType.Limits,
    onValueChange: (ResizeType.Limits) -> Unit
) {
    ToggleGroupButton(
        modifier = Modifier
            .container(shape = RoundedCornerShape(24.dp))
            .padding(start = 3.dp, end = 2.dp),
        enabled = enabled,
        title = {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.fallback_option),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        },
        items = listOf(
            stringResource(R.string.skip),
            stringResource(R.string.recode),
            stringResource(R.string.zoom)
        ),
        selectedIndex = when (value) {
            is ResizeType.Limits.Skip -> 0
            is ResizeType.Limits.Recode -> 1
            is ResizeType.Limits.Zoom -> 2
        },
        indexChanged = {
            onValueChange(
                when (it) {
                    0 -> ResizeType.Limits.Skip(value.autoRotateLimitBox)
                    1 -> ResizeType.Limits.Recode(value.autoRotateLimitBox)
                    else -> ResizeType.Limits.Zoom(value.autoRotateLimitBox)
                }
            )
        }
    )
}
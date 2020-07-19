/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.foundation.samples

import androidx.annotation.Sampled
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.compose.foundation.Canvas
import androidx.ui.geometry.Offset
import androidx.ui.graphics.Color
import androidx.ui.graphics.drawscope.inset
import androidx.compose.foundation.layout.preferredSize
import androidx.ui.unit.dp

@Sampled
@Composable
fun CanvasSample() {
    Canvas(modifier = Modifier.preferredSize(100.dp)) {
        drawRect(Color.Magenta)
        inset(10.0f) {
            drawLine(
                color = Color.Red,
                start = Offset.Zero,
                end = Offset(size.width, size.height),
                strokeWidth = 5.0f
            )
        }
    }
}

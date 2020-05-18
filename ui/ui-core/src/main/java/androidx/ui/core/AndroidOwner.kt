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

package androidx.ui.core

import android.view.View
import androidx.annotation.RestrictTo
import org.jetbrains.annotations.TestOnly

/**
 * Interface to be implemented by [Owner]s able to handle Android View specific functionality.
 */
interface AndroidOwner : Owner {

    /**
     * The view backing this Owner.
     */
    val view: View

    /**
     * Called to inform the owner that a new Android [View] was [attached][Owner.onAttach]
     * to the hierarchy.
     */
    fun addAndroidView(view: View, layoutNode: LayoutNode)

    /**
     * Called to inform the owner that an Android [View] was [detached][Owner.onDetach]
     * from the hierarchy.
     */
    fun removeAndroidView(view: View)

    /** @suppress */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    companion object {
        /**
         * Called after an [AndroidOwner] is created. Used by AndroidComposeTestRule to keep
         * track of all attached [AndroidComposeView]s. Not to be set or used by any other
         * component.
         */
        var onAndroidOwnerCreatedCallback: ((AndroidOwner) -> Unit)? = null
            @TestOnly
            set
    }
}

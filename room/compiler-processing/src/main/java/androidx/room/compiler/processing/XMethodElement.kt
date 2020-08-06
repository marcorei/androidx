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

package androidx.room.compiler.processing

/**
 * Represents a method in a class / interface.
 *
 * @see XConstructorElement
 * @see XMethodElement
 */
interface XMethodElement : XExecutableElement {
    /**
     * The return type for the method. Note that it might be [XType.isNone] if it does not return or
     * [XType.isError] if the return type cannot be resolved.
     */
    val returnType: XType

    /**
     * The type representation of the method where more type parameters might be resolved.
     */
    val executableType: XMethodType

    /**
     * Returns true if this method has the default modifier.
     *
     * @see [findKotlinDefaultImpl]
     */
    fun isJavaDefault(): Boolean

    /**
     * Returns the method as if it is declared in [other].
     *
     * This is specifically useful if you have a method that has type arguments and there is a
     * subclass ([other]) where type arguments are specified to actual types.
     */
    fun asMemberOf(other: XDeclaredType): XMethodType

    /**
     * Returns the default implementation generated by the Kotlin compiler for interfaces.
     *
     * To support default methods in interfaces, Kotlin generates a delegate implementation and this
     * function returns that default implementation if it exists.
     */
    fun findKotlinDefaultImpl(): XMethodElement?

    /**
     * Returns true if this is a suspend function.
     *
     * @see XMethodType.getSuspendFunctionReturnType
     */
    fun isSuspendFunction(): Boolean

    /**
     * Returns true if this method can be overridden without checking its enclosing [XElement].
     */
    fun isOverrideableIgnoringContainer(): Boolean {
        return !isFinal() && !isPrivate() && !isStatic()
    }
}
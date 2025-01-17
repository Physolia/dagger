/*
 * Copyright (C) 2022 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.hilt.android.plugin.util

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationParameters
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.Component
import java.io.File
import org.gradle.api.Project

internal class ComponentCompatApi71Impl(private val component: Component) : ComponentCompat() {

  override val name: String
    get() = component.name

  override fun <ParamT : InstrumentationParameters> transformClassesWith(
    classVisitorFactoryImplClass: Class<out AsmClassVisitorFactory<ParamT>>,
    scope: InstrumentationScope,
    instrumentationParamsConfig: (ParamT) -> Unit
  ) {
    component.transformClassesWith(classVisitorFactoryImplClass, scope, instrumentationParamsConfig)
  }

  override fun setAsmFramesComputationMode(mode: FramesComputationMode) {
    component.setAsmFramesComputationMode(mode)
  }

  override fun getJavaCompileClassesDir(project: Project): File =
    project.layout.buildDirectory.dir("intermediates/javac/${component.name}/classes").get().asFile
}

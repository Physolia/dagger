/*
 * Copyright (C) 2023 The Dagger Authors.
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

package dagger.hilt.viewmodel;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

/** The main activity of the application. */
@AndroidEntryPoint
public class SimpleActivity extends AppCompatActivity {
  private static final String TAG = SimpleActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SimpleViewModel viewModel = new ViewModelProvider(this).get(SimpleViewModel.class);

    setContentView(R.layout.activity_main);

    ((TextView) findViewById(R.id.greeting))
        .setText(getResources().getString(R.string.welcome, viewModel.userName));
  }
}

/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        MaterialTheme {
            DogList(
                listOf(
                    Dog("teddy", 5, "medium", imageRes = R.drawable.dog1),
                    Dog("mary", 3, "medium", imageRes = R.drawable.dog2),
                    Dog("paul", 1, "medium", imageRes = R.drawable.dog3),
                    Dog("paul", 1, "medium", imageRes = R.drawable.dog4),
                    Dog("paul", 10, "large", imageRes = R.drawable.dog5),
                    Dog("paul", 7, "medium", imageRes = R.drawable.dog6),
                    Dog("paul", 3, "medium", imageRes = R.drawable.dog7),
                    Dog("paul", 2, "medium", imageRes = R.drawable.dog8),
                    Dog("paul", 15, "medium", imageRes = R.drawable.dog9),
                    Dog("paul", 1, "small", imageRes = R.drawable.dog10),
                )
            )
        }
    }
}

@Composable
fun DogList(dogs: List<Dog>) {
    LazyColumn {
        items(items = dogs) { dog ->
            DogInfo(dog)
            Divider(color = Color.Black, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp))
        }
    }
}

@Composable
fun DogInfo(dog: Dog) {
    Column(modifier = Modifier.padding(16.dp)) {
        var selected by remember { mutableStateOf(false) }
        Box {
            Image(
                painter = painterResource(id = dog.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            IconButton(onClick = { selected = !selected }) {
                if (selected) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Like button", tint = Color.Red)
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                        "Like button",
                        tint = Color.Red
                    )
                }
            }
        }
        Spacer(Modifier.height(16.dp))

        Text("Name: ${dog.name}", style = typography.h6)
        Text("Age: ${dog.age}", style = typography.body2)
        Text("Size: ${dog.size}", style = typography.body2)

    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

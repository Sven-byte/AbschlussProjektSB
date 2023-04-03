package com.example.abschlussprojektsb.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.abschlussprojektsb.LoadingText
import com.example.abschlussprojektsb.network.NetworkService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        refreshContent(LoadingText().greet())

        val scope = MainScope()

        scope.launch {
            kotlin.runCatching { NetworkService().login()
            }.onSuccess {
                kotlin.runCatching {
                    NetworkService().getTasks(it.token)
                }.onSuccess {
                    refreshContent(it.toString())
                }.onFailure {
                    refreshContent("Tasks konnten nicht geladen werden.")
                }
            }.onFailure {
                refreshContent("Login fehlgeschlagen.")
            }
        }
    }






    private fun refreshContent(displayedText: String) {
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(displayedText)

                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}

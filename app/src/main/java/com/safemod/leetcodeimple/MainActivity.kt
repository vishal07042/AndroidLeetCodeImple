package com.safemod.leetcodeimple

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safemod.leetcodeimple.ui.theme.LeetCodeImpleTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeetCodeImpleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    Spacer(modifier = Modifier.padding(30.dp))
                    SelectQuestion()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}





@Composable
fun SelectQuestion() {
    var noOfQuestions by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(start = 20.dp ,top=100.dp)) {
        OutlinedTextField(
            value = noOfQuestions,
            onValueChange = { input ->
                if (input.all { it.isDigit() } || input.isEmpty()) {
                    noOfQuestions = input
                }
            },
            label = { Text("No of Questions") }
        )

        val questionCount = noOfQuestions.toIntOrNull() ?: 0


        Log.d("questionType", "questionCount: $questionCount, type: ${questionCount::class.simpleName}")

        Text(text = "Number of questions: $questionCount")

        if(noOfQuestions> 1.toString()){
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LeetCodeImpleTheme {
        Greeting("Android")
    }
}


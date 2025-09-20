package com.coolsharp.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.coolsharp.list.ui.theme.ListTheme

class MainActivity : ComponentActivity() {
    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        activity = this
                    )
                }
            }
        }

        backPressed()
    }

    private fun backPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - backPressedTime >= 2000) {
                    backPressedTime = System.currentTimeMillis()
                    Toast.makeText(this@MainActivity, "뒤로 버튼을 한번 더 누르면 앱을 종료합니다.", Toast.LENGTH_SHORT).show()
                } else if (System.currentTimeMillis() - backPressedTime < 2000) {
                    finish()
                }
            }
        }

        this.onBackPressedDispatcher.addCallback(this, callback)
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier, activity: MainActivity) {
    Column(modifier = modifier
        .background(Color.White)) {
        ActivityHeader(activity = activity)
//        FilterButton()
//        Sort()
//        ProductScreen()
        CategoryScreen()
    }
}
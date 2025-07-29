package com.coolsharp.list

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActivityHeader(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* 클릭 동작 */ }, modifier = Modifier.size(48.dp) // 버튼 크기 조정
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "닫기버튼"
            )
        }
        Text(
            text = "Headphones",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        IconButton(
            onClick = { /* 클릭 동작 */ }, modifier = Modifier.size(48.dp) // 버튼 크기 조정
        ) {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = "검색버튼"
            )
        }
    }
}

@Composable
fun FilterButton(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { /* 버튼 클릭 동작 */ },
            shape = RoundedCornerShape(8.dp), // 모서리 둥글기 정도 설정
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray, // 버튼 배경색
                contentColor = Color.White // 텍스트/아이콘 색상
            ),
            contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
            modifier = Modifier
                .padding(8.dp) // 외부 패딩 조정
                .height(32.dp)
                .width(32.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        MakeButton("Category")
        MakeButton("Brand")
        MakeButton("Price")
    }
}

@Composable
fun MakeButton(title: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* 버튼 클릭 동작 */ },
        shape = RoundedCornerShape(8.dp), // 모서리 둥글기 정도 설정
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray, // 버튼 배경색
            contentColor = Color.White // 텍스트/아이콘 색상
        ),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp),
        modifier = Modifier
            .padding(8.dp) // 외부 패딩 조정
            .height(32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier.width(8.dp))
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = title,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
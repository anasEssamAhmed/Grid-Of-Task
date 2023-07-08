package com.example.gridoflist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridoflist.Datasource.ListOfTask
import com.example.gridoflist.model.task
import com.example.gridoflist.ui.theme.GridOfListTheme
import com.example.gridoflist.ui.theme.PurpleGrey40
import com.example.gridoflist.ui.theme.PurpleGrey80
import com.example.gridoflist.ui.theme.colorText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridOfListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskGrid()
                }
            }
        }
    }
}

@Composable
fun CardOfItem(task: task) {
    Row(
        modifier = Modifier
            .wrapContentSize(align = Alignment.TopStart)
            .width(220.dp)
            .padding(10.dp)
            .background(
                color = PurpleGrey80,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Image(
            painter = painterResource(task.Image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(68.dp)
                .clip(shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
        )
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 5.dp)
        ) {
            Text(
                text = stringResource(task.text),
                style = MaterialTheme.typography.bodyMedium,
                color = colorText,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_grain),
                    contentDescription = null,
                )
                Text(
                    text = "${task.number}",
                    style = MaterialTheme.typography.labelMedium,
                    color = colorText,
                    modifier = Modifier.padding(start = 8.dp, top = 3.dp)
                )
            }
        }

    }
}

@Composable
fun TaskGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(ListOfTask().loadOfTask()) {
            CardOfItem(it)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GridOfListTheme {
        TaskGrid()
    }
}
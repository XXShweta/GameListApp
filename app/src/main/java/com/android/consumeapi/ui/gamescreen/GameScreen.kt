package com.android.consumeapi.ui.gamescreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.consumeapi.domain.model.GameItem
import com.android.consumeapi.ui.theme.ConsumeApiTheme
import com.android.consumeapi.util.Resource
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GameScreen(){
    val viewModel = viewModel(modelClass = GameViewModel::class.java)
    when(val state = viewModel.gameItems.collectAsState().value){
        is Resource.Error -> {
            Toast.makeText(LocalContext.current,state.errorMessage, Toast.LENGTH_LONG).show()
        }
        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
                ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
        is Resource.Success -> {
            state.data?.let { games ->
                LazyColumn{
                    items(games){
                        GameCard(it)
                    }
                }
            }

        }
    }

}

@Composable
fun GameCard(gameItem: GameItem){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        Column {
            GlideImage(
                imageModel = {gameItem.thumbnail},
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                modifier = Modifier.fillMaxWidth().height(250.dp),
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            )
            Column(modifier = Modifier.padding(10.dp)) {

                Text(text = gameItem.title, fontWeight = FontWeight.Bold)
                Text(text = gameItem.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    ConsumeApiTheme {
        GameScreen()
    }
}

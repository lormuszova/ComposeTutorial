package com.example.composetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.safeDrawing,
                    floatingActionButton = {
                        NextButton(
                            onClick = { startComposeQuadrantActivity() },
                            modifier = Modifier
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .consumeWindowInsets(padding)
                    ) {
                        TutorialImage(modifier = Modifier)
                        TutorialText(modifier = Modifier)
                    }
                }
            }
        }
    }

    private fun startComposeQuadrantActivity() {
        startActivity(Intent(this, ComposeQuadrantActivity::class.java))
    }
}

@Composable
fun TutorialText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_tutorial),
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
    Text(
        text = stringResource(R.string.introduction),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
    )
    Text(
        text = stringResource(R.string.tutorial_description),
        textAlign = TextAlign.Justify,
        modifier = modifier.padding(16.dp)
    )
    Divider(
        modifier = modifier.padding(horizontal = 30.dp, vertical = 30.dp),
        thickness = 1.dp
    )
}

@Composable
fun NextButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon =  { Icon(Icons.Default.ArrowForward, "Next") },
        text = {
            Text(
                text = stringResource(R.string.next),
                fontSize = 24.sp,
                modifier = modifier.padding(16.dp)
            )
        }
    )
}

@Composable
fun TutorialImage(modifier: Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = "Compose Tutorial Image",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TutorialPreview() {
    ComposeTutorialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                TutorialImage(modifier = Modifier)
                TutorialText(modifier = Modifier)
            }
        }
    }
}
package com.example.composetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeQuadrantActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                contentWindowInsets = WindowInsets.safeDrawing,
                floatingActionButton = {
                    DoneButton(
                        onClick = { startFinalActivity() },
                        modifier = Modifier
                    )
                },
                floatingActionButtonPosition = FabPosition.End
            ) { padding ->
                Column(
                    modifier = Modifier.fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .consumeWindowInsets(padding)
                ) {
                    Row(
                        modifier = Modifier.weight(1f, true)
                    ) {
                        TextQuadrant(modifier = Modifier.weight(1f, true))
                        ImageQuadrant(modifier = Modifier.weight(1f, true))
                    }
                    Row(modifier = Modifier.weight(1f, true)) {
                        RowQuadrant(modifier = Modifier.weight(1f, true))
                        ColumnQuadrant(modifier = Modifier.weight(1f, true))
                    }


                }


            }


        }

    }

    private fun startFinalActivity() {
        startActivity(Intent(this, FinalActivity::class.java))
    }


    @Composable
    fun TextQuadrant(modifier: Modifier) {
        Quadrant(
            modifier = modifier,
            title = "Text composable",
            subtitle = "Displays text and follows the recommended Material Design guidelines.",
            color = Color(0xFFEADDFF)
        )
    }

    @Composable
    fun ImageQuadrant(modifier: Modifier) {
        Quadrant(
            modifier = modifier,
            title = "Image composable",
            subtitle = "Creates a composable that lays out and draws a given Painter class object.",
            color = Color(0xFFD0BCFF)
        )
    }

    @Composable
    fun RowQuadrant(modifier: Modifier) {
        Quadrant(
            modifier = modifier,
            title = "Row composable",
            subtitle = "A layout composable that places its children in a horizontal sequence.",
            color = Color(0xFFB69DF8)
        )
    }

    @Composable
    fun ColumnQuadrant(modifier: Modifier) {
        Quadrant(
            modifier = modifier,
            title = "Column composable",
            subtitle = "A layout composable that places its children in a vertical sequence.",
            color = Color(0xFFF6EDFF)
        )
    }

    @Composable
    fun Quadrant(modifier: Modifier = Modifier, title: String, subtitle: String, color: Color) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = color)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = subtitle,
                textAlign = TextAlign.Justify
            )
        }
    }

    @Composable
    fun DoneButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
        ExtendedFloatingActionButton(
            onClick = onClick,
            icon = { Icon(Icons.Default.Done, "Done") },
            text = {
                Text(
                    text = stringResource(R.string.done),
                    fontSize = 24.sp,
                    modifier = modifier.padding(16.dp)
                )
            },
            expanded = true,
        )
    }

    @Preview
    @Composable
    fun ComposeQuadrantPreview() {
        ComposeTutorialTheme {

            Column(Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.weight(1f, true)
                ) {
                    TextQuadrant(modifier = Modifier.weight(1f, true))
                    ImageQuadrant(modifier = Modifier.weight(1f, true))
                }
                Row(modifier = Modifier.weight(1f, true)) {
                    RowQuadrant(modifier = Modifier.weight(1f, true))
                    ColumnQuadrant(modifier = Modifier.weight(1f, true))
                }

            }
        }
    }
}
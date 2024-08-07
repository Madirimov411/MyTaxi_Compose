package com.uzb7.mytaxi

import android.view.animation.Animation
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Animation1(modifier: Modifier = Modifier) {
    var buttonsVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { buttonsVisible = !buttonsVisible },
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = buttonsVisible,
            enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {}) {
                    Text(text = "Button 1")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {}) {
                    Text("Button 2")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {}) {
                    Text("Button 3")
                }
            }
        }
    }

}

@Composable
fun Animation(
    modifier: Modifier = Modifier,
    direction: Int,
    visible: Boolean,
    content: @Composable()  AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(initialOffsetX = { direction * it }) + fadeIn(),
        exit = slideOutHorizontally(targetOffsetX = { direction * it }) + fadeOut()
    ) {
        content()
    }


}
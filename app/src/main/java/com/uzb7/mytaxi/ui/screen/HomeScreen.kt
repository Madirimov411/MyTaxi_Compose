package com.uzb7.mytaxi.ui.screen

import android.view.animation.Animation
import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb7.mytaxi.Animation
import com.uzb7.mytaxi.R
import com.uzb7.mytaxi.ui.theme.app_theme.appColors
import com.uzb7.mytaxi.ui.views.BottomSheetView
import com.uzb7.mytaxi.ui.views.ToggleButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var iconVisible by rememberSaveable {
        mutableStateOf(true)
    }

    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                iconVisible = !iconVisible
            }
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background"
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(MaterialTheme.appColors.mainBgColor)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                iconVisible = !iconVisible
                            }
                            .padding(16.dp),
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "Menu",
                        tint = MaterialTheme.appColors.mainTextColor
                    )

                    ToggleButton(
                        modifier = Modifier.weight(1f),
                        onDetect = {
                            if (it)
                                iconVisible = !iconVisible
                        }
                    )

                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(MaterialTheme.appColors.mainBgColor)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                iconVisible = !iconVisible
                            },
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .background(
                                    MaterialTheme.appColors.mainColor,
                                    shape = RoundedCornerShape(10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "95",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(Font(R.font.lato_bold)),
                                    color = Color(0xFF121212),
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }


                    }


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { iconVisible = !iconVisible },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Animation(direction = 1, visible = iconVisible) {

                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(MaterialTheme.appColors.mainBgColor)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) {
                                    iconVisible = false
                                }
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(MaterialTheme.appColors.leftIconBack)
                                    .padding(12.dp),
                                painter = painterResource(id = R.drawable.ic_inner),
                                contentDescription = "Menu",
                                tint = MaterialTheme.appColors.leftIconTint
                            )

                        }
                    }

                    Animation(direction = -1, visible = iconVisible) {

                        Column(
                            modifier = Modifier.clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                iconVisible = false
                            },
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {

                            Icon(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(MaterialTheme.appColors.mainBgColor)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) {
                                        iconVisible = false
                                    }
                                    .padding(20.dp),
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = "Menu",
                                tint = MaterialTheme.appColors.leftIconTint
                            )

                            Icon(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(MaterialTheme.appColors.mainBgColor)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) {
                                        iconVisible = false
                                    }
                                    .padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_minus),
                                contentDescription = "Menu",
                                tint = MaterialTheme.appColors.leftIconTint
                            )

                            Icon(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(MaterialTheme.appColors.mainBgColor)
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) {
                                        iconVisible = false
                                    }
                                    .padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_send),
                                contentDescription = "Menu",
                                tint = Color(0xFF4A91FB)
                            )

                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(56.dp))

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(202.dp),
                contentAlignment = Alignment.BottomCenter
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(if (iconVisible) 132.dp else 202.dp)
                        .animateContentSize()
                        .background(Color.Transparent)
                        .clickable { iconVisible = !iconVisible }
                ){
                    BottomSheetView()
                }
            }

        }



    }

}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
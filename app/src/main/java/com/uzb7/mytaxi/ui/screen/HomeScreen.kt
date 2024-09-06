package com.uzb7.mytaxi.ui.screen


import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb7.mytaxi.Animation
import com.uzb7.mytaxi.R
import com.uzb7.mytaxi.ui.theme.app_theme.appColors
import com.uzb7.mytaxi.ui.views.BottomSheetView
import com.uzb7.mytaxi.ui.views.ToggleButton
import kotlinx.coroutines.launch

enum class BottomSheetValue { Collapsed, Expanded }


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var iconVisible by rememberSaveable {
        mutableStateOf(true)
    }


    val bottomSheetState = rememberStandardBottomSheetState(initialValue = SheetValue.PartiallyExpanded)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    val scope = rememberCoroutineScope()

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

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                BottomSheetView()
            },
            sheetPeekHeight = 132.dp,
            sheetDragHandle = {}
        ) {


            Spacer(modifier = Modifier.height(56.dp))


//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(16.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Button(onClick = {
//                        if (bottomSheetState.isCollapsed) {
//                            bottomSheetState.expand()
//                        } else {
//                            bottomSheetState.collapse()
//                        }
//                    }) {
//                        Text(text = "Toggle BottomSheet")
//                    }
//                }

            if(!iconVisible){
                scope.launch {
                    bottomSheetState.expand()
                }
            }else{
                scope.launch {
                    bottomSheetState.partialExpand()
                }
            }

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop
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
                        .padding(start = 16.dp, end = 16.dp, bottom = 300.dp)
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

            }
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(202.dp),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(if (iconVisible) 132.dp else 202.dp)
//                        .animateContentSize()
//                        .background(Color.Transparent)
//                        .clickable { iconVisible = !iconVisible }
//                ) {
//                    BottomSheetView()
//                }
//            }


        }


    }

}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
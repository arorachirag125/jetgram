package com.example.instagramprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profilescreen(){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
            TopBar(name = "chirag125_official", modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(10.dp))
            ProfileSection()
            Spacer(modifier = Modifier.height(25.dp))
            ButtonSection(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(25.dp))
            HighLightSection(highlights = listOf(
                ImageWithText(image = painterResource(id = R.drawable.bellicon),
                text = "Subscribe"),
                ImageWithText(image = painterResource(id = R.drawable.playicon),
                    text = "Youtube"),
                ImageWithText(image = painterResource(id = R.drawable.videocam),
                    text = "videos"),
                ImageWithText(image = painterResource(id = R.drawable.headphone),
                    text = "Spotify"),
                        ImageWithText(image = painterResource(id = R.drawable.chirag),
                text = "memeories")


            ), modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp))
            Spacer(modifier = Modifier.height(15.dp))
            PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.post),
                        text = "post"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.reel),
                        text = "post"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.live),
                        text = "post"
                    ),
                )
            ){
                selectedTabIndex=it
            }
           when(selectedTabIndex){
               0 -> PostSection(
                   posts = listOf(
                       painterResource(id = R.drawable.pic1),
                       painterResource(id = R.drawable.pic2),
                       painterResource(id = R.drawable.pic3),
                       painterResource(id = R.drawable.chirag)
                   ), modifier = Modifier.fillMaxWidth()
               )
           }
           when(selectedTabIndex){
               1-> ReelsSection()
           }
        when(selectedTabIndex){
            2-> TagSection()
        }




    }
}

@Composable
fun TopBar(
    name:String,
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,

         modifier = modifier
             .fillMaxWidth()
             .padding(top = 10.dp)

    ) {
        Icon(imageVector = Icons.Default.ArrowBack,
            contentDescription = "arrowback",
            tint = Color.Black,
            modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(30.dp))

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.width(60.dp))
        Image(painter = painterResource(id = R.drawable.bellicon),
            contentDescription ="bellicon",
            modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.width(30.dp))

        Image(painter = painterResource(id = R.drawable.dot),
            contentDescription ="menudot",
            modifier = Modifier.size(20.dp))
    }
}
@Composable
fun ProfileSection(
    modifier: Modifier=Modifier
){
   Column(
       modifier = modifier.fillMaxWidth()
   ) {
      Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 10.dp)
      ) {
           RoundImage(image = painterResource(id = R.drawable.chirag),
           modifier= modifier
               .size(100.dp)
               .clickable {

               }
               .weight(3f))
           Spacer(modifier = Modifier.width(16.dp))
           StateSection(modifier=Modifier.weight(7f))

      }
       Spacer(modifier = Modifier.height(8.dp))

       Text(text = "ANDROID DEVELOPER", modifier = Modifier.padding(horizontal = 10.dp),
                    fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.Black)
       Spacer(modifier = Modifier.height(2.dp))

       Text(text = "Takes candid all over the world",
                    modifier = Modifier.padding(horizontal = 8.dp), fontSize = 13.sp,
                                          color = Color.Black,fontWeight = FontWeight.Bold)
       Spacer(modifier = Modifier.height(2.dp))

       Text(text = "Wish me on 22nd april !",
           modifier = Modifier.padding(horizontal = 8.dp), fontSize = 13.sp,
           color = Color.Black, fontWeight = FontWeight.Bold)
       Spacer(modifier = Modifier.height(2.dp))

       Text(text ="https://www.linkedin.com/in/chirag-arora-5a8706206",
           modifier = Modifier.padding(horizontal = 8.dp), fontSize = 13.sp,
           color = Color.Blue,fontWeight = FontWeight.Bold)
       Spacer(modifier = Modifier.height(2.dp))
       Row() {
           Text(
               text = "Followed by",
               modifier = Modifier.padding(horizontal = 8.dp),
               fontSize = 13.sp,
               color = Color.Black
           )
           Text(
               text = "himanshu,codingblocks and 10 others",
               modifier = Modifier.padding(horizontal = 8.dp),
               fontSize = 13.sp,
               color = Color.Black,
               fontWeight = FontWeight.Bold
           )
       }

   }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier=Modifier,
){
    Image(painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(CircleShape)

    )
}

@Composable
fun StateSection(
    modifier: Modifier=Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "45", text = "Posts")
        ProfileStat(numberText = "1.5k", text = "Followers")
        ProfileStat(numberText = "393", text = "Following")

    }

}

@Composable
fun ProfileStat(
    numberText: String,
    text:String,
    modifier: Modifier=Modifier
){
   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = modifier
   ) {
      Text(text = numberText,
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp)

       Spacer(modifier = Modifier.height(4.dp))

       Text(text = text)

   }
}

@Composable
fun ButtonSection(
    modifier: Modifier=Modifier
){
    val minwidth=95.dp
    val height=30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier=modifier
    ) {
         ActionButton(
             text = "Follow",
             icon = Icons.Default.KeyboardArrowDown,
             modifier = Modifier
                 .defaultMinSize(minWidth = minwidth)
                 .height(height = height)
         )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height = height)
        )

        ActionButton(
            icon=Icons.Default.Call,
            modifier = Modifier
                .defaultMinSize(minWidth = minwidth)
                .height(height = height)
        )
    }

}

@Composable
fun ActionButton(
    modifier: Modifier=Modifier,
    text: String?=null,
    icon:ImageVector?=null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(6.dp)
    ) {
        if(text!=null){
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp)
        }
        if(icon!=null){
            Icon(imageVector = icon, contentDescription ="icon" , tint = Color.Black)
        }
    }
}

@Composable
fun HighLightSection(
    modifier: Modifier=Modifier,
    highlights:List<ImageWithText>
){
    LazyRow(modifier = modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
               RoundImage(image = highlights[it].image,
                          modifier = Modifier.size(50.dp))
               Text(text = highlights[it].text,
                   overflow = TextOverflow.Ellipsis,
                   textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier=Modifier,
    imageWithTexts:List<ImageWithText>,
    onTabSelected:(selectedIndex:Int)->Unit
){
   var selectedTabIndex by remember {
       mutableStateOf(0)
   }
   val inactiveColor=Color.Gray
   TabRow(
       selectedTabIndex = selectedTabIndex,
       backgroundColor = Color.Transparent,
       contentColor = Color.Black,
       modifier = modifier
   ) {
       imageWithTexts.forEachIndexed { index, item ->
           Tab(selected = selectedTabIndex==0,
               selectedContentColor = Color.Black,
               unselectedContentColor = inactiveColor,
               onClick = {
                   selectedTabIndex=0
                   onTabSelected(index)
               }) {
               Icon(painter = item.image,
                   contentDescription = item.text,

                   modifier = Modifier
                       .padding(10.dp)
                       .size(20.dp))

           }
       }


   }

}
@Composable
fun PostSection(
    posts:List<Painter>,
    modifier: Modifier=Modifier
){
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier.scale(1.01f
    )){
        items(posts.size){
            Image(painter = posts[it], contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .border(width = 1.dp, color = Color.White))
        }
    }

}
@Composable
fun ReelsSection(
){
    Text(text = "Reels section", modifier = Modifier
        .fillMaxWidth()
        .offset(x = 120.dp, y = 100.dp)
        .size(25.dp))

}

@Composable
fun TagSection(
){
    Text(text = "Tag section", modifier = Modifier
        .fillMaxWidth()
        .offset(x = 130.dp, y = 100.dp)
        .size(25.dp))

}


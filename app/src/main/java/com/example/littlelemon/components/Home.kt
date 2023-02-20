package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.AppDatabase
import com.example.littlelemon.MenuItemRoom
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonGreen
import com.example.littlelemon.ui.theme.LittleLemonWhite
import com.example.littlelemon.ui.theme.Typography

@Composable
fun Home(navController: NavController) {

    val context = LocalContext.current

    val database by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
    }

    val menuDao = database.menuItemDao()

    // add databaseMenuItems code here
    val databaseMenuItems by menuDao.getAll().observeAsState(emptyList())

    var menuItems by remember {mutableStateOf(databaseMenuItems)}

    if (menuItems.isEmpty()){
        menuItems = databaseMenuItems.sortedBy { it.title }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LittleLemonTopAppBar(navController = navController)
        LittleLemonHeroSection(menuItems, onMenuChanged = {menu -> menuItems = menu})

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White))
        {

            Text(modifier = Modifier.padding(start=8.dp, top = 8.dp),
                text = "ORDER FOR DELIVERY !",
                style = Typography.h4
            )

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp)


            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(LittleLemonWhite)
                        ){
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Starter"
                    )
                }

                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(LittleLemonWhite)
                        ){
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Mains"
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(LittleLemonWhite)
                        ){
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Desserts"
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(LittleLemonWhite)
                        ){
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Drinks"
                    )
                }

            }

            Divider()

        }

        MenuItems(menuItems)


    }


}

@Composable
fun LittleLemonTopAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(150.dp, 150.dp)
                )
            }
        },
        actions = {
            Box(modifier = Modifier.size(48.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 8.dp)
                        .clickable { navController.navigate(Profile.route) }

                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 4.dp
    )
}

@Composable
fun LittleLemonHeroSection(menuItems: List<MenuItemRoom>, onMenuChanged: (List<MenuItemRoom>) -> Unit) {

    var search by remember { mutableStateOf("") }

    var menu = menuItems

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonGreen)
    ) {
        Text(
            modifier = Modifier.padding(start = 12.dp, top = 8.dp),
            text = "Little Lemon",
            style = Typography.h1,
        )

        Text(
            modifier = Modifier.padding(start = 12.dp),
            text = "Chicago",
            style = Typography.h2,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.hero_intro),
                style = Typography.body1,
            )

            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = painterResource(id = R.drawable.hero_image),
                contentScale = ContentScale.Crop,
                contentDescription = "Hero Image"
            )
        }

        TextField(
            value = search,
            onValueChange = {
                search = it
                if (search.isBlank()){
                    menu = menuItems.filter { it.title.startsWith(".", ignoreCase = true)  }
                } else {
                    menu = menuItems.filter { it.title.startsWith(search, ignoreCase = true)  }
                }

                onMenuChanged(menu)
                },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(LittleLemonWhite),
            placeholder = {
                Text(
                    text = "Enter search phrase"
                )
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = null,

                    )
            },

            )
    }
}

@Composable
fun MenuItems(menuItems: List<MenuItemRoom>) {

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(
            items = menuItems,
        ) {
                item -> MenuItem(menuItem = item)
                Divider()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(menuItem: MenuItemRoom) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 12.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp),
            style = Typography.h4,
            text = menuItem.title
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 12.dp, top = 4.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                text = menuItem.description,
                style = Typography.body2,
            )

            GlideImage(
                model = menuItem.image,
                contentDescription = "Meal Image",
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 8.dp),
            text = "$${menuItem.price}",
            style = Typography.h5
        )

    }
}


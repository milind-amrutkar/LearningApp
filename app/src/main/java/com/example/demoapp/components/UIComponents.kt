package com.example.demoapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoapp.R
import com.example.demoapp.favoritecity.City
import com.example.demoapp.favoritecity.CityDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextExample() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = stringResource(R.string.sample)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotOutlinedEditTextExample() {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(text = stringResource(id = R.string.sample)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        )

    )
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Icon(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = stringResource(
                id = R.string.sample
            ),
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = stringResource(id = R.string.click_me),
            modifier = Modifier.padding(start = 10.dp)
        )

    }
}

@Composable
fun CornerCutShapeButton() {
    Button(onClick = { }, shape = CutCornerShape(10)) {
        Text(text = stringResource(id = R.string.corner_button))
    }
}

@Composable
fun RoundCornerShapeButton() {
    Button(onClick = {}, shape = RoundedCornerShape(10.dp)) {
        Text(text = stringResource(R.string.rounded))
    }
}

@Composable
fun ElevatedButtonExample() {
    Button(
        onClick = { },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = stringResource(R.string.elevated))
    }
}

@Composable
fun ImageViewExample() {
    Image(
        painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = stringResource(
            R.string.image
        ),
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun UIElementPreview() {
    EditTextExample()
    NotOutlinedEditTextExample()
}

@Preview(showBackground = true)
@Composable
fun CityCardPreview() {
    CityList(cityList = CityDataSource.loadCities())
}

@Composable
fun CityList(cityList: List<City>) {
    LazyColumn {
        items(cityList) { cities ->
            CityCard(city = cities)
        }
    }
}

@Composable
fun CityCard(city: City) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = city.imageResourceId),
                contentDescription = stringResource(
                    id = R.string.app_name
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(154.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(city.nameResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
package uz.khamroev.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.khamroev.R

enum class ServiceType { All, Dentist, Oculist, Pediatrician, Dermatologist, Cardiologist }


val serviceItems = listOf(
    ServiceType.All,
    ServiceType.Dentist,
    ServiceType.Oculist,
    ServiceType.Pediatrician,
    ServiceType.Dermatologist,
    ServiceType.Cardiologist
)
data class Doctor(val name: String, val imageRes: Int, val serviceType: ServiceType)

val doctorList = listOf(
    Doctor("Dr. Smith", R.drawable.ic_launcher_background, ServiceType.Dentist),
    Doctor("Dr. Johnson", R.drawable.ic_launcher_background, ServiceType.Dentist),
    Doctor("Dr. Garcia", R.drawable.ic_launcher_background, ServiceType.Oculist),
    Doctor("Dr. Martinez", R.drawable.ic_launcher_background, ServiceType.Oculist),
    Doctor("Dr. Anderson", R.drawable.ic_launcher_background, ServiceType.Pediatrician),
    Doctor("Dr. Taylor", R.drawable.ic_launcher_background, ServiceType.Pediatrician),
    Doctor("Dr. Thomas", R.drawable.ic_launcher_background, ServiceType.Dermatologist),
    Doctor("Dr. Jackson", R.drawable.ic_launcher_background, ServiceType.Dermatologist),
    Doctor("Dr. White", R.drawable.ic_launcher_background, ServiceType.Cardiologist),
    Doctor("Dr. Harris", R.drawable.ic_launcher_background, ServiceType.Cardiologist)
)



@Composable
fun DoctorList(doctors: List<Doctor>, selectedService: ServiceType?, lazyListState: LazyListState) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = lazyListState
    ) {
        items(doctors) { doctor ->


            if (selectedService == ServiceType.All || doctor.serviceType == selectedService) {
                // Display the doctor if the service matches the selected service or if no service is selected
                // Doctor item with image and name
                DoctorItem(doctor = doctor)
            }
        }
    }
}

@Composable
fun DoctorItem(doctor: Doctor){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = doctor.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = doctor.name, fontSize = 18.sp, color = Color.Black)
    }
}

@Composable
fun HospitalProfile() {

    var selectedService by remember { mutableStateOf<ServiceType?>(ServiceType.All) }
    var lazyListState= rememberLazyListState()
    var isLiked= remember {
        mutableStateOf(false)
    }

    //Keladgan malumotlar
    val clinic_logo=R.drawable.logo
    val clinic_poster=R.drawable.ic_launcher_background
    val clinic_name="Darmon Service"
    val clinic_rating=2.8



    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .background(
                        color = Color.Gray, shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Image(
                    painter = painterResource(id = clinic_poster),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .background(color = Color.LightGray, shape = CircleShape)
                            .clip(CircleShape)
                            .clickable { Log.d("TAG", "Bosildi") }
                        , contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrowback),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment =  Alignment.Center,
                        )
                    }
                    Spacer(modifier = Modifier.width(130.dp))
                    Box(// icon like
                        modifier = Modifier
                            .size(45.dp)
                            .background(color = Color.LightGray, shape = CircleShape)
                            .clip(CircleShape)
                            .clickable {  isLiked.value=!isLiked.value }
                        , contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(if (isLiked.value) R.drawable.ic_like else R.drawable.ic_emptylike,),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment =  Alignment.Center,
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .background(color = Color.LightGray, shape = CircleShape)
                            .clip(CircleShape)
                            .clickable { Log.d("TAG", "Bosildi") }
                        , contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment =  Alignment.Center,
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .background(color = Color.LightGray, shape = CircleShape)
                            .clip(CircleShape)
                            .clickable { Log.d("TAG", "Bosildi") }
                        , contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_share),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            alignment =  Alignment.Center,
                        )
                    }   }


                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, top = 80.dp)) {
                    Image(
                        painter = painterResource(clinic_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(
                            text = clinic_name,
                            color = Color.White,
                            fontSize = 24.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = clinic_rating.toString(),  // rating
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))

                            StarRating(starCount = 5, rating = clinic_rating.toFloat())

                            Spacer(modifier = Modifier.width(4.dp))

                            Row {
                                Icon(imageVector = Icons.Default.Create, contentDescription = null)
                                Text(text = "Add review", fontSize = 20.sp)
                            }



                        }
                    }
            }

        }

            Card(
                Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(32.dp, 32.dp))){
                Spacer(modifier = Modifier.height(4.dp) )
                ServiceList(serviceItems = serviceItems, selectedService = selectedService) {
                    selectedService = it
                }


                DoctorList(doctorList, selectedService, lazyListState)
            }


            
            
    }
}}


@Composable
fun IconWithGrayBackground(iconRes: Int, onClickAction: () -> Unit) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .background(color = Color.LightGray, shape = CircleShape)
            .clip(CircleShape)
            .clickable { onClickAction }
        , contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
           alignment =  Alignment.Center,
        )
    }
}


@Composable
fun StarRating(starCount: Int, rating: Float) {
    val fullStars = rating.toInt()
    val hasHalfStar = rating - fullStars >= 0.5f

    Row {
        repeat(fullStars) {
            Icon(
                painter = painterResource(id = R.drawable.ic_fullstar),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        if (hasHalfStar) {
            Icon(
                painter = painterResource(id = R.drawable.ic_halfstar),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        repeat(starCount - fullStars - if (hasHalfStar) 1 else 0) {
            Icon(
                painter = painterResource(id = R.drawable.ic_emptystar),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }}

@Composable
fun ServiceList(serviceItems: List<ServiceType>, selectedService: ServiceType?, onServiceSelected: (ServiceType) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(serviceItems.size) { index ->
            ServiceItem(
                serviceType = serviceItems[index],
                isSelected = selectedService == serviceItems[index],
                onServiceSelected = onServiceSelected
            )
        }
    }
}
@Composable
fun ServiceItem(serviceType: ServiceType, isSelected: Boolean, onServiceSelected: (ServiceType) -> Unit) {
    val backgroundColor = if (isSelected) Color.Green else Color.White
    val textColor = if (isSelected) Color.White else Color.Green
    val borderStroke = if (!isSelected) BorderStroke(1.dp, Color.Green) else null

    Surface(
        color = backgroundColor,
        border = borderStroke,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onServiceSelected(serviceType) }
            .padding(8.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(4.5.dp)) {
            Text(
                text = serviceType.name,
                color = textColor,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
package uz.khamroev.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.khamroev.R

@SuppressLint("ResourceAsColor")
@Composable
fun BookAppointmentView() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Back button
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(color = Color.Unspecified, shape = CircleShape)
                    .clip(CircleShape)
                    .clickable { Log.d("TAG", "Back button clicked") },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrowback),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                )
            }
            Spacer(modifier = Modifier.width(60.dp))
            Text(
                text = "Book Appointment",
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        DoctorDetails(doc = Doctor("Sattor Khamroev", R.drawable.logo, ServiceType.Dentist))

        // Choose date row with dropdown calendar
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clickable { /* Open calendar */ }
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape),
            )
            Text(text = "Choose date", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 4.dp))
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape),
            )
        }

        // LazyRow displaying the days of the month
        LazyRow(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            // List of days in the month
            val days = (1..30).toList()
            itemsIndexed(days) { index, day ->
                // Create a variable for selected date
                val isSelected = remember { mutableStateOf(false) }

                // Update the isSelected state when a day is clicked
                DayItem(
                    day = day,
                    isSelected = isSelected.value,
                    onClick = { isSelected.value = !isSelected.value }
                )

                Spacer(modifier = Modifier.width(10.dp)) // Add space between items
            }
        }

        TimeSelection()

        Spacer(modifier = Modifier.height(150.dp))

        Button(onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(Color.Green)) {

            Text(modifier = Modifier.padding(4.dp),text = "Make Appointment", fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

        }
    }
}

@Composable
fun DayItem(day: Int, isSelected: Boolean, onClick: () -> Unit) {
    // Determine background color and text color based on selection state
    val backgroundColor = if (isSelected) Color.Green else Color.White
    val textColor = if (isSelected) Color.White else Color.Green

    // Display the day item as a square with rounded corners
    Box(
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        // Display the day number and weekday
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = day.toString(),
                fontSize = 18.sp,
                color = textColor
            )
            Text(
                text = "Monday", // Placeholder for weekday
                fontSize = 14.sp,
                color = textColor
            )
        }
    }
}

@Composable
fun DoctorDetails(doc: Doctor) {
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Image(
            painter = painterResource(doc.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = doc.name,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = doc.serviceType.name,
                fontSize = 22.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                        .clip(CircleShape),
                    tint = Color.Red

                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Darmon Service",
                    fontSize = 22.sp)
            }
        }
    }
}

@Composable
fun TimeSelection() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { /* Open calendar */ }
    ) {
        Icon(
            painterResource(id = R.drawable.ic_time),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape),
        )
        Text(text = "Choose time", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 4.dp))
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
                .clip(CircleShape),
        )
    }

    // LazyRow displaying the time slots
    LazyRow(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        // List of time slots within the range (from 8:00 to 22:00)
        val timeSlots = mutableListOf<String>()
        var currentTime = 8 * 60 // Start from 8:00 in minutes
        val endTime = 22 * 60 // End at 22:00 in minutes

        while (currentTime <= endTime) {
            val hours = currentTime / 60
            val minutes = currentTime % 60
            val formattedTime = "${String.format("%02d", hours)}:${String.format("%02d", minutes)}"
            timeSlots.add(formattedTime)
            currentTime += 30 // Increment by 30 minutes
        }

        itemsIndexed(timeSlots) { index, timeSlot ->
            // Create a variable for selected time
            val isSelected = remember { mutableStateOf(false) }

            // Update the isSelected state when a time slot is clicked
            TimeSlotItem(
                timeSlot = timeSlot,
                isSelected = isSelected.value,
                onClick = { isSelected.value = !isSelected.value }
            )

            Spacer(modifier = Modifier.width(10.dp)) // Add space between items
        }
    }
}

@Composable
fun TimeSlotItem(timeSlot: String, isSelected: Boolean, onClick: () -> Unit) {
    // Determine background color and text color based on selection state
    val backgroundColor = if (isSelected) Color.Green else Color.White
    val textColor = if (isSelected) Color.White else Color.Green

    // Display the time slot item as a square with rounded corners
    Box(
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        // Display the time slot
        Text(
            text = timeSlot,
            fontSize = 16.sp,
            color = textColor
        )
    }
}



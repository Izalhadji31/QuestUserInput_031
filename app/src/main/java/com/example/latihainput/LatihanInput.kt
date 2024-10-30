package com.example.latihainput


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){

    var Nama by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var NoTelepon by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var MemilihJK by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")

    var NamaIjal by remember { mutableStateOf("") }
    var EmailIjal by remember { mutableStateOf("") }
    var NoteleponIjal by remember { mutableStateOf("") }
    var AlamatIjal by remember { mutableStateOf("") }
    var MemilihJKIjal by remember { mutableStateOf("") }


    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Biodata", fontSize = 16.sp, fontWeight = FontWeight.Bold,)
        Spacer(Modifier.padding(10.dp))
        TextField(
            value = Nama,
            onValueChange = {Nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (modifier = Modifier.fillMaxWidth()){
            listJK.forEach{selectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = MemilihJK == selectedGender,
                        onClick = { MemilihJK = selectedGender
                        }
                    )
                    Text(text = selectedGender)

                }
            }
        }

        TextField(
            value = Email,
            onValueChange = {Email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "isi email anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = NoTelepon,
            onValueChange = {NoTelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "isi No telepon anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = Alamat,
            onValueChange = {Alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )


        Button(onClick = {
            NamaIjal = Nama
            EmailIjal = Email
            NoteleponIjal = NoTelepon
            AlamatIjal = Alamat
            MemilihJKIjal = MemilihJK
        }) {
            Text(text = "Submit")

        }
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            DetailMessagge(param = "Nama", argum = NamaIjal)
            DetailMessagge(param = "Email", argum = EmailIjal)
            DetailMessagge(param = "No Telepon", argum = NoteleponIjal)
            DetailMessagge(param = "Alamat", argum = AlamatIjal)
            DetailMessagge(param = "Memilih JK", argum = MemilihJKIjal)
        }
    }
}

@Composable
fun DetailMessagge(
    param: String, argum: String
){
    Column(
        modifier = Modifier.padding(16.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(text = param,
                modifier = Modifier.weight(0.8f)) // memberi ruang seberapa banyak dalam kolon/barisnya
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = argum, //kenapa argum? karena isinya akan digantikan dengan parameter argum
                modifier = Modifier.weight(2f))

        }
    }
}
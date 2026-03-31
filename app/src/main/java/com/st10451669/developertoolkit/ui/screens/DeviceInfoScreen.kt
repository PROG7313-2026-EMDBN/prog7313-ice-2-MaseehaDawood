package com.st10451669.developertoolkit.uiscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DeviceInfoScreen() {

    val androidVersion = android.os.Build.VERSION.RELEASE
    val sdk = android.os.Build.VERSION.SDK_INT
    val model = android.os.Build.MODEL

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Device Information", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Android Version: $androidVersion")
        Text("SDK Level: $sdk")
        Text("Device Model: $model")
    }
}
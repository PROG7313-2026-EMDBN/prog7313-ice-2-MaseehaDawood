package com.st10451669.developertoolkit.uiscreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.st10451669.developertoolkit.model.DevLink
import com.st10451669.developertoolkit.ui.components.DropdownMenuExample

@Composable
fun LinksScreen() {

    var title by remember { mutableStateOf("") }
    var url by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Documentation") }

    val links = remember { mutableStateListOf<DevLink>() }
    var idCounter by remember { mutableStateOf(0) }

    val categories = listOf("Documentation", "Tutorials", "Tools")

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Developer Links", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        TextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        TextField(value = url, onValueChange = { url = it }, label = { Text("URL") })

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenuExample(categories, category) {
            category = it
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (title.isNotBlank() && url.isNotBlank()) {
                links.add(DevLink(idCounter++, title, url, category))
                title = ""
                url = ""
            }
        }) {
            Text("Save Link")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(links) { link ->
                Column {
                    Text(link.title)
                    Text(link.url)
                    Text("Category: ${link.category}")

                    Button(onClick = { links.remove(link) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}
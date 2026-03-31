package com.st10451669.developertoolkit.uiscreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.st10451669.developertoolkit.model.Note

@Composable
fun NotesScreen() {

    var noteText by remember { mutableStateOf("") }
    val notes = remember { mutableStateListOf<Note>() }
    var idCounter by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Developer Notes", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text("Enter note") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (noteText.isNotBlank()) {
                notes.add(Note(idCounter++, noteText))
                noteText = ""
            }
        }) {
            Text("Add Note")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(notes) { note ->
                Row {
                    Text(note.content, modifier = Modifier.weight(1f))
                    Button(onClick = { notes.remove(note) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}
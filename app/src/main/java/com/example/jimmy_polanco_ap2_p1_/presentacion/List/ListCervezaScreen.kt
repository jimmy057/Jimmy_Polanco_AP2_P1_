package com.example.jimmy_polanco_ap2_p1_.presentacion.List

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCervezaScreen(
    onAddClick: () -> Unit,
    onEditClick: (Int) -> Unit,
    viewModel: ListCervezaViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Lista de Cervezas")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        )

        Text(
            text = "Promedio: ${state.promedio}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.SpaceBy(12.dp)
        ) {
            .items(state.cervezas) { cerveza ->
            Card(
                modifier = Modifier.fillMaxWidth()
            ){
                Column(
                    modifier = Modifier.padding(16.dp)
                ){
                    Text("Marca: ${cerveza.marca}")
                    Text("Tipo: ${cerveza.tipo}")
                    Text("Graduacion: ${cerveza.graduacion}")

                    Spacer(modifier = Modifier.height(8.dp) )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Button(
                            onClick = {
                                onEditClick(cerveza.id)
                            }
                        ) {
                            Text("Editar")
                        }

                        Button(
                            onClick = {
                                viewModel.delete(cerveza)
                            }
                        ) {
                            Text("Eliminar")
                        }
                    }
                }
            }

        }
        }

    }
}
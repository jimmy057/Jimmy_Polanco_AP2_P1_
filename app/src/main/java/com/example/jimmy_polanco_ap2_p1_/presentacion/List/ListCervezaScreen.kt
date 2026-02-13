package com.example.jimmy_polanco_ap2_p1_.presentacion.List

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.jimmy_polanco_ap2_p1_.domain.model.Cerveza

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListCervezaScreen(
    onEditClick: (Int) -> Unit,
    viewModel: ListCervezaViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()
    var filtro by remember { mutableStateOf("") }

    val listaFiltrada = state.lista.filter {
        it.nombre.contains(filtro, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Cervezas") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onEditClick(0) }
            ) {
                Text("+")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                value = filtro,
                onValueChange = { filtro = it },
                label = { Text("Buscar por nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            if (listaFiltrada.isEmpty()) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay resultados")
                }

            } else {

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(listaFiltrada) { cerveza ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            onClick = { onEditClick(cerveza.idCerveza) }
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = cerveza.nombre,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text("Marca: ${cerveza.marca}")
                                Text("Puntuación: ${cerveza.puntuacion}")

                                Spacer(modifier = Modifier.height(12.dp))

                                Button(
                                    onClick = {
                                        viewModel.onEvent(
                                            ListCervezaUiEvent.OnDeleteClick(cerveza)
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth(0.6f)
                                ) {
                                    Text("Eliminar")
                                }
                            }
                        }
                    }
                }
            }

            Text(
                text = "Total: ${listaFiltrada.size}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListCervezaScreenPreview() {

    var filtro by remember { mutableStateOf("") }

    val fakeList = listOf(
        Cerveza(1, "Presidente", "Nacional", 5),
        Cerveza(2, "Corona", "México", 4)
    )

    val listaFiltrada = fakeList.filter {
        it.nombre.contains(filtro, ignoreCase = true)
    }

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                value = filtro,
                onValueChange = { filtro = it },
                label = { Text("Buscar por nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(listaFiltrada) { cerveza ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = cerveza.nombre,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text("Marca: ${cerveza.marca}")
                            Text("Puntuación: ${cerveza.puntuacion}")

                            Spacer(modifier = Modifier.height(12.dp))

                            Button(onClick = {}) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }

            Text(
                text = "Total: ${listaFiltrada.size}",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
    }
}



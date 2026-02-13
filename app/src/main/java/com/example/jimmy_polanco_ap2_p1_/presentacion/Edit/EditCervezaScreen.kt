package com.example.jimmy_polanco_ap2_p1_.presentacion.Edit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCervezaScreen(
    id: Int,
    onBack: () -> Unit,
    viewModel: EditCervezaViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCerveza(id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (id == 0) "Agregar Cerveza"
                        else "Editar Cerveza"
                    )
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = state.nombre,
                onValueChange = {
                    viewModel.onEvent(EditCervezaUiEvent.OnNombreChange(it))
                },
                label = { Text("Nombre") },
                isError = state.nombre.isBlank(),
                supportingText = {
                    if (state.nombre.isBlank()) {
                        Text("El nombre es obligatorio")
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.marca,
                onValueChange = {
                    viewModel.onEvent(EditCervezaUiEvent.OnMarcaChange(it))
                },
                label = { Text("Marca") },
                isError = state.marca.isBlank(),
                supportingText = {
                    if (state.marca.isBlank()) {
                        Text("La marca es obligatoria")
                    }
                },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = state.puntuacion,
                onValueChange = { value ->
                    if (value.all { it.isDigit() }) {
                        viewModel.onEvent(
                            EditCervezaUiEvent.OnPuntuacionChange(value)
                        )
                    }
                },
                label = { Text("Puntuación (1-5)") },
                isError = state.puntuacion.isNotEmpty() &&
                        (state.puntuacion.toIntOrNull() == null ||
                                state.puntuacion.toInt() !in 1..5),
                supportingText = {
                    if (state.puntuacion.isNotEmpty() &&
                        (state.puntuacion.toIntOrNull() == null ||
                                state.puntuacion.toInt() !in 1..5)
                    ) {
                        Text("Debe ser un número entre 1 y 5")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.onEvent(EditCervezaUiEvent.OnSaveClick)
                    onBack()
                },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Guardar")
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun EditCervezaScreenPreview() {

    val fakeState = EditCervezaUiState(
        id = 1,
        nombre = "Presidente",
        marca = "Nacional",
        puntuacion = "5"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Editar Cerveza") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = fakeState.nombre,
                onValueChange = {},
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = fakeState.marca,
                onValueChange = {},
                label = { Text("Marca") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = fakeState.puntuacion,
                onValueChange = {},
                label = { Text("Puntuación") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Guardar")
            }
        }
    }
}

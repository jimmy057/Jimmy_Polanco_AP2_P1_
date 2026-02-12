package com.example.jimmy_polanco_ap2_p1_.presentacion.Edit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCervezaScreen(
    id: Int,
    onBack: () -> Unit,
    viewModel: EditCervezaViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.load(id)

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Editar Cerveza"
                    )
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = state.marca,
                onValueChange = {
                    viewModel.onMarcaChance(it)
                },
                label = { Text("Marca") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = state.tipo,
                onValueChange = {
                    viewModel.onTipoChance(it)
                },
                label = { Text("Tipo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = state.graduacion,
                onValueChange = {
                    viewModel.onGraduacionChance(it)
                },
                label = { Text("graduacion") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    viewModel.Update
                    onBack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("actualizar")
            }
        }
    }
}

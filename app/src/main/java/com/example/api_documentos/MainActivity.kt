package com.example.api_documentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.api_documentos.ui.documentos.DocumentoScreen
import com.example.api_documentos.ui.documentos.DocumentosViewModel
import com.example.api_documentos.ui.theme.Api_DocumentosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Api_DocumentosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val documentosViewModel: DocumentosViewModel = viewModel()
                    DocumentoScreen(documentosViewModel = documentosViewModel)
                }
            }
        }
    }
}


package com.joincoded.taskrequestislamicloanform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.joincoded.taskrequestislamicloanform.viewModel.TaskViewModel

@Composable
fun LoanCalculatorAmount(viewModel: TaskViewModel) {
    var loanAmount by remember { mutableStateOf(0.0) }
    var loanTime by remember {mutableStateOf(0)}
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        OutlinedTextField(value = loanAmount.toString(),
            onValueChange = { loanAmount = it.toDoubleOrNull() ?: 0.0 },
            label = { Text(text = "Loan amount") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number))



        OutlinedTextField(value = loanTime.toString(),
            onValueChange = { loanTime = it.toIntOrNull() ?: 0 },
            label = { Text(text = "Loan payments in months") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { viewModel.calculateMonthlyInstallment(loanAmount,loanTime) })

        {
            Text("Calculate the monthly payments")
        }
        Text("Monthly Payment: ${viewModel.loanPayments}")
    }
}
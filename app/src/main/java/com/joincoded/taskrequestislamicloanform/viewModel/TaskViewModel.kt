package com.joincoded.taskrequestislamicloanform.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
//    var monthlyInstallmentOfLoan by mutableStateOf(0.0)
    var loanAmount by mutableStateOf(0)
        private set
    var loanPeriod by mutableStateOf(0)
        private set
    var loanPayments by mutableStateOf(0.0)
        private set

    fun calculateMonthlyInstallment(loanAmount: Double, loanPeriod: Int) {
        loanPayments = loanAmount / loanPeriod
    }
    fun TaskViewModel.calculateLoanPeriod(salary:Double){
        loanPayments = 0.4 *salary

        loanPeriod = loanAmount/loanPayments.toInt()

    }
}
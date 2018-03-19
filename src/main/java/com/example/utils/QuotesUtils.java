package com.example.utils;

public class QuotesUtils {
    public static boolean isCorrectLoanAmountValue(int loanAmount) {
        return loanAmount >= 1000 && loanAmount <= 15000 && (loanAmount % 100 == 0);
    }

}

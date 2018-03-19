package com.example.utils;

import com.example.model.Offer;

import java.util.List;

public class QuotesUtils {
    public static boolean isCorrectLoanAmountValue(int loanAmount) {
        return loanAmount >= 1000 && loanAmount <= 15000 && (loanAmount % 100 == 0);
    }

    public static double getMaxOffers(List<Offer> offers){
        return offers.stream().mapToDouble(iterationOffer -> iterationOffer.getAvailable()).sum();
    }
}

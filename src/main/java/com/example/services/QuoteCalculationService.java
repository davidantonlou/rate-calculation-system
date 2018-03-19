package com.example.services;

import com.example.model.Offer;
import com.example.model.QuoteCalculation;
import com.example.utils.Constants;
import com.example.utils.QuotesUtils;

import java.util.Comparator;
import java.util.List;

public class QuoteCalculationService implements ICalculationService {

    public QuoteCalculation getQuotes(List<Offer> offers, int loanAmount, int loanMonths) throws Exception {
        if (!QuotesUtils.isCorrectLoanAmountValue(loanAmount)) {
            throw new IllegalArgumentException(Constants.ERROR_LOAN_AMOUNT_VALUE);
        }

        Double maxOffers = QuotesUtils.getMaxOffers(offers);
        if (maxOffers <= loanAmount) {
            throw new Exception(String.format(Constants.ERROR_INSUFFICIENT_OFFERS_VALUE, loanAmount, maxOffers));
        }

        Double total = calculateTotal(loanAmount, offers);
        Double quote = calculateQuote(loanAmount, total);
        Double monthly = calculateMonthly(total, loanMonths);

        return new QuoteCalculation(loanAmount, quote * 100.0, monthly, total, Constants.POUND);
    }

    private double calculateMonthly(Double total, int loanMonths) {
        return total / loanMonths;
    }

    private double calculateQuote(int loanAmount, Double total) {
        return (total - loanAmount) / loanAmount;
    }

    private  Double calculateTotal(int loanAmount, List<Offer> offers) {
        Double partialOffer = 0.0;
        Double total = 0.0;
        Double offerValue;

        offers.sort(Comparator.comparing(Offer::getRate));
        for (Offer offer : offers) {
            if (loanAmount <= partialOffer + offer.getAvailable()){
                offerValue =  loanAmount - partialOffer;
            } else {
                offerValue = offer.getAvailable();
            }
            total += offerValue + (offerValue * offer.getRate());

            if ((partialOffer += offerValue) >= loanAmount) {
                break;
            }
        }
        return total;
    }
}
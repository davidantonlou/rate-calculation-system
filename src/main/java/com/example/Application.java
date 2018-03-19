package com.example;

import com.example.model.Offer;
import com.example.model.QuoteCalculation;
import com.example.services.ICalculationService;
import com.example.services.QuoteCalculationService;
import com.example.utils.CSVParser;
import com.example.utils.Constants;
import com.example.utils.QuotesUtils;

import java.util.List;

public class Application {
    private static final int LOAN_LENGTH_MONTHS = 36;

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            throw new IllegalArgumentException(Constants.ERROR_ARGS_LESS_TWO);
        }

        int loanAmount = Integer.valueOf(args[1]);
        if (!QuotesUtils.isCorrectLoanAmountValue(loanAmount)) {
            throw new IllegalArgumentException(Constants.ERROR_LOAN_AMOUNT_VALUE);
        }

        List<Offer> offers = CSVParser.parse(args[0]);

        try {
            ICalculationService calculationService = new QuoteCalculationService();
            QuoteCalculation quoteCalculation = calculationService.getQuotes(offers, loanAmount, LOAN_LENGTH_MONTHS);
            if (quoteCalculation != null) {
                System.out.println(quoteCalculation.toString());
            }
        } catch(Exception e){
            throw e;
        }
    }
}

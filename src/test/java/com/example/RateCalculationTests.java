package com.example;

import com.example.model.Offer;
import com.example.model.QuoteCalculation;
import com.example.services.ICalculationService;
import com.example.services.QuoteCalculationService;
import com.example.utils.Constants;
import com.example.utils.QuotesUtils;
import com.example.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

public class RateCalculationTests {
    @Test
    public void testTotalQuoteCalculation() throws Exception {
        List<Offer> offerList = TestUtils.getOfferList();

        int loanAmount = 1000;
        ICalculationService calculationService = new QuoteCalculationService();
        QuoteCalculation quoteCalculation;
        try {
            quoteCalculation = calculationService.getQuotes(offerList, loanAmount, TestUtils.LOAN_LENGTH_MONTHS);
        } catch(Exception e){
            throw e;
        }

        Assert.assertNotEquals(quoteCalculation, null);
        Assert.assertEquals(quoteCalculation.getRequestedAmount(), loanAmount);
        Assert.assertEquals(new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(quoteCalculation.getTotalRepayment()),
                "1070.04");
        Assert.assertEquals(new DecimalFormat(Constants.ONE_DECIMAL_FORMAT).format(quoteCalculation.getRate()),
                new DecimalFormat(Constants.ONE_DECIMAL_FORMAT).format(100.0*((1070.04 - loanAmount) / loanAmount)));
        Assert.assertEquals(new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(quoteCalculation.getMonthlyRepayment()),
                new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(1070.04/TestUtils.LOAN_LENGTH_MONTHS));
    }


    @Test
    public void testLoanAmountMultiple100() {
        List<Offer> offerList = TestUtils.getOfferList();

        int loanAmount = 1001;
        ICalculationService calculationService = new QuoteCalculationService();
        try {
            calculationService.getQuotes(offerList, loanAmount, TestUtils.LOAN_LENGTH_MONTHS);
        } catch(Exception e){
            Assert.assertEquals(e.getMessage(), Constants.ERROR_LOAN_AMOUNT_VALUE);
        }
    }

    @Test
    public void testInsufficientOffers() {
        List<Offer> offerList = TestUtils.getOfferList();

        int loanAmount = 15000;
        ICalculationService calculationService = new QuoteCalculationService();
        try {
            calculationService.getQuotes(offerList, loanAmount, TestUtils.LOAN_LENGTH_MONTHS);
        } catch(Exception e){
            Assert.assertEquals(e.getMessage(), String.format(Constants.ERROR_INSUFFICIENT_OFFERS_VALUE, loanAmount,
                    QuotesUtils.getMaxOffers(offerList)));
        }
    }
}

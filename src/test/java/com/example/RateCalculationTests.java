package com.example;

import com.example.model.Offer;
import com.example.model.QuoteCalculation;
import com.example.services.ICalculationService;
import com.example.services.QuoteCalculationService;
import com.example.utils.CSVParser;
import com.example.utils.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

public class RateCalculationTests {

    private static final String MARKET_DATA_FILE = "MarketData.csv";
    private static final int LOAN_LENGTH_MONTHS = 36;

    @Test
    public void testCsvFileParser(){
        List<Offer> offerList = getOfferList();
        Assert.assertNotEquals(offerList, null);
        Assert.assertEquals(offerList.size(), 7);
        Assert.assertEquals(offerList.get(0).getLender(), "Bob");
        Assert.assertEquals(offerList.get(0).getRate(), new Double(0.075));
        Assert.assertEquals(offerList.get(0).getAvailable(), new Double(640));
    }

    @Test
    public void testTotalQuoteCalculation(){
        List<Offer> offerList = getOfferList();

        int loanAmount = 1000;

        ICalculationService calculationService = new QuoteCalculationService();
        QuoteCalculation quoteCalculation = calculationService.getQuotes(offerList, loanAmount, LOAN_LENGTH_MONTHS);

        Assert.assertNotEquals(quoteCalculation, null);
        Assert.assertEquals(quoteCalculation.getRequestedAmount(), loanAmount);
        Assert.assertEquals(new DecimalFormat(Constants.ONE_DECIMAL_FORMAT).format(quoteCalculation.getRate()),"7.0");
        Assert.assertEquals(new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(quoteCalculation.getMonthlyRepayment()), "29.72");
        Assert.assertEquals(new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(quoteCalculation.getTotalRepayment()), "1070.04");
    }

    private List<Offer> getOfferList() {
        return CSVParser.parse(getClass().getClassLoader().getResource(MARKET_DATA_FILE).getFile().toString());
    }
}

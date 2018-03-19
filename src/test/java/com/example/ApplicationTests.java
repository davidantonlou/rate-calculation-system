package com.example;

import com.example.model.Offer;
import com.example.utils.CSVParser;
import com.example.utils.Constants;
import com.example.utils.QuotesUtils;
import com.example.utils.TestUtils;
import org.junit.Test;

import java.util.List;

public class ApplicationTests {

    private static String EXPECTED_RESULT = "Requested amount: £1000\n" +
                                            "Rate: 7.0%\n" +
                                            "Monthly repayment: £29.72\n" +
                                            "Total repayment: £1070.04\n";

    @Test
    public void testInsufficientArguments() {
        TestUtils.commandLineTestException(new String[]{TestUtils.getMarketDataFilePath()}, Constants.ERROR_ARGS_LESS_TWO);
    }

    @Test
    public void testLoanAmountRanges() {
        TestUtils.commandLineTestException(new String[]{TestUtils.getMarketDataFilePath(), "1001"}, Constants.ERROR_LOAN_AMOUNT_VALUE);
        TestUtils.commandLineTestException(new String[]{TestUtils.getMarketDataFilePath(), "10"}, Constants.ERROR_LOAN_AMOUNT_VALUE);
        TestUtils.commandLineTestException(new String[]{TestUtils.getMarketDataFilePath(), "100000"}, Constants.ERROR_LOAN_AMOUNT_VALUE);
    }

    @Test
    public void testInsufficientOffers() {
        List<Offer> offers = CSVParser.parse(TestUtils.getMarketDataFilePath());
        TestUtils.commandLineTestException(new String[]{TestUtils.getMarketDataFilePath(), "10000"},
                String.format(Constants.ERROR_INSUFFICIENT_OFFERS_VALUE, "10000", QuotesUtils.getMaxOffers(offers)));
    }

    @Test
    public void testCommandLineExecution() {
        TestUtils.commandLineTest(new String[]{TestUtils.getMarketDataFilePath(), "1000"}, EXPECTED_RESULT);
    }
}

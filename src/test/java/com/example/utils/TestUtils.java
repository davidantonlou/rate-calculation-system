package com.example.utils;

import com.example.Application;
import com.example.model.Offer;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestUtils {

    public static final String MARKET_DATA_FILE = "MarketData.csv";
    public static final int LOAN_LENGTH_MONTHS = 36;

    public static List<Offer> getOfferList() {
        return CSVParser.parse(TestUtils.class.getClassLoader().getResource(MARKET_DATA_FILE).getFile().toString());
    }

    public static String getMarketDataFilePath(){
        return TestUtils.class.getClassLoader().getResource(MARKET_DATA_FILE).getFile().toString();
    }

    public static void commandLineTestException(String[] arguments, String exceptionMessage){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            Application.main(arguments);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), exceptionMessage);
        } finally {
            System.setOut(console);
        }
    }

    public static void commandLineTest(String[] arguments, String result){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            Application.main(arguments);
            Assert.assertEquals(bytes.toString(), result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setOut(console);
        }
    }
}

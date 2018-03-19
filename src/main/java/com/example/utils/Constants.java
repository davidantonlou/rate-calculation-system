package com.example.utils;

public class Constants {

    public static String POUND = "£";
    public static String ONE_DECIMAL_FORMAT = "##.0";
    public static String DOUBLE_DECIMAL_FORMAT = "##.00";

    public static String TO_STRING_CONTENT_START = "[";
    public static String TO_STRING_CONTENT_END = "]";
    public static String TO_STRING_SEPARATOR = ", ";

    public static int CSV_LENDER_COLUMN = 0;
    public static int CSV_RATE_COLUMN = 1;
    public static int CSV_AVAILABLE_COLUMN = 2;

    public static String REQUESTED_AMOUNT = "Requested amount: %s%s";
    public static String RATE = "Rate: %s%%";
    public static String MONTHLY_REPAYMENT = "Monthly repayment: %s%s";
    public static String TOTAL_REPAYMENT = "Total repayment: %s%s";

    public static String ERROR_ARGS_LESS_TWO = "Error: You must enter two arguments(cmd> [application] [market_file] [loan_amount]).";
    public static String ERROR_LOAN_AMOUNT_VALUE = "Error: Loan Amount value must be greater or equal than 1000 and less or equal than 15000. Also must be multiple of 100.";
    public static String ERROR_INSUFFICIENT_OFFERS_VALUE = "Error: Market does not have sufficient offers for this loan(Loan = %s and Max. Offers = %s).";
}

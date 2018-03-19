package com.example.model;

import com.example.utils.Constants;

import java.text.DecimalFormat;

public class QuoteCalculation {

    private int requestedAmount;
    private Double rate;
    private Double monthlyRepayment;
    private Double totalRepayment;
    private String coinType;

    public QuoteCalculation() {}

    public QuoteCalculation(Integer requestedAmount, Double rate, Double monthlyRepayment, Double totalRepayment, String coinType) {
        this.requestedAmount = requestedAmount;
        this.rate = rate;
        this.monthlyRepayment = monthlyRepayment;
        this.totalRepayment = totalRepayment;
        this.coinType = coinType;
    }

    public int getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(int requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(Double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public Double getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(Double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    @Override
    public String toString() {
        return new StringBuilder(String.format(Constants.REQUESTED_AMOUNT, this.coinType, this.requestedAmount)).
            append(System.lineSeparator()).
            append(String.format(Constants.RATE, new DecimalFormat(Constants.ONE_DECIMAL_FORMAT).format(this.rate))).
            append(System.lineSeparator()).
            append(String.format(Constants.MONTHLY_REPAYMENT, this.coinType, new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(this.monthlyRepayment))).
            append(System.lineSeparator()).
            append(String.format(Constants.TOTAL_REPAYMENT, this.coinType, new DecimalFormat(Constants.DOUBLE_DECIMAL_FORMAT).format(this.totalRepayment))).toString();
    }
}

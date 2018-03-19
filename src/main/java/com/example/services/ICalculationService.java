package com.example.services;

import com.example.model.Offer;
import com.example.model.QuoteCalculation;

import java.util.List;

public interface ICalculationService {

    QuoteCalculation getQuotes(List<Offer> offers, int loanAmount, int loanMonths) throws Exception;
}

package com.example.utils;

import com.example.model.Offer;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static List<Offer> parse(String file) {
        List<Offer> offers = new ArrayList<>();
        CSVReader reader = null;
        String[] line;

        try {
            reader = new CSVReader(new FileReader(file));
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                addOfferToList(offers, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return offers;
    }

    private static void addOfferToList(List<Offer> offers, String[] line) {
        offers.add(new Offer(
                line[Constants.CSV_LENDER_COLUMN],
                new Double(line[Constants.CSV_RATE_COLUMN]),
                new Double(line[Constants.CSV_AVAILABLE_COLUMN]))
        );
    }
}

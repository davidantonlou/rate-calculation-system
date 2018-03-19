package com.example;

import com.example.model.Offer;
import com.example.utils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CSVParserTests {

    @Test
    public void testCsvFileParser(){
        List<Offer> offerList = TestUtils.getOfferList();
        Assert.assertNotEquals(offerList, null);
        Assert.assertEquals(offerList.size(), 7);
        Assert.assertEquals(offerList.get(0).getLender(), "Bob");
        Assert.assertEquals(offerList.get(0).getRate(), new Double(0.075));
        Assert.assertEquals(offerList.get(0).getAvailable(), new Double(640));
    }
}

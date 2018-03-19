package com.example.model;

import com.example.utils.Constants;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

public class Offer {

    private String lender;
    private Double rate;
    private Double available;

    public Offer() {}

    public Offer(String lender, Double rate, Double available) {
        this.lender = lender;
        this.rate = rate;
        this.available = available;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAvailable() {
        return available;
    }

    public void setAvailable(Double available) {
        this.available = available;
    }

    @Override
    public String toString() {
        StandardToStringStyle toStringStyle = new StandardToStringStyle();
        toStringStyle.setContentStart(Constants.TO_STRING_CONTENT_START);
        toStringStyle.setFieldSeparator(Constants.TO_STRING_SEPARATOR);
        toStringStyle.setFieldSeparatorAtStart(false);
        toStringStyle.setContentEnd(Constants.TO_STRING_CONTENT_END);
        toStringStyle.setUseShortClassName(true);
        toStringStyle.setUseIdentityHashCode(false);

        return new ReflectionToStringBuilder(this, toStringStyle).toString();
    }
}

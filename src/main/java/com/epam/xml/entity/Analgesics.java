package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Analgesics extends Medicine {
    @XmlElement(name = "isSteroid")
    private String isSteroid;

    public Analgesics() {
    }

    public Analgesics(String id, String name, CountryOfOrigin countryOfOrigin, double price, String isSteroid) {
        super(id, name, countryOfOrigin, price);
        this.isSteroid = isSteroid;
    }

    public void setIsSteroid(String newIsSteroid) {
        isSteroid = newIsSteroid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Analgesics)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Analgesics that = (Analgesics) o;
        return isSteroid.compareTo(that.isSteroid) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSteroid);
    }

    @Override
    public String toString() {
        return "Analgesic [" + super.toString() +
                ", is Steroid = " + isSteroid +
                ']';
    }
}

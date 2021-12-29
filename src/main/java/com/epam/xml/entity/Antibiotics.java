package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Antibiotics extends Medicine {
    @XmlElement(name = "groupOfAntibiotics")
    private String groupOfAntibiotics;

    public Antibiotics() {
    }

    public Antibiotics(String id, String name, CountryOfOrigin countryOfOrigin, double price, String groupOfAntibiotics) {
        super(id, name, countryOfOrigin, price);
        this.groupOfAntibiotics = groupOfAntibiotics;
    }

    public void setGroupOfAntibiotics(String newGroupOfAntibiotics) {
        groupOfAntibiotics = newGroupOfAntibiotics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Antibiotics)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Antibiotics that = (Antibiotics) o;
        return groupOfAntibiotics.equals(that.groupOfAntibiotics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupOfAntibiotics);
    }

    @Override
    public String toString() {
        return "Antibiotic [" + super.toString() +
                ", group of antibiotics = '" + groupOfAntibiotics + '\'' +
                ']';
    }
}

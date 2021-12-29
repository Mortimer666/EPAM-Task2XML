package com.epam.xml.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
@XmlSeeAlso({Antibiotics.class, Analgesics.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Medicine {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String name;
    @XmlElement(name = "countryOfOrigin")
    private CountryOfOrigin countryOfOrigin;
    @XmlElement(name = "price")
    private double price;

    public Medicine() {
    }

    public Medicine(String id, String name, CountryOfOrigin countryOfOrigin, double price) {
        this.id = id;
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountryOfOrigin(CountryOfOrigin countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Medicine medicine = (Medicine) obj;
        return price == medicine.price
                && id.compareTo(medicine.id) == 0
                && name.compareTo(medicine.name) == 0
                && countryOfOrigin == medicine.countryOfOrigin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryOfOrigin, price);
    }

    @Override
    public String toString() {
        return "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", country of origin = " + countryOfOrigin +
                ", price = " + price;
    }
}

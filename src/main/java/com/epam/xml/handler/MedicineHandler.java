package com.epam.xml.handler;

import com.epam.xml.entity.Analgesics;
import com.epam.xml.entity.Antibiotics;
import com.epam.xml.entity.CountryOfOrigin;
import com.epam.xml.entity.Medicine;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MedicineHandler extends DefaultHandler {
    private final List<Medicine> medicines = new ArrayList<>();
    private Medicine current;
    private String elementName;
    private static final String ANTIBIOTICS = "antibiotics";
    private static final String ANALGESICS = "analgesics";

    public List<Medicine> getMedicines() {
        return medicines;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ANTIBIOTICS.equals(localName) || ANALGESICS.equals(localName)) {
            if (localName.compareTo(ANTIBIOTICS) == 0) {
                current = new Antibiotics();
            } else {
                current = new Analgesics();
            }
            current.setId(attrs.getValue(0));
            if (attrs.getValue(1) != null) {
                current.setName(attrs.getValue(1));
            } else {
                current.setName("No name(optional attribute)");
            }

        } else {
            elementName = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (ANTIBIOTICS.equals(localName) || ANALGESICS.equals(localName)) {
            medicines.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String textValue = new String(ch, start, length).trim();
        if (elementName != null) {
            switch (elementName) {
                case "countryOfOrigin":
                    CountryOfOrigin countryOfOrigin = CountryOfOrigin.valueOf(textValue);
                    current.setCountryOfOrigin(countryOfOrigin);
                    break;
                case "price":
                    current.setPrice(Double.parseDouble(textValue));
                    break;
                case "groupOfAntibiotics":
                    Antibiotics currentAntibiotics = (Antibiotics) current;
                    currentAntibiotics.setGroupOfAntibiotics(textValue);
                    break;
                case "isSteroid":
                    Analgesics currentAnalgesics = (Analgesics) current;
                    currentAnalgesics.setIsSteroid(textValue);
                    break;
                default:
                    break;
            }
        }
        elementName = null;
    }
}

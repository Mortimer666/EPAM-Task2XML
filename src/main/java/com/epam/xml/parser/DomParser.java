package com.epam.xml.parser;

import com.epam.xml.entity.Analgesics;
import com.epam.xml.entity.Antibiotics;
import com.epam.xml.entity.CountryOfOrigin;
import com.epam.xml.entity.Medicine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    @Override
    public List<Medicine> parse(String path) throws ParserException {
        List<Medicine> medicines = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            NodeList antibiotics = root.getElementsByTagName("antibiotics");
            for (int i = 0; i < antibiotics.getLength(); i++) {
                Element medicineElement = (Element) antibiotics.item(i);
                medicines.add(buildMedicine(medicineElement));
            }
            NodeList analgesics = root.getElementsByTagName("analgesics");
            for (int i = 0; i < analgesics.getLength(); i++) {
                Element medicineElement = (Element) analgesics.item(i);
                medicines.add(buildMedicine(medicineElement));
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new ParserException(e.getMessage(), e.fillInStackTrace());
        }
        return medicines;
    }

    private Medicine buildMedicine(Element medicineElement) {
        if (medicineElement.getTagName().compareTo("antibiotics") == 0) {
            Antibiotics medicine = new Antibiotics();
            setMedicineParameters(medicine, medicineElement);
            medicine.setGroupOfAntibiotics(getElementTextContent(medicineElement, "groupOfAntibiotics"));
            return medicine;
        } else {
            Analgesics medicine = new Analgesics();
            setMedicineParameters(medicine, medicineElement);
            medicine.setIsSteroid(getElementTextContent(medicineElement, "isSteroid"));
            return medicine;
        }
    }

    private void setMedicineParameters(Medicine medicine, Element medicineElement) {
        medicine.setId(medicineElement.getAttribute("id"));
        String name = medicineElement.getAttribute("name");
        if (name.compareTo("") != 0) {
            medicine.setName(name);
        } else {
            medicine.setName("No name(optional attribute)");
        }
        CountryOfOrigin countryOfOrigin = CountryOfOrigin.
                valueOf(getElementTextContent(medicineElement, "countryOfOrigin"));
        medicine.setCountryOfOrigin(countryOfOrigin);
        double price = Double.parseDouble(getElementTextContent(medicineElement, "price"));
        medicine.setPrice(price);
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}

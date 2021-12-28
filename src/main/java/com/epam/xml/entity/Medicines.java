package com.epam.xml.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "medicines", namespace = "http://www.example.com/medicines")
public class Medicines {
    @XmlElements({@XmlElement(name = "antibiotics", type = Antibiotics.class),
            @XmlElement(name = "analgesics", type = Analgesics.class)})
    private final List<Medicine> medicinesList = new ArrayList<>();

    public List<Medicine> getMedicinesList() {
        return medicinesList;
    }

    public void nullNameChanger(List<Medicine> medicines) {
        for (Medicine medicine : medicines) {
            if (medicine.getName() == null) {
                medicine.setName("No name(optional attribute)");
            }
        }
    }
}

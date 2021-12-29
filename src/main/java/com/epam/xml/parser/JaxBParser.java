package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;
import com.epam.xml.entity.Medicines;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxBParser implements Parser {

    @Override
    public List<Medicine> parse(String path) throws ParserException {
        List<Medicine> medicineList;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Medicines.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(path);
            Medicines medicines = (Medicines) unmarshaller.unmarshal(reader);
            medicineList = medicines.getMedicinesList();
            medicines.nullNameChanger(medicineList);
        } catch (JAXBException | FileNotFoundException e) {
            throw new ParserException(e.getMessage(), e.fillInStackTrace());
        }
        return medicineList;
    }
}

package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;
import com.epam.xml.handler.MedicineHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements Parser {

    @Override
    public List<Medicine> parse(String path) throws ParserException {
        MedicineHandler medicineHandler = new MedicineHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(medicineHandler);
            reader.parse(path);
        } catch (SAXException | IOException e) {
            throw new ParserException(e.getMessage(), e.fillInStackTrace());
        }
        return medicineHandler.getMedicines();
    }
}
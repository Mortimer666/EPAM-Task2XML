package com.epam.xml;

import com.epam.xml.entity.Medicine;
import com.epam.xml.factory.ParserFactory;
import com.epam.xml.factory.ParserFactoryException;
import com.epam.xml.parser.Parser;
import com.epam.xml.parser.ParserException;
import com.epam.xml.parser.ParserType;
import com.epam.xml.validator.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private static final Logger LOGGER = LogManager.getLogger(Director.class);
    private static final String PATH = "src/test/resources/medicines.xml";

    public List<Medicine> run() {
        List<Medicine> medicines = new ArrayList<>();
        try {
            ParserFactory factory = new ParserFactory();
            Parser parser = factory.create(ParserType.DOM);
            XmlValidator validator = new XmlValidator();
            if (validator.validate(PATH)) {
                medicines = parser.parse(PATH);
            } else {
                LOGGER.error("Xml file is not valid");
            }
        } catch (ParserException | ParserFactoryException e) {
            LOGGER.error(e.getMessage(), e.fillInStackTrace());
        }
        return medicines;
    }
}

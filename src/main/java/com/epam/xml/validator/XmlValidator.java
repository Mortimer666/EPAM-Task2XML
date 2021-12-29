package com.epam.xml.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public boolean validate(String xmlPath) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String schemaLocation = "src/test/resources/medicines.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaFile = new File(schemaLocation);
        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }
}

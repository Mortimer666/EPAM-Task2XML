package com.epam.xml.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XmlValidatorTest {

    @Test
    void testValidateShouldReturnTrueIfXmlValid() {
        //given
        String path = "src/test/resources/medicines.xml";
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.validate(path);
        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void testValidateShouldReturnFalseIfXmlInvalid() {
        //given
        String path = "src/test/resources/medicinesInvalid.xml";
        XmlValidator xmlValidator = new XmlValidator();
        //when
        boolean actual = xmlValidator.validate(path);
        //then
        Assertions.assertFalse(actual);
    }
}

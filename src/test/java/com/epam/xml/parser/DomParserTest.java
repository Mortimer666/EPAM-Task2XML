package com.epam.xml.parser;

import com.epam.xml.entity.Analgesics;
import com.epam.xml.entity.Antibiotics;
import com.epam.xml.entity.CountryOfOrigin;
import com.epam.xml.entity.Medicine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DomParserTest {

    @Test
    void testParseShouldReturnCorrectListOfMedicine() throws ParserException {
        //given
        Parser domParser = new DomParser();
        String path = "src/test/resources/medicines.xml";
        List<Medicine> expectedMedicineList = Arrays.asList(
                new Antibiotics(
                        "ID-12523", "No name(optional attribute)", CountryOfOrigin.BELARUS, 25.13, "Tetracyclines"),
                new Antibiotics(
                        "ID-12896", "Augmentin", CountryOfOrigin.RUSSIA, 13.16, "Penicillins"),
                new Analgesics(
                        "ID-13158", "Buprenorphine", CountryOfOrigin.RUSSIA, 62.95, "No"),
                new Analgesics(
                        "ID-13673", "No name(optional attribute)", CountryOfOrigin.BELARUS, 56.44, "Yes"));
        //when
        List<Medicine> actualList = domParser.parse(path);
        //then
        Assertions.assertEquals(expectedMedicineList.size(), actualList.size());
        for (int i = 0; i < expectedMedicineList.size(); i++) {
            Assertions.assertEquals(expectedMedicineList.get(i), actualList.get(i));
        }
    }

    @Test
    void testParseShouldThrowExceptionWhenPathIsInvalid() {
        //given
        Parser domParser = new DomParser();
        String invalidPath = "src/test/resources/medicine.xml";
        //when
        Exception exception = Assertions.assertThrows(ParserException.class, () -> domParser.parse(invalidPath));
        //then
        Assertions.assertEquals("F:\\Programming\\EPAM\\EPAM Java WebDev Projects 40ST" +
                        "\\Task2XML\\src\\test\\resources\\medicine.xml (The system cannot find the file specified)",
                exception.getMessage());
    }
}

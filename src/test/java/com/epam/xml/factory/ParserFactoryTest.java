package com.epam.xml.factory;

import com.epam.xml.parser.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserFactoryTest {

    @Test
    void testCreateShouldReturnDomParser() throws ParserFactoryException {
        //given
        ParserFactory factory = new ParserFactory();
        Parser expectedParser = new DomParser();
        //when
        Parser actualParser = factory.create(ParserType.DOM);
        //then
        Assertions.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }

    @Test
    void testCreateShouldReturnSaxParser() throws ParserFactoryException {
        //given
        ParserFactory factory = new ParserFactory();
        Parser expectedParser = new SaxParser();
        //when
        Parser actualParser = factory.create(ParserType.SAX);
        //then
        Assertions.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }

    @Test
    void testCreateShouldReturnJaxBParser() throws ParserFactoryException {
        //given
        ParserFactory factory = new ParserFactory();
        Parser expectedParser = new JaxBParser();
        //when
        Parser actualParser = factory.create(ParserType.JAXB);
        //then
        Assertions.assertEquals(expectedParser.getClass(), actualParser.getClass());
    }
}

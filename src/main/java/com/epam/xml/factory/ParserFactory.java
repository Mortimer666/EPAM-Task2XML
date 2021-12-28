package com.epam.xml.factory;

import com.epam.xml.parser.*;

public class ParserFactory {
    public Parser create(ParserType parserType) throws ParserFactoryException {
        switch (parserType) {
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            case JAXB:
                return new JaxBParser();
            default:
                throw new ParserFactoryException("Wrong type of parser");
        }
    }
}

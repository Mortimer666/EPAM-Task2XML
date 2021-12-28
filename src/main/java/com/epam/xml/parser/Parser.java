package com.epam.xml.parser;

import com.epam.xml.entity.Medicine;

import java.util.List;

public interface Parser {
    List<Medicine> parse(String path) throws ParserException;
}

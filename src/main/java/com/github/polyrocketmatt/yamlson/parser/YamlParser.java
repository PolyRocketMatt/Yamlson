package com.github.polyrocketmatt.yamlson.parser;

import com.github.polyrocketmatt.yamlson.parser.node.ParentNode;
import com.github.polyrocketmatt.yamlson.parser.node.YamlNode;
import com.github.polyrocketmatt.yamlson.preprocessing.YamlPreProcessor;

import java.util.List;

public class YamlParser {

    private int lines = 0;
    private final YamlDictionaryParser dictionaryParser = new YamlDictionaryParser();

    public YamlParser() {

    }

    public int lines() {
        return lines;
    }

    public void parse(String data) {
        YamlNode parent = new ParentNode();
        List<String> entries = new YamlPreProcessor(data).getResult();

        this.lines = entries.size();
        int index = 0;
        int charIndex = 0;
        while (index < entries.size()) {
            String entry = entries.get(index);


            index++;
            charIndex = 0;
        }
    }

}

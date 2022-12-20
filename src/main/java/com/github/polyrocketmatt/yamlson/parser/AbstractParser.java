package com.github.polyrocketmatt.yamlson.parser;

import com.github.polyrocketmatt.yamlson.parser.node.YamlNode;

public abstract class AbstractParser {

    protected AbstractParser() {}

    public abstract YamlNode parse(String data);

}

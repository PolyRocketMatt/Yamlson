package com.github.polyrocketmatt.yamlson.parser.node;

import java.util.HashMap;
import java.util.Map;

public class YamlDictionaryNode {

    private final Map<String, YamlNode> dictionary;

    public YamlDictionaryNode() {
        this.dictionary = new HashMap<>();
    }

    public void add(String key, YamlNode value) {
        this.dictionary.put(key, value);
    }

    public YamlNode get(String key) {
        return this.dictionary.get(key);
    }

}

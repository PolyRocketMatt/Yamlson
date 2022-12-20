package com.github.polyrocketmatt.yamlson.parser.node;

public class ParentNode extends YamlNode {

    public ParentNode() {
        super(null, "parent");
    }

    @Override
    public void addChild(YamlNode node) {
        this.children.add(node);
    }

    @Override
    public String key() {
        return key;
    }

}

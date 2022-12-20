package com.github.polyrocketmatt.yamlson.parser.node;

import java.util.ArrayList;
import java.util.List;

public abstract class YamlNode {

    protected final YamlNode parent;
    protected final List<YamlNode> children;
    protected final String key;

    public YamlNode(YamlNode parent, String key) {
        this.parent = parent;
        this.children = new ArrayList<>();
        this.key = key;
    }

    public List<YamlNode> children() {
        return children;
    }

    public YamlNode find(String key) {
        return children.stream().filter(node -> node.key().equals(key)).findFirst().orElse(null);
    }

    public void addChild(YamlNode node) {
        if (children.stream().anyMatch(child -> child.key().equals(node.key())))
            throw new IllegalArgumentException("A node with the key '" + node.key() + "' already exists in this node");
        children.add(node);
    }

    public void removeChild(YamlNode node) {
        if (children.stream().noneMatch(child -> child.key().equals(node.key())))
            throw new IllegalArgumentException("A node with the key '" + node.key() + "' does not exist in this node");
        children.remove(node);
    }

    public abstract String key();

}

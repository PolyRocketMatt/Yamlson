package com.github.polyrocketmatt.yamlson.preprocessing;

import java.util.ArrayList;
import java.util.List;

public class YamlPreProcessor {

    private final List<String> lines;

    public YamlPreProcessor(String data) {
        String[] entries = data.split("\\r?\\n|\\r");

        this.lines = new ArrayList<>(List.of(entries));
    }

    public List<String> getResult() {
        preprocess();
        return lines;
    }

    private void preprocess() {
        removeCommonIndentation();
        removeComments();
        removeEmptyLines();
        validate();
    }

    private void removeCommonIndentation() {
        int minIndent = 0;
        for (String str : lines) {
            int indent = 0;
            for (char c : str.toCharArray()) {
                if (c == ' ')
                    indent++;
                else
                    break;
            }

            if (indent < minIndent)
                minIndent = indent;
        }

        for (int i = 0; i < lines.size(); i++) {
            String str = lines.get(i);
            lines.set(i, str.substring(minIndent));
        }
    }

    private void removeComments() {
        while (lines.stream().anyMatch(str -> str.startsWith("#")))
            lines.removeIf(str -> str.startsWith("#"));
    }

    private void removeEmptyLines() {
        lines.removeIf(String::isEmpty);
    }

    private void validate() {

    }

}

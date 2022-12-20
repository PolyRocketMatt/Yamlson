package com.github.polyrocketmatt.yamlson;

import com.github.polyrocketmatt.yamlson.parser.YamlParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YamlParserTest {

    @Test
    public void testJavaString() {
        String test = "This is a single line test case";
        YamlParser parser = new YamlParser();
        parser.parse(test);

        assertEquals(1, parser.lines());
    }

    @Test
    public void testJavaMultilineString() {
        String test = """
                This is a
                multi line
                test case
                """;
        YamlParser parser = new YamlParser();
        parser.parse(test);

        assertEquals(3, parser.lines());
    }

    @Test
    public void testJavaMultilineStringWithNewLine() {
        String test = "This is multi line\ntest case";
        YamlParser parser = new YamlParser();
        parser.parse(test);

        assertEquals(2, parser.lines());
    }


}

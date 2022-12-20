package com.github.polyrocketmatt.yamlson;

import com.github.polyrocketmatt.yamlson.parser.YamlParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class Yamlson<T>{

    private final T instance;
    private final YamlParser parser;

    public Yamlson(Supplier<T> supplier) {
        this.instance = supplier.get();
        this.parser = new YamlParser();
    }

    @SuppressWarnings("unchecked")
    public Yamlson(Class<T> clazz) {
        try {
            Constructor<?>[] constructors = clazz.getConstructors();

            if (constructors.length == 0)
                throw new IllegalArgumentException("Class " + clazz.getName() + " does not have a constructor!");
            Optional<Constructor<?>> optional = Arrays.stream(constructors).filter(c -> c.getParameterCount() == 0).findFirst();
            if (optional.isEmpty())
                throw new IllegalArgumentException("Class " + clazz.getName() + " does not have a default constructor!");
            Constructor<T> constructor = (Constructor<T>) optional.get();
            this.instance = constructor.newInstance();
            this.parser = new YamlParser();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    public YamlParser getParser() {
        return parser;
    }

    public Yamlson<T> from(String data) {
        this.parser.parse(data);
        return this;
    }

    public Yamlson<T> from(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }

            this.parser.parse(builder.toString());
            return this;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private T parse(String yaml) {
        parser.parse(yaml);

        return instance;
    }

}

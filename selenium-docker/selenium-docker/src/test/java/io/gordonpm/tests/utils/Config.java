package io.gordonpm.tests.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void initialize() {
        properties = loadProperties();

        for (String key : properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                properties.setProperty(key, System.getProperty(key));
            }
        }

        log.info("Test properties");
        log.info("--------------------");
        for (String key : properties.stringPropertyNames()) {
            log.info("{}={}", key, properties.getProperty(key));
        }

    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try(InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (IOException e) {
            log.error("Unable to load properties file {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}

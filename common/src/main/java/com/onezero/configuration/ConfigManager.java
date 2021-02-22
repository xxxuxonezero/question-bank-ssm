package com.onezero.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigManager {

    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);
    private static Map<String, Properties> config = new HashMap<String, Properties>();


    /**
     * when the application runs, put the properties into memory
     * @param path
     * @param key
     */
    public static void initProperties(String path, String key) {
        Properties pro = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            pro.load(fis);
            config.put(key, pro);
        } catch (Exception e) {
            logger.error("path={}, file not exists", path);
        }
    }

    public static Properties getProperties(String key) {
        return config.get(key);
    }
}

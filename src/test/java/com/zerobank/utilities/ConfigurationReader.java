package com.zerobank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            //hangi dosyadan bilgi alacağım
            String path="configuration.properties";
            //javaya dosyayı okutalım
            FileInputStream input=new FileInputStream(path);
            //okunan dosya nereye aktarılacak
            properties=new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String  get(String keyName) {
        return properties.getProperty(keyName);
    }
}

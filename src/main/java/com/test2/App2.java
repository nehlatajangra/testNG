package com.test2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App2 {

    public static void main(String[] args) {

        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("user"));
            System.out.println(prop.getProperty("id"));
            System.out.println(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

package com.test2;

// public class App1 {
    
// }
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class App1 {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("user", "localhost");
            prop.setProperty("id", "101");
            prop.setProperty("password", "password");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}

package com.demoqa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    In this class, we will be creating the reusable logic to read from configuration.properties file
     */

    //1 - create object

    private static Properties properties = new Properties(); // private so its not accessible outside of the class; static - created and loaded before everything else

    static{

        try {

            //2 - open file using FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //3 - load file
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
        }

    }

    // create utility method to use the object to read
    //4 - read properties

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }










}
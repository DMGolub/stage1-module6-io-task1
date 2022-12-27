package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) throws NumberFormatException {
        String name = null;
        int age = 0;
        String email = null;
        long phone = 0L;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                if (keyValue[0].equals("Name")) {
                    name = keyValue[1];
                } else if (keyValue[0].equals("Age")) {
                    age = Integer.parseInt(keyValue[1]);
                } else if (keyValue[0].equals("Email")) {
                    email = keyValue[1];
                } else if (keyValue[0].equals("Phone")) {
                    phone = Long.parseLong(keyValue[1]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Could not find the file: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("I/O exception: " + ex.getMessage());
        }
        return new Profile(name, age, email, phone);
    }
}
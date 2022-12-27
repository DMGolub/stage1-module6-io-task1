package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    private static final String NAME_KEY = "Name";
    private static final String AGE_KEY = "Age";
    private static final String EMAIL_KEY = "Email";
    private static final String PHONE_KEY = "Phone";

    public Profile getDataFromFile(File file) throws NumberFormatException {
        String name = null;
        int age = 0;
        String email = null;
        long phone = 0L;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                switch (keyValue[0]) {
                    case NAME_KEY:
                        name = keyValue[1];
                        break;
                    case AGE_KEY:
                        age = Integer.parseInt(keyValue[1]);
                        break;
                    case EMAIL_KEY:
                        email = keyValue[1];
                        break;
                    case PHONE_KEY:
                        phone = Long.parseLong(keyValue[1]);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException  ex) {
            // Log error
        }
        return new Profile(name, age, email, phone);
    }
}
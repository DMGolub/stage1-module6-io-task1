package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {

    public Profile getDataFromFile(File file) {
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
            System.out.println("Could not find the file: " + ex.getMessage());
        } catch (NumberFormatException nfe) {
            System.err.println("Error while parsing age or name: " + nfe.getMessage());
        } catch (Exception e) {
            System.out.println("Got an error: " + e.getMessage());
        }
        return new Profile(name, age, email, phone);
    }
}
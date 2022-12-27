package com.epam.mjc.io;

import java.io.File;

public class Main {

    private static final String FILE_NAME = "src/main/resources/Profile.txt";        // temp

    public static void main(String[] args) {
        File file = new File(FILE_NAME);
        FileReader reader = new FileReader();
        Profile profile = reader.getDataFromFile(file);
        System.out.println(profile.toString());
    }
}
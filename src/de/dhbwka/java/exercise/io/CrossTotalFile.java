package de.dhbwka.java.exercise.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrossTotalFile {

    File totalFolder = new File("C:\\Users\\joachimb\\Desktop\\Projects\\myDir");

    String crossTotal = "crosstotal.txt";

    private String getCrossTotal() {
        int value = 0;
        final Scanner sc = new Scanner(System.in);
        System.out.println("Bite geben sie Ihre Zahl an: ");
        final String num = sc.next();
        sc.close();
        for (int i = 0; i < num.length(); i++) {
            value += Character.getNumericValue(num.charAt(i));
        }
        return "Quersumme von " + num + " ist " + value;
    }

    private void createDir() {
        if (!totalFolder.exists()) {
            totalFolder.mkdirs();
            System.out.println("creating Folders: " + totalFolder.getAbsolutePath().toString());
        }
    }

    private void writeToFile() {
        createDir();
        try {
            final BufferedWriter bw = new BufferedWriter(new FileWriter(new File(totalFolder, crossTotal)));
            bw.write(getCrossTotal());
            bw.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(final String[] args) {
        final CrossTotalFile ctf = new CrossTotalFile();
        ctf.writeToFile();
    }

}

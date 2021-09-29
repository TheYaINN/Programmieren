package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeFile {

    File totalFolder = new File("C:\\Users\\joachimb\\Desktop\\Projects\\myDir");

    String palindrome = "palindrom.txt";
    Path paliFile = new File(totalFolder, palindrome).toPath();

    List<String> palindromes = new ArrayList<>();

    private void createDir() {
        if (!totalFolder.exists()) {
            totalFolder.mkdirs();
            System.out.println("creating Folders: " + totalFolder.getAbsolutePath().toString());
        }
    }

    private String getPalindrome() {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie ein Wort ein, dass Sie überprüfen wollen.");
        final String word = sc.nextLine();
        sc.close();
        final String word2 = new StringBuilder(word).reverse().toString();
        System.out.println("Dein Wort: " + word + "\nDein Wort umgekehrt: " + word2);
        if (word.equalsIgnoreCase(word2)) {
            return word2;
        } else {
            return "";
        }
    }

    private void getOldPalindromes() {
        try {
            final BufferedReader br = Files.newBufferedReader(paliFile);
            String line = "";
            while ((line = br.readLine()) != null) {
                palindromes.add(line);
            }
            br.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    private void cleanUpList() {
        palindromes.clear();
    }

    private void writeToFile() {
        createDir();
        try {
            getOldPalindromes();
            final BufferedWriter bw = new BufferedWriter(new FileWriter(paliFile.toFile()));
            for (final String palindrom : palindromes) {
                bw.write(palindrom + "\n");
            }
            bw.write(getPalindrome());
            bw.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        cleanUpList();
    }

    public static void main(final String[] args) {
        final PalindromeFile pf = new PalindromeFile();
        pf.writeToFile();
    }

}

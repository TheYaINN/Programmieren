package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;

public class Files {

    File parentFolder = new File("C:\\Users\\joachimb\\Desktop\\Projects");
    String saveFolder = "myDir";

    File totalFolder = new File(parentFolder, saveFolder);

    String[] fileNames = {"foo1", "foo2", "foo3"};

    private void createDirs() {

        if (!totalFolder.exists()) {
            totalFolder.mkdirs();
        }
    }

    public void createFiles() {
        createDirs();
        for (final String name : fileNames) {
            try {
                new File(totalFolder, name).createNewFile();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            System.out.println("generating file: " + name);
        }

    }

    private void deleteDirs() {
        final File[] files = new File(totalFolder.toString()).listFiles();
        for (final File file : files) {
            file.delete();
        }
    }

    public static void main(final String[] args) {
        final Files genFile = new Files();
        genFile.createFiles();
        genFile.deleteDirs();

    }

}

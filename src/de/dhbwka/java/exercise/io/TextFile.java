package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextFile {

    Path file = new File("C:\\Users\\joachimb\\Desktop\\Projects\\myDir").toPath();

    final List<String> lines = new ArrayList<>();

    public TextFile(final File newFile) {
        file = new File(file.toString(), newFile.toString()).toPath();
        read();
    }

    public TextFile(final String pathName) {
        file = new File(file.toString(), pathName).toPath();
        read();
    }

    private void read() {
        try {
            final BufferedReader br = java.nio.file.Files.newBufferedReader(file);
            String line = "";
            while ((line = br.readLine()) != null) {
                lines.add(line + "\n");
            }
            br.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void write() {
        try {
            final BufferedWriter bw = new BufferedWriter(new FileWriter(file.toString()));
            lines.forEach(line -> {
                try {
                    bw.write(line);
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            });
            bw.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    private int availableLines() {
        return lines.size();
    }

    private String[] getLines() {
        return lines.toArray(new String[0]);
    }

    String getLine(final int lineNumber) {
        return lines.get(lineNumber - 1);
    }

    private void setLine(final int lineNumber, final String line) {
        lines.set(lineNumber, line);
    }

    private void replaceAll(final String regEx, final String replacement) {
        lines.stream().forEach(line -> line.replaceAll(regEx, replacement));
    }

    public static void main(final String[] args) {
        final TextFile tf = new TextFile("beispiel.txt");
        System.out.println(tf.availableLines());
        System.out.println(tf.getLine(3));
        System.out.println(Arrays.toString(tf.getLines()));
        tf.replaceAll("4", "hallo");
        System.out.print(Arrays.toString(tf.getLines()));
        tf.write();

    }

}

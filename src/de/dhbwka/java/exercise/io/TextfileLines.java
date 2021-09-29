package de.dhbwka.java.exercise.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextfileLines {

    String baseFolder = "C:\\Users\\joachimb\\Desktop\\Projects\\myDir";

    String fileName = "beispiel.txt";

    Path fullFile = new File(baseFolder, fileName).toPath();

    public static final int START_LINE = 2;
    public static final int END_LINE = 5;
    List<String> lines = new ArrayList<>();

    private void readLines() {
        try {
            final BufferedReader br = Files.newBufferedReader(fullFile);
            int i = 1;
            while (br.ready()) {
                final String line = br.readLine();
                if (i >= START_LINE && i <= END_LINE) {
                    System.out.println(line);
                    lines.add(line);
                }
                i++;
            }
            br.close();
            for (final String line : lines) {
                System.out.print(line);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(final String[] args) {
        final TextfileLines tfl = new TextfileLines();
        tfl.readLines();
    }

}

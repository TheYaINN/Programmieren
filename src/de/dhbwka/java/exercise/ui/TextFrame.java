package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextFrame extends JFrame {

    TextFrame(File file, int width, int height) throws IOException {
        if (file.isDirectory()) {
            throw new IOException();
        }
        setVisible(true);
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel pan = new JPanel();
        JTextArea ta = new JTextArea();
        pan.add(ta);
        List<String> lines = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
        setTitle(lines.get(0));
        lines.remove(0);
        for (String line : lines) {
            ta.append(line + "\n");
        }
        add(pan);
        revalidate();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\joachimb\\Desktop\\Projects\\Programmieren\\src\\de\\dhbwka\\java\\exercise\\ui\\Erlköning_lang.txt");
        try {
            TextFrame frame = new TextFrame(file, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextfileViewer {

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION) {
            FileShower fs = new FileShower(fc.getSelectedFile());
        } else {
            System.out.println("No selection");
        }
    }

    static class FileShower {

        FileShower(File selectedFile) {
            JPanel panel = new JPanel();
            try {
                List<String> lines = Files.readAllLines(Paths.get(selectedFile.toURI()), StandardCharsets.UTF_8);
                if (lines.size() < 10) {
                    panel.setLayout(new GridLayout(10, 1));
                    lines.stream().forEach(line -> panel.add(new JLabel(line)));
                } else {
                    panel.setBorder(new TitledBorder(new EtchedBorder(), "Erlkönig"));
                    JTextArea ta = new JTextArea();
                    lines.stream().forEach(line -> ta.append(line + "\n"));
                    ta.setEditable(false);
                    JScrollPane sp = new JScrollPane(ta);
                    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    panel.add(sp);
                }
                JFrame frame = new JFrame();
                frame.setTitle("FileViewer");
                frame.setSize(500, 500);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.add(panel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

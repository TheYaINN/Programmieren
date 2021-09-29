package de.dhbwka.java.exercise.collections.library;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Library extends JFrame {

    JTextField titleTF;
    JTextField authorTF;
    JTextField yearTF;
    JTextField publisherTF;

    Path fileLoc = Paths.get("C:\\Users\\joachimb\\Desktop\\Projects\\Programmieren\\src\\de\\dhbwka\\java\\exercise\\collections\\library\\lib.txt");


    Library() {
        setTitle("Library");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(0, 1));
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel title = new JLabel("Title");
        JLabel author = new JLabel("Author");
        JLabel year = new JLabel("Year");
        JLabel publisher = new JLabel("Publisher");

        titleTF = new JTextField();
        authorTF = new JTextField();
        yearTF = new JTextField();
        publisherTF = new JTextField();

        inputPanel.add(title);
        inputPanel.add(titleTF);
        inputPanel.add(author);
        inputPanel.add(authorTF);
        inputPanel.add(year);
        inputPanel.add(yearTF);
        inputPanel.add(publisher);
        inputPanel.add(publisherTF);

        JButton saveEntry = new JButton("Save entry");
        saveEntry.addActionListener(e -> {
            saveBookEntry();
        });

        JLabel outlbl = new JLabel("Ordered Output:");
        JButton titlebtn = new JButton("Title");
        JButton authorbtn = new JButton("Author");
        JButton yeatbtn = new JButton("Year");
        JButton publisherbtn = new JButton("Publisher");

        outputPanel.add(outlbl);
        outputPanel.add(titlebtn);
        outputPanel.add(authorbtn);
        outputPanel.add(yeatbtn);
        outputPanel.add(publisherbtn);

        mainPanel.add(inputPanel);
        mainPanel.add(saveEntry);
        mainPanel.add(outputPanel);
        add(mainPanel);
        revalidate();
    }

    private void saveBookEntry() {
        String saveStr = "";
        saveStr = String.format("%s;%s;%s;%s\n", titleTF.getText(), authorTF.getText(), yearTF.getText(), publisherTF.getText());
        if (entryFound(saveStr)) {
            try {
                if (!fileLoc.toFile().exists()) {
                    fileLoc.toFile().createNewFile();
                }
                Files.write(fileLoc, saveStr.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Buch ist schon vorhanden!");
        }
    }

    private boolean entryFound(String inBook) {
        try {
            List<String> books = Files.readAllLines(fileLoc);
            for (String book : books) {
                if (book.matches(inBook)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Library lib = new Library();
    }
}

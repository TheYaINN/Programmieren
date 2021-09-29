package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Editor {

    JFrame frame;
    JTextPane textPane;
    StyledDocument doc;

    Editor() {
        JMenuBar bar = createMenu();
        frame = new JFrame();
        frame.setTitle("Editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(bar);


        JScrollPane pane = new JScrollPane();
        textPane = new JTextPane();
        pane.add(textPane);
        frame.add(pane);
        frame.revalidate();
    }

    private JMenuBar createMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu datei = createDateiMenu();
        JMenu bearbeiten = createBearbeitenMenu();
        bar.add(datei);
        bar.add(bearbeiten);
        return bar;
    }

    private JMenu createBearbeitenMenu() {
        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenuItem rückgängig = new JMenuItem("Rückgängig");
        JMenuItem wiederholen = new JMenuItem("Wiederholen");
        JMenuItem ausschneiden = new JMenuItem("Ausschneiden");
        JMenuItem kopieren = new JMenuItem("Kopieren");
        JMenuItem officeablage = new JMenuItem("Office-Zwischneablage");
        JMenuItem einfügen = new JMenuItem("Einfügen");

        bearbeiten.add(rückgängig);
        bearbeiten.add(wiederholen);
        bearbeiten.addSeparator();
        bearbeiten.add(ausschneiden);
        bearbeiten.add(kopieren);
        bearbeiten.add(officeablage);
        bearbeiten.add(einfügen);

        return bearbeiten;
    }

    private JMenu createDateiMenu() {
        JMenu datei = new JMenu("Datei");

        JMenuItem schließen = new JMenuItem("schließen");
        JMenuItem speichern = new JMenuItem("speichern");
        JMenuItem speichernUnter = new JMenuItem("Speichern Unter");
        JMenuItem alsWebsiteSpeichern = new JMenuItem("Als Website Speichern");
        JMenuItem suchen = new JMenuItem("Suchen");
        JMenuItem versionen = new JMenuItem("Versionen");
        JMenu senden = new JMenu("Senden an");
        senden.add(new JMenuItem("E-Mail-Empfänger"));
        senden.add(new JMenuItem("Exchange-Ordner"));

        datei.add(JMenuItemBuilder.builder().text("Neu").addAction(e -> {
            //TODO: IDK
        }).build());

        datei.add(JMenuItemBuilder.builder().text("Öffnen").addAction(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(frame);
            if (chooser.getSelectedFile().canRead()) {
                updateText(chooser.getSelectedFile());
            }
        }).build());

        datei.addSeparator();

        datei.add(JMenuItemBuilder.builder().text("Schließen").addAction(e -> {
            System.exit(0);
        }).build());

        datei.addSeparator();

        datei.add(speichern);

        datei.add(speichernUnter);

        datei.add(alsWebsiteSpeichern);
        datei.add(suchen);
        datei.add(versionen);
        datei.add(senden);
        return datei;
    }

    private void updateText(File file) {
        try {
            List<String> fileContent = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            //TODO: set the new text
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.revalidate();
    }

    public static void main(String[] args) {
        Editor edit = new Editor();
    }
}

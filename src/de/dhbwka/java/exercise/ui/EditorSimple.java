package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class EditorSimple {

    EditorSimple() {
        JMenuBar bar = createMenu();
        JFrame frame = new JFrame();
        frame.setTitle("Editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
        frame.setSize(400, 400);
        frame.setJMenuBar(bar);
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

        JMenuItem neu = new JMenuItem("Neu");
        JMenuItem öffnen = new JMenuItem("öffnen");
        JMenuItem schließen = new JMenuItem("schließen");
        JMenuItem speichern = new JMenuItem("speichern");
        JMenuItem speichernUnter = new JMenuItem("Speichern Unter");
        JMenuItem alsWebsiteSpeichern = new JMenuItem("Als Website Speichern");

        datei.add(neu);
        datei.add(öffnen);
        datei.addSeparator();
        datei.add(schließen);
        datei.addSeparator();
        datei.add(speichern);
        datei.add(speichernUnter);
        datei.add(alsWebsiteSpeichern);
        return datei;
    }


    public static void main(String[] args) {
        EditorSimple es = new EditorSimple();
    }
}

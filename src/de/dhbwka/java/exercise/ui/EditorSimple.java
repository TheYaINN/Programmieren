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
        JMenuItem r�ckg�ngig = new JMenuItem("R�ckg�ngig");
        JMenuItem wiederholen = new JMenuItem("Wiederholen");
        JMenuItem ausschneiden = new JMenuItem("Ausschneiden");
        JMenuItem kopieren = new JMenuItem("Kopieren");
        JMenuItem officeablage = new JMenuItem("Office-Zwischneablage");
        JMenuItem einf�gen = new JMenuItem("Einf�gen");

        bearbeiten.add(r�ckg�ngig);
        bearbeiten.add(wiederholen);
        bearbeiten.addSeparator();
        bearbeiten.add(ausschneiden);
        bearbeiten.add(kopieren);
        bearbeiten.add(officeablage);
        bearbeiten.add(einf�gen);

        return bearbeiten;
    }

    private JMenu createDateiMenu() {
        JMenu datei = new JMenu("Datei");

        JMenuItem neu = new JMenuItem("Neu");
        JMenuItem �ffnen = new JMenuItem("�ffnen");
        JMenuItem schlie�en = new JMenuItem("schlie�en");
        JMenuItem speichern = new JMenuItem("speichern");
        JMenuItem speichernUnter = new JMenuItem("Speichern Unter");
        JMenuItem alsWebsiteSpeichern = new JMenuItem("Als Website Speichern");

        datei.add(neu);
        datei.add(�ffnen);
        datei.addSeparator();
        datei.add(schlie�en);
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

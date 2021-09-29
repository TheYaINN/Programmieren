package de.dhbwka.java.exercise.exams.snatchat;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class SnatChatWindow implements SnatChatFrontend {


    private final SnatChatRoom snatRoom;
    private final Account account;
    private ChatMessagesComponent chat;


    SnatChatWindow(SnatChatRoom sr, Account acc) {
        this.account = acc;
        this.snatRoom = sr;
        initGUI();
    }

    private void initGUI() {
        JFrame frame = new JFrame(account.getName() + "(" + snatRoom.getRoomName() + ")");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JLabel nameLabel = new JLabel(account.getName());
        nameLabel.setForeground(account.getChatColor());
        main.add(nameLabel, BorderLayout.NORTH);


        chat = new ChatMessagesComponent();
        main.add(chat, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(0, 1));
        JPanel upper = new JPanel();
        ButtonGroup btngrp = new ButtonGroup();
        for (State s : State.values()) {
            JRadioButton btn = new JRadioButton(s.state);
            if (account.getState() == s) {
                btn.setSelected(true);
            }
            btn.addActionListener(e -> {
                snatRoom.sendMessage("State of user" + account.getName() + "is now " + s.state);
                account.setState(s);
            });
            btngrp.add(btn);
            upper.add(btn);
        }

        JPanel lower = new JPanel();
        JTextField messageField = new JTextField();
        messageField.setPreferredSize(new Dimension(200, 35));
        lower.add(messageField);

        JButton send = new JButton("Send");
        send.addActionListener(e -> {
            String text = messageField.getText();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Dear " + account.getName() + ", please enter a message!", "Attentione!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Message msg = new Message(text, account);
                snatRoom.sendMessage(msg);
            }
            messageField.setText("");
        });
        lower.add(send);
        bottom.add(upper);
        bottom.add(lower);

        main.add(bottom, BorderLayout.SOUTH);
        frame.add(main);
        frame.setVisible(true);
        SwingUtilities.getRootPane(send).setDefaultButton(send);
    }

    @Override
    public void receiveMessage(final Message msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg.getAccount().getName());
        sb.append(": ");
        sb.append(msg.getMessage());
        JLabel text = new JLabel(sb.toString());
        text.setForeground(msg.getAccount().getChatColor());
        chat.add(text);
        countDown(text);
    }

    private void countDown(final JLabel text) {
        Thread t = new Thread(() -> {
            String oldText = text.getText();
            int counter = 30;
            while (counter > 0) {
                text.setText(oldText + String.format(" [ %s ]", counter));
                counter--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            chat.remove(text);
        });
        t.start();
    }

    @Override
    public void receiveMessage(final String text) {
        JLabel msg = new JLabel(text);
        msg.setForeground(Color.GRAY);
        chat.add(msg);
    }

    @Override
    public Account getAccount() {
        return null;
    }
}

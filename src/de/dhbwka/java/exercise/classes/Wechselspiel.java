package de.dhbwka.java.exercise.classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Wechselspiel extends JFrame {

    private static final int WINDOW_SIZE = 640;
    private static final int FIELD_SIZE = 10;
    private static final int ABOVE_CHECK_VALUE = 10;
    private static final int BELOW_CHECK_VALUE = -10;
    private static final int LEFT_CHECK_VALUE = 1;
    private static final int RIGHT_CHECK_VALUE = -1;
    private static final int AMOUNT_OF_VALID_FIELDS = 3;

    JPanel playField = new JPanel(new GridLayout(FIELD_SIZE, FIELD_SIZE));
    Color[] colors = {Color.RED, Color.yellow, Color.BLUE, Color.GREEN, Color.WHITE, Color.MAGENTA, Color.ORANGE};

    JLabel points;

    JButton select1;
    JButton select2;
    int playerPoints = 0;

    public Wechselspiel() {
        setTitle("Wechselspiel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        getContentPane().setLayout(new GridLayout(1, 1));
        setVisible(true);
        generatePlayField();
    }

    private void generatePlayField() {
        int num = 1;
        int charakter = 65;
        int cellNum = 0;
        for (int i = 1; i <= FIELD_SIZE; i++) {
            for (int j = 1; j <= FIELD_SIZE; j++) {
                if (i == 1 && j == 1) {
                    points = new JLabel("0", SwingConstants.CENTER);
                    points.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    playField.add(points);
                } else if (i == 1 && j != 1) {
                    final JLabel countChar = new JLabel("" + (char) charakter, SwingConstants.CENTER);
                    countChar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    playField.add(countChar);
                    charakter++;
                } else if (j == 1 && i != 1) {
                    final JLabel countChar = new JLabel("" + num, SwingConstants.CENTER);
                    countChar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    playField.add(countChar);
                    num++;
                } else {
                    final JButton cell = addButton(cellNum);
                    cell.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(final ActionEvent e) {
                            if (select1 != null) {
                                select2 = (JButton) e.getSource();
                            } else {
                                select1 = (JButton) e.getSource();
                            }
                            if (select1 != null && select2 != null) {
                                swapTiles();
                            }

                        }
                    });
                    playField.add(cell);
                }
                cellNum++;
            }
        }
        getContentPane().add(playField);
        revalidate();
    }

    private void swapTiles() {
        if (isNeighbour(select1, select2)) {
            final Color temp = select1.getBackground();
            select1.setBackground(select2.getBackground());
            select2.setBackground(temp);
        }
        select1 = null;
        select2 = null;
        checkForPoints();
    }

    private boolean isNeighbour(final JButton select1, final JButton select2) {
        final Component[] comps = playField.getComponents();
        boolean isNeighbouring = false;
        for (int i = 0; i < comps.length - 1; i++) {
            // check right
            if (comps[i].equals(select1) && comps[i + 1].equals(select2)) {
                isNeighbouring = true;
            }
            //check left
            else if (comps[i].equals(select1) && comps[i - 1].equals(select2)) {
                isNeighbouring = true;
            }
            // checkt above
            else if (comps[i].equals(select1) && comps[i - FIELD_SIZE].equals(select2)) {
                isNeighbouring = true;
            }
            // check below
            else if (comps[i].equals(select1) && comps[i + FIELD_SIZE].equals(select2)) {
                isNeighbouring = true;
            }
        }
        return isNeighbouring;
    }

    private void checkForPoints() {
        final Component[] comps = playField.getComponents();
        for (int i = 12; i < comps.length; i++) {
            final boolean[] aboveCheck = checkLine(i, comps[i].getBackground(), ABOVE_CHECK_VALUE);
            final boolean[] leftCheck = checkLine(i, comps[i].getBackground(), LEFT_CHECK_VALUE);
            final boolean[] rightCheck = checkLine(i, comps[i].getBackground(), RIGHT_CHECK_VALUE);
            final boolean[] belowCheck = checkLine(i, comps[i].getBackground(), BELOW_CHECK_VALUE);

            if (aboveCheck.length >= AMOUNT_OF_VALID_FIELDS) {
                for (int k = i; k < aboveCheck.length; k++) {
                    playField.getComponent(k - 10).setBackground(Color.BLACK);
                }
            } else if (leftCheck.length >= AMOUNT_OF_VALID_FIELDS) {
                for (int k = i; k < leftCheck.length; k++) {
                    playField.getComponent(k).setBackground(Color.BLACK);
                }
            } else if (rightCheck.length >= AMOUNT_OF_VALID_FIELDS) {
                setPoints(rightCheck.length);
                for (int k = i; k < i + rightCheck.length; k++) {
                    playField.getComponent(k).setBackground(Color.BLACK);
                }
            } else if (belowCheck.length >= AMOUNT_OF_VALID_FIELDS) {
                setPoints(belowCheck.length);
                for (int k = i; k < i + belowCheck.length * 10; k += 10) {
                    playField.getComponent(k).setBackground(Color.BLACK);
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            refill();
        }
        revalidate();
    }

    private void setPoints(final int length) {
        final int prevPoints = Integer.valueOf(points.getText());
        System.out.println("prev:" + prevPoints);
        final int newPoints = prevPoints + (length * 10);
        System.out.println("new: " + newPoints);
        points.setText(String.valueOf(newPoints));
    }

    private void refill() {
        for (int i = playField.getComponentCount() - 1; i >= 0; i--) {
            if (i < 21 && playField.getComponent(i).getBackground().equals(Color.BLACK)) {
                playField.getComponent(i).setBackground(getColor(i));
            } else if (playField.getComponent(i).getBackground().equals(Color.BLACK)) {
                final Color temp = playField.getComponent(i - 10).getBackground();
                playField.getComponent(i).setBackground(temp);
                playField.getComponent(i - 10).setBackground(Color.black);
            }
        }
    }

    private boolean[] checkLine(final int cellNum, final Color background, final int stepSize) {
        final boolean[] line;
        int amountTrue = 0;
        final int linelength = getLineLength(cellNum, stepSize);

        for (int j = 0; j < linelength; j++) {
            if (!checkColor(cellNum, background, stepSize * j)) {
                amountTrue += 1;
            } else {
                break;
            }
        }
        line = new boolean[amountTrue];
        for (int j = 0; j < amountTrue; j++) {
            line[j] = true;
        }
        return line;
    }

    private int getLineLength(final int cellNum, final int directionFromStepSize) {
        int lineLength = 0;
        for (int i = 0; i <= 5; i++) {
            // Check above
            if (directionFromStepSize == 10 && cellNum - Math.abs(i * directionFromStepSize) > 10 &&
                    playField.getComponent(cellNum - Math.abs(i * directionFromStepSize)) != null) {
                lineLength++;
            }
            // Check Below
            else if (directionFromStepSize == -10 && cellNum + Math.abs(i * directionFromStepSize) < 100 &&
                    playField.getComponent(cellNum + Math.abs(i * directionFromStepSize)) != null) {
                lineLength++;
            }
            //Check Right
            else if (directionFromStepSize == -1 && cellNum + Math.abs(i * directionFromStepSize) < 100 &&
                    playField.getComponent(cellNum - Math.abs(i * directionFromStepSize)) != null) {
                lineLength++;
            }
            // Check Left
            else if (directionFromStepSize == 1 && cellNum - Math.abs(i * directionFromStepSize) > 10 &&
                    playField.getComponent(cellNum - Math.abs(i * directionFromStepSize)) != null) {
                lineLength++;
            }
        }
        return lineLength;
    }

    private JButton addButton(final int cellNum) {
        final JButton cell = new JButton("");
        cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        cell.setBackground(getColor(cellNum));
        return cell;
    }

    private Color getColor(final int cellNum) {
        boolean getOut = false;
        Color color = null;
        while (!getOut) {
            color = colors[(int) Math.floor(Math.random() * 7)];
            if (colorIsNotGiven(cellNum, color)) {
                getOut = true;
            }
        }
        return color;
    }

    private boolean colorIsNotGiven(final int cellNum, final Color col) {
        boolean colorIsNotGiven = false;
        boolean colorIsNotGivenAbove = false;
        boolean colorIsNotGivenLeft = false;

        if (cellNum < 31) {
            if (checkColor(cellNum, col, ABOVE_CHECK_VALUE)) {
                colorIsNotGivenAbove = true;
            }
            if (checkColor(cellNum, col, LEFT_CHECK_VALUE)) {
                colorIsNotGivenLeft = true;
            }
        } else {
            if (checkColor(cellNum, col, ABOVE_CHECK_VALUE) && checkColor(cellNum, col, ABOVE_CHECK_VALUE * 2)) {
                colorIsNotGivenAbove = true;
            }
            if (checkColor(cellNum, col, LEFT_CHECK_VALUE) && checkColor(cellNum, col, LEFT_CHECK_VALUE * 2)) {
                colorIsNotGivenLeft = true;
            }
        }

        if (colorIsNotGivenAbove && colorIsNotGivenLeft) {
            colorIsNotGiven = true;
        }
        return colorIsNotGiven;
    }

    private boolean checkColor(final int cellNum, final Color col, final int stepSize) {
        if (cellNum % 10 == 0) {
            return true;
        }
        if (cellNum < 11 && stepSize > 1) {
            return true;
        } else {
            return !playField.getComponents()[cellNum - stepSize].getBackground().equals(col) ? true : false;
        }
    }

    public static void main(final String[] args) {
        new Wechselspiel();
    }
}

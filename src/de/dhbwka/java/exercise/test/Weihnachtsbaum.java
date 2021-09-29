package de.dhbwka.java.exercise.test;

import java.util.Scanner;

public class Weihnachtsbaum {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Größe ein: ");
        int h = sc.nextInt(); // größen eingabe
        System.out.println("Soll der Baum Kerzen haben? (j/n)");
        String lichter = sc.next();
        System.out.println("Soll der Baum Christbaumkugeln haben? (j/n)");
        String kugeln = sc.next();
        System.out.println("Geben Sie den prozentualen Anteil an Kugeln an:");
        int prozent = 0;
        int kugelcount = 0;
        prozent = sc.nextInt();
        sc.close();

        char[][] baum = new char[h][h]; //Erstellt Array
        int wirdgroesser = 0;
        char bonus1 = '#';
        int count = 0;
        int index = 0;
        int abschnitt = (h - 1) / 3;
        boolean lichterbool = false;
        boolean kugelnbool = false;

        /**
         *  Zeichnet einen Baum der Größe h, die oben abgefragt wurde
         */

        // füllt alle felder
        for (int i = 0; i < baum.length; i++) {
            count = 0;
            for (int filltop = 0; filltop < baum.length; filltop++) {
                baum[i][filltop] = ' ';
            }

            // Füllt die mitte mit # + 1 je reiher, jede 3 auf 0 gesetzt
            for (int j = ((baum.length / 2) - wirdgroesser - index); j < ((baum.length / 2) + 1 + wirdgroesser + index); j++) {
                baum[i][j] = '#';
            }

            /**
             *   Erstellt den Baumstamm
             */

            // Guckt ob es die letzte zeile der Zeichnung ist
            if (i >= baum.length - (h % abschnitt)) {
                // Füllt alles mit .
                for (int fillstamm = 0; fillstamm < baum.length; fillstamm++) {
                    baum[i][fillstamm] = ' ';
                }

                // Füllt die mitte mit #
                if (h % 2 == 0) {
                    for (int stamm = (h / 2) - (abschnitt / 2); stamm < (h / 2) + (abschnitt / 2); stamm++) {
                        baum[i][stamm] = '#';
                    }
                } else {
                    for (int stamm = (h / 2) - (abschnitt / 2); stamm < (h / 2) + (abschnitt / 2); stamm++) {
                        baum[i][stamm] = '#';
                    }
                }
            }

            /**
             * Macht den Baum im ein Zeichen zu beiden Seiten größer
             */
            if (wirdgroesser < abschnitt - 1) {
                wirdgroesser = wirdgroesser + 1;

            } else {
                index = index + 1;
                wirdgroesser = 0;
            }

            /**
             * Setzt die Kerzen auf der Linken Seite
             */
            if (lichter.equals("j")) {
                lichterbool = true;
                if (i < baum.length - 1) {
                    for (int checkhash1 = 0; checkhash1 < h; checkhash1++) {
                        for (int checkhash2 = 0; checkhash2 < baum.length - 1; checkhash2++) {
                            if (baum[checkhash1][checkhash2] == ' ' && baum[checkhash1][checkhash2 + 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 + 1] = 'i';
                                break;
                            }
                        }
                    }
                }

                /**
                 * Setzt die Kerzen auf der Rechten Seite
                 */
                if (i < baum.length - 1) {
                    for (int checkhash1 = 0; checkhash1 < h; checkhash1++) {
                        for (int checkhash2 = baum[i].length - 1; checkhash2 > 1; checkhash2--) {
                            if (baum[checkhash1][checkhash2] == ' ' && baum[checkhash1][checkhash2 - 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 - 1] = 'i';
                                break;
                            }
                        }
                    }
                }
            } else {
                lichterbool = false;
            }
            /**
             * Setzt Christkugeln
             */
            if (kugeln.equals("j")) {
                kugelnbool = true;
                if (i < baum.length - 1 && i != 0) {
                    for (int checkhash1 = 0; checkhash1 < h; checkhash1++) {
                        for (int checkhash2 = 0; checkhash2 < baum.length - 1; checkhash2++) {
                            if (baum[checkhash1][checkhash2] == 'i' && baum[checkhash1][checkhash2 + 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 + 1] = 'O';
                                break;
                            } else if (baum[checkhash1][checkhash2] == ' ' && baum[checkhash1][checkhash2 + 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 + 2] = 'O';
                                break;
                            }
                        }
                    }
                }
                if (i < baum.length - 1) {
                    for (int checkhash1 = 0; checkhash1 < h; checkhash1++) {
                        for (int checkhash2 = baum[i].length - 1; checkhash2 > 1; checkhash2--) {
                            if (baum[checkhash1][checkhash2] == 'i' && baum[checkhash1][checkhash2 - 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 - 1] = 'O';
                                break;
                            } else if (baum[checkhash1][checkhash2] == ' ' && baum[checkhash1][checkhash2 - 1] == bonus1 && checkhash1 % abschnitt != 0) {
                                baum[checkhash1][checkhash2 - 2] = 'O';
                                break;
                            }
                        }
                    }
                }
            } else {
                kugelnbool = false;
            }
        }
        for (int counter = 0; counter < h; counter++) {
            for (int counter1 = 0; counter1 < h; counter1++) {
                if (baum[counter][counter1] == '#') {
                    count = count + 1;
                }
            }
        }
        if (prozent != 0) {
            for (int kugelnprozent = 0; kugelnprozent < h; kugelnprozent++) {
                for (int kugelnprozent2 = 0; kugelnprozent2 < h; kugelnprozent2++) {
                    if (baum[kugelnprozent][kugelnprozent2] == bonus1 && kugelcount < ((prozent * count) / 100)) {
                        int wahrscheinlichkeit = (int) Math.round(Math.random() * Math.floor(1));
                        if (wahrscheinlichkeit == 1) {
                            baum[kugelnprozent][kugelnprozent2] = 'O';
                            kugelcount = kugelcount + 1;
                        } else if (wahrscheinlichkeit == 0) {
                            baum[kugelnprozent][kugelnprozent2] = 'o';
                            kugelcount = kugelcount + 1;
                        }
                    }
                }
            }
        }

        //Ausgabe des Baumes
        System.out.println();
        for (int aus = 0; aus < h; aus++) {
            for (int aus1 = 0; aus1 < h; aus1++) {
                System.out.print(baum[aus][aus1]);
            }
            System.out.println();
        }
        if (lichterbool && kugelnbool) {
            System.out.println("Der Baum ist " + h + " Felder groß.");
        } else if (!lichterbool && kugelnbool) {
            System.out.println("Der Baum ist " + h + " Felder groß.");
            System.out.println("und der Baum sollte keine Lichter haben");
        } else if (!kugelnbool && lichterbool) {
            System.out.println("Der Baum ist " + h + " Felder groß.");
            System.out.println("und der Baum sollte keine Kugeln haben");
        } else {
            System.out.println("Der Baum ist " + h + " Felder groß.");
            System.out.println("und der Baum sollte keine Lichter haben");
            System.out.println("und der Baum sollte keine Kugeln haben");
        }
    }
}

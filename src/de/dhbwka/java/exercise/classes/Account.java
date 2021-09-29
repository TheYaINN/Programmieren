package de.dhbwka.java.exercise.classes;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Account {

    private static final String COUNTRY_CODE = "DE";
    static Map<String, Account> accounts = new LinkedHashMap<>();

    static Scanner sc = new Scanner(System.in);

    String title;
    String name;
    String lastName;
    String accountNumber;
    BigDecimal value;
    BigDecimal limit = BigDecimal.valueOf(1000);

    public Account(final String title, final String name, final String lastName, final BigDecimal value, final String accountNumber) {
        this.title = title;
        this.name = name;
        this.lastName = lastName;
        this.value = value;
        this.accountNumber = accountNumber;
    }

    public void setLimit(final int newLimit) {
        limit = BigDecimal.valueOf(newLimit);
    }

    public void deposit(final int depositValue) {
        value = value.add(BigDecimal.valueOf(depositValue));
    }

    public void withdraw(final int withdrawValue) {
        if (value.subtract(BigDecimal.valueOf(withdrawValue)).compareTo(BigDecimal.valueOf(0)) < 0 || limit.compareTo(BigDecimal.valueOf(withdrawValue)) < 0) {
            System.out.println("So viel Guthaben haben Sie nicht oder es ist über Ihrem Limit");
        } else {
            value = value.subtract(BigDecimal.valueOf(withdrawValue));
        }
    }

    public String getMoney() {
        return value + "€";
    }

    public String getLimit() {
        return limit + "€";
    }

    public void getValue() {
        System.out.println(toString());
    }

    public static void getAccounts() {
        for (final Account acc : accounts.values()) {
            acc.getValue();
        }
    }

    private static String generateID() {
        return String.join("-", COUNTRY_CODE, UUID.randomUUID().toString().replaceAll("-", "").substring(0, 12));
    }

    @Override
    public String toString() {
        if (value.compareTo(BigDecimal.valueOf(0)) > 0) {
            return title + " " + name + " " + lastName + ", ihr Guthaben beträgt: " + getMoney() + ", und ihre Kontonummer lautet: " + accountNumber +
                    ", Ihr Limit ist: " + getLimit();
        } else {
            return title + " " + name + " " + lastName + " ihre Schulden betragen: " + getMoney() + ", und ihre Kontonummer lautet: " + accountNumber +
                    ", Ihr limit ist: " + getLimit();
        }
    }

    public static void createAccount() {
        System.out.println("Bitte geben Sie ihre Ansprache an: ");
        final String title = sc.next();
        System.out.println("Bitte geben Sie ihren Vornamen an: ");
        final String name = sc.next();
        System.out.println("Bitte geben Sie ihren Nachnamen an: ");
        final String lastName = sc.next();
        System.out.println("Bitte geben Sie ihr Guthaben an: ");
        BigDecimal value = BigDecimal.valueOf(sc.nextInt());
        if (value.compareTo(BigDecimal.valueOf(0)) < 0) {
            System.out.println("Sie können kein negatives Guthaben eingeben, ihr Guthaben wurde auf 0 gesetzt.");
            value = BigDecimal.valueOf(0);
        }
        final String ID = generateID();
        final Account account = new Account(title, name, lastName, value, ID);
        accounts.put(ID, account);
        System.out.println("Benutzer wurd erfolgreich erstellt! mit der ID: " + ID);
    }

    private static void changeAccountSettings(final Account account) {
        boolean close = false;
        int choice;
        while (!close) {
            System.out.println(account.name + ", was wollen sie tun?");
            System.out.println("Guthaben ansehen: 1");
            System.out.println("Geld einzahlen: 2");
            System.out.println("Geld abheben: 3");
            System.out.println("Limit neu setzen: 4");
            System.out.println("Zurück in das Hauptmenu: 5");
            choice = sc.nextInt();
            if (choice == 1) {
                account.getValue();
            } else if (choice == 2) {
                System.out.println("Bitte geben Sie den Betrag ein, den Sie einzahlen wollen: ");
                account.deposit(sc.nextInt());
                System.out.println("Ihr neues Guthaben beträgt: " + account.getMoney());
            } else if (choice == 3) {
                System.out.println("Bitte geben Sie den Betrag ein, den Sie abheben wollen: ");
                account.withdraw(sc.nextInt());
                System.out.println("Ihr neues Guthaben beträgt: " + account.getMoney());
            } else if (choice == 4) {
                System.out.println("Ihr aktuelles Limit beträgt: " + account.getLimit());
                System.out.println("Bitte geben Sie ihr neues Limit ein:");
                account.setLimit(sc.nextInt());
                System.out.println("Ihr neues Limit beträgt: " + account.getLimit());
            } else {
                close = true;
                mainMenu();
            }
        }

    }

    private static void mainMenu() {
        boolean close = false;
        int choice;
        while (!close) {
            System.out.println("--- Main Menu ---");
            System.out.println("Benutzer Erstellen: 1");
            System.out.println("Benutzerliste ansehen: 2");
            System.out.println("Benutzer ändern: 3");
            System.out.println("Programm beenden: 4");
            choice = sc.nextInt();
            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                getAccounts();
            } else if (choice == 3) {
                System.out.println("Bitte geben Sie die Kontonummer an: ");
                final String AN = sc.next();
                final Account acc = accounts.get(AN);
                if (acc != null) {
                    changeAccountSettings(accounts.get(AN));
                } else {
                    System.out.println("Es wurde kein Benutzer mit dieser ID gefunden.");
                }

            } else {
                close = true;
            }
        }

    }

    public static void main(final String... args) {
        mainMenu();
    }
}

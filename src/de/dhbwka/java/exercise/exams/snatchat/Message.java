package de.dhbwka.java.exercise.exams.snatchat;

public class Message {

    private String message;
    private Account account;

    Message(String msg, Account acc) {
        message = msg;
        this.account = acc;
    }

    public static String Rot13(String message) {
        char[] msgArr = message.toCharArray();
        for (int i = 0; i < msgArr.length; i++) {
            char c = msgArr[i];
            if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
                msgArr[i] = (char) (c + 13);
            } else if (c >= 'N' && c <= 'Z' || c >= 'n' && c <= 'z') {
                msgArr[i] = (char) (c - 13);
            }
        }
        return new String(msgArr);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }
}

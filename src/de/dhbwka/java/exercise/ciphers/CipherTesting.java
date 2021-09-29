package de.dhbwka.java.exercise.ciphers;

public class CipherTesting {

    public static void main(String[] args) {
        String testMsg = "This is a cryptic message";
        String testMsg2 = "These messages are for testing purposes";
        String testMsg3 = "Finally I think it is working";
        System.out.println(testMsg);
        String caesarEnc = CaesarCipher.encrypt(testMsg3, 2);
        System.out.println(caesarEnc);
        String caesarDec = CaesarCipher.decrypt(caesarEnc, 2);
        System.out.println(caesarDec);

/*
        String vigenereEnc = VigenereCipher.encrypt(testMsg, "MYPRIVATEKEY");
        System.out.println(vigenereEnc);
        String vigenereDec = VigenereCipher.decrypt(vigenereEnc, "MYPRIVATEKEY");
        System.out.println(vigenereDec);
*/

    }

}

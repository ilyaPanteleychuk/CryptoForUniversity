package org.example;

public class App {
    public static void main(String[] args) {
       String a = VigenereCipher.encrypt("I am in love with a fairytale", "Hogwarts", Language.EN);
        System.out.println(a);
    }
}
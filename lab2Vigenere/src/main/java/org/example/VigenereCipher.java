package org.example;

import java.util.List;

public class VigenereCipher {

    /**
     * Метод виконує шифрування тексту за шифром Вегенера.
     * @param plaintext - текст який потрібно зашифрувати
     * @param key - ключ для шифрування
     * @param lang - мова щоб обрати алфавіт
     * @return - шифрований текст
     */
    public static String encrypt(String plaintext, String key, Language lang) {
        key = key.toUpperCase();
        List<Character> alphabet = AlphabetHelper.getAlphabet(lang);
        StringBuilder finalText = new StringBuilder();
        int keyIndexCounter = 0;
        // починаємо ітеруватись по тексту
        for (int i = 0; i < plaintext.length(); i++) {
            //беремо перший символ та кастимо його у верхній регістр
            char plainChar = plaintext.charAt(i);
            boolean isUpperCase = Character.isUpperCase(plainChar);
            plainChar = Character.toUpperCase(plainChar);
            //перевіряємо якщо символ є в алфавіті. Якщо немає - додаємо без зміни
            if (alphabet.contains(plainChar)) {
                // тепер на кожний символ нашого тексту знаходимо відповідну заміну в слові ключі
                // запам'ятовуємо індекси та зсовуємо символ
                char keyChar = key.charAt(keyIndexCounter % key.length());
                int plainIndex = alphabet.indexOf(plainChar);
                int keyIndex = alphabet.indexOf(keyChar);
                int searchIndex = (plainIndex + keyIndex) % alphabet.size();
                char encryptedChar = alphabet.get(searchIndex);
                if (isUpperCase) {
                    finalText.append(encryptedChar);
                } else {
                    finalText.append(Character.toLowerCase(encryptedChar));
                }
                keyIndexCounter++;
            } else {
                finalText.append(plainChar);
            }
        }
        return finalText.toString();
    }
}

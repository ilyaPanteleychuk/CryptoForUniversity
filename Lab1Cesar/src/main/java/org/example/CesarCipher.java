package org.example;

import java.util.List;

public class CesarCipher {

    /**
     * Даний метод обробляє текст та в залежності від параметру 'ecrypt' шифрує або дешифрує його за Шифром Цезаря.
     * @param text - текст який ви хочете защифрувати/дешифрувати
     * @param shift - ключ (зсув) який показує на скільки символів потрібно переміщувати літеру
     * @param lang - мова на якій написаний текст (щоб правильно брати алфавіт)
     * @param encrypt - логічний параметр: якщо true тоді іде шифрація, якщо false то дешифрація
     * @return шифрований або дешифрований текст
     */
    public static String process(String text, int shift, Language lang, boolean encrypt) {
        // в залежності від мови беремо алфавіт
        List<Character> alphabet = AlphabetHelper.getAlphabet(lang);
        // змінна яка буде збирати весь текст
        StringBuilder finalText = new StringBuilder();
        // ітеруємось по кожному символу в тексті та в залежності від параметру зсуву (shift)
        // - беремо відповідний символ з алфавіту та додаємо у фінальний текст
        for (char currentChar : text.toCharArray()) {
            // якщо символ не є літерою то просто додаємо в текст без змін
            if (Character.isLetter(currentChar)) {
                char shiftedChar = findShiftedChar(alphabet, currentChar, shift, encrypt);
                finalText.append(Character.isLowerCase(currentChar) ? Character.toLowerCase(shiftedChar) : shiftedChar);
            } else {
                finalText.append(currentChar);
            }
        }
        return finalText.toString();
    }

    /**
     * Метод шукає відповідну літеру по алфавіту в залежності від параметру shift
     * @param alphabet - алфавіт
     * @param currentChar - літера яку потрібно зсунути
     * @param shift - показує на скільки потрібно зсунути
     * @param encrypt - в залежності від цього параметра ми або робино шифрацію або дешифрацію
     * @return літеру на яку змінюємо стару
     */
    private static char findShiftedChar(List<Character> alphabet, char currentChar, int shift, boolean encrypt) {
        char upperChar = Character.toUpperCase(currentChar);
        int indexInAlphabet = alphabet.indexOf(upperChar);
        int searchIndex = (indexInAlphabet + (encrypt ? shift : -shift) + alphabet.size()) % alphabet.size();
        if (searchIndex < 0) {
            searchIndex += alphabet.size();
        }
        return alphabet.get(searchIndex);
    }
}

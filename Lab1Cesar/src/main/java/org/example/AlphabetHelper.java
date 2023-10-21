package org.example;

import java.util.Collections;
import java.util.List;

public class AlphabetHelper {

    public static final  List<Character> UKR_ALPHABET = List.of(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
            'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    );

    public static final List<Character> EN_ALPHABET = List.of(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    );

    public static List<Character> getAlphabet(Language lang) {
        switch (lang) {
            case EN: return EN_ALPHABET;
            case UKR: return UKR_ALPHABET;
            default: return Collections.emptyList();
        }
    }
    
    

}

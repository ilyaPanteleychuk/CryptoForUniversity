package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CesarCipherTest {

    @Test
    public void testFirstCase() {
        String expected = "Ztte ndjg ugxtcsh radht, qji ndjg tctbxth radhtg.";
        String textToEncrypt = "Keep your friends close, but your enemies closer.";
        String actual =  CesarCipher.process(textToEncrypt, 15, Language.EN, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testSecondCase() {
        String textToEncrypt = "Cryptography is the practice and " +
                                "study of techniques for secure " +
                                "communication in the presence of " +
                                "third parties called adversaries.";
        String expected = "Vkrimhzktiar bl max iktvmbvx " +
                          "tgw lmnwr hy mxvagbjnxl yhk " +
                          "lxvnkx vhffngbvtmbhg bg max " +
                          "ikxlxgvx hy mabkw itkmbxl " +
                          "vteexw twoxkltkbxl.";
        String actual =  CesarCipher.process(textToEncrypt, -7, Language.EN, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testThirdCase() {
        String textToEncrypt = "Украй простий приклад " +
                               "симетричного шифрування — " +
                               "шифр підстановки.";
        String expected = "Жядою ґдгеєшю ґдшяаоу " +
                          "ешбфєдшївгсг йшзджроввн — " +
                          "йшзд ґщуеєовгряш.";
        String actual =  CesarCipher.process(textToEncrypt, 18, Language.UKR, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testFourthCase() {
        String textToEncrypt = "Наука про математичні методи " +
                               "забезпечення конфіденційності, " +
                               "цілісності і автентичності інформації.";
        String expected = "Їшозш клй ішнбішндтїе ібнйад " +
                          "ґшщбґкбтбїїч зйїпеабїсежїймне, " +
                          "сеиемїймне е шьнбїндтїймне еїпйлішсеє.";
        String actual =  CesarCipher.process(textToEncrypt, -5, Language.UKR, true);
        assertEquals(expected, actual);
    }

    @Test
    public void testDecrypt() {
        String textToDecrypt = "Їшозш клй ішнбішндтїе ібнйад " +
                "ґшщбґкбтбїїч зйїпеабїсежїймне, " +
                "сеиемїймне е шьнбїндтїймне еїпйлішсеє.";
        String expected = "Наука про математичні методи " +
                "забезпечення конфіденційності, " +
                "цілісності і автентичності інформації.";
        String actual = CesarCipher.process(textToDecrypt, -5, Language.UKR, false);
        assertEquals(expected, actual);
    }
}

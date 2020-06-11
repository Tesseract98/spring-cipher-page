package org.cypherpage.spring_page.criptoalgorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VernamCipherTest {

    private String text = "some message; некоторое сообщение, 123";

    private String allAlphabetAndSymbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            "1234567890-=`~!@#$%^&*()_+";

    @Test
    void encryptDecrypt() {
        VernamCipher cipher = new VernamCipher();
        String encryptTxt = cipher.encrypt(text);
        System.out.println(encryptTxt);
        assertEquals(text, cipher.decrypt(encryptTxt));
    }

    @Test
    void encryptDecryptFull() {
        VernamCipher cipher = new VernamCipher();
        String encryptTxt = cipher.encrypt(allAlphabetAndSymbols);
        System.out.println(encryptTxt);
        assertEquals(allAlphabetAndSymbols, cipher.decrypt(encryptTxt));
    }

}
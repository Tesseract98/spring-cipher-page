package org.cypherpage.spring_page.controllers;

import org.cypherpage.spring_page.criptoalgorithm.VernamCipher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/cipher")
public class CipherController {

    private VernamCipher cipher;

    @GetMapping
    public String getCipherPage(Model model) {
        return "cipher";
    }

    @PostMapping()
    public String encryptDecrypt(HttpServletRequest request, Model model) {
        String decipherText = request.getParameter("decipherText");
        String cipherText = request.getParameter("cipherText");
        String submit = request.getParameter("submit");
        String reset = request.getParameter("reset");

        cipher = new VernamCipher();

        if (submit != null) {
            if (submit.equals("0")) {
                model.addAttribute("decipherText", decipherText);
                model.addAttribute("cipherText", cipher.encrypt(decipherText));
            } else {
                model.addAttribute("decipherText", cipher.decrypt(cipherText));
                model.addAttribute("cipherText", cipherText);
            }
        }

        if (reset != null) {
            switch (reset) {
                case "0":
                    model.addAttribute("decipherText", "");
                    model.addAttribute("cipherText", cipherText);
                    break;
                case "1":
                    model.addAttribute("decipherText", decipherText);
                    model.addAttribute("cipherText", "");
                    break;
            }
        }

        return "cipher";
    }

}

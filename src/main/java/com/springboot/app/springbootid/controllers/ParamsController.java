package com.springboot.app.springbootid.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    //PUEDE OBTENER LOS PARAMS POR LA URL
    @GetMapping("/string")
    public String param(@RequestParam(name = "texto_entrada", required = false, defaultValue = "defaultValue") String texto_entrada, Model model) {
        model.addAttribute("resultado", "el texto enviado es: " + texto_entrada);
        return "params/ver";
    }

    //mandar varios params
    @GetMapping("/mix-params")
    public String param(String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("resultado", "el texto enviado es: " + saludo + " y el numero es " + numero);
        return "params/ver";
    }

    //alternativa a mix-params con HttpServletRequest
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("resultado", "el texto enviado es: " + saludo + " y el numero es " + numero);
        return "params/ver";
    }
}

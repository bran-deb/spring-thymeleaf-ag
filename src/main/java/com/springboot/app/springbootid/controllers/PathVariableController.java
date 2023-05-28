package com.springboot.app.springbootid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableController {

    //INDEX PARA ESCRIBIR LAS URL Y ENVIAR LOS PARAMS
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
        //DATOS A MANDAR EN THYMELEAF(SE PUEDEN MANDAR POR URL)
        model.addAttribute("saludo", "Que tal ");
        model.addAttribute("number", 9);
        return "variables/index";
    }

    //PUEDE OBTENER LOS PARAMS POR LA URL (RECOMENDADO)
    @GetMapping("/string/{texto1}")
    public String variable(
            @PathVariable(name = "texto1") String texto1,
            Model model
    ) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto1);
        return "variables/ver";
    }

    //ENVIÓ DE DOS PARAMS EN LA RUTA
    @GetMapping("/string/{texto}{numero}")
    public String variables(
            @PathVariable(name = "texto") String texto,
            @PathVariable(name = "numero") Integer numero,
            Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
        model.addAttribute("texto", "El texto es :".concat(texto));
        model.addAttribute("numero", "El numero es :" + numero);

        return "variables/ver";
    }
}

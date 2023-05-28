package com.springboot.app.springbootid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //USO DE FORWARD PARA REDIRECCIONAR SIN REFRESH(FORWARD NO CAMBIA VALOR DE RUTA)
    @GetMapping("/")
    public String RedirectSinRefresh() {
        return "forward:/api/";
    }

    //REDIRECTION A GOOGLE CON REFRESH(REDIRECT)
    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:https://www.google.com";
    }
}

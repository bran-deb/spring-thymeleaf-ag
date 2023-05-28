package com.springboot.app.springbootid.controllers;

import com.springboot.app.springbootid.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api") //RUTA BASE
public class IndexController {

    @Value("${texto.index_controller.index.titulo}")    //INJECT VALUE TEXT
    private String textoIndex;
    @Value("{texto.index_controller.perfil.titulo}")    //INJECT VALUE PERFIL
    private String textoPerfil;
    @Value("{texto.index_controller.listar.titulo}")    //INJECT VALUE LISTAR
    private String textoListar;

    //        @RequestMapping(value = "/index",method = RequestMethod.GET)
    @GetMapping({"/", ""})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String user(Model model) {
        User usuario = new User();
        usuario.setNombre("Pedrete");
        usuario.setApellido("Pedral");
        usuario.setEmail("pedrete.@email.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        List<User> userList = Arrays.asList(
                new User("Andres", "Pedral", "adres@pedral.com"),
                new User("Pedrete", "pedrales", "pedrete@pedral.com"),
                new User("Rafa", "Perez", "rafa@perez.com"),
                new User("john", "Doe", "john@doe.com")
        );
        /* List<User> userList = new ArrayList<>();
        userList.add(new User("Andres", "Pedral", "adres@pedral.com"));
        userList.add(new User("Pedrete", "pedrales", "pedrete@pedral.com"));
        userList.add(new User("Rafa", "Perez", "rafa@perez.com"));*/
        model.addAttribute("titulo", textoListar);
        model.addAttribute("userList", userList);
        return "listar";
    }

    //alternativa a @RequestMapping("/listar")
    @ModelAttribute("usuariosList") //nombre con el que se pasa ala vista
    public List<User> poblarUsuarios() {
        List<User> userList = Arrays.asList(
                new User("Andres", "Pedral", "adres@pedral.com"),
                new User("Pedrete", "pedrales", "pedrete@pedral.com"),
                new User("Rafa", "Perez", "rafa@perez.com"),
                new User("john", "Doe", "john@doe.com")
        );
        return userList;    //retorna el objeto
    }

/*
    ALTERNATIVAS DE USO
    @GetMapping({"/", "", "/index"})
    public String index(ModelMap model) {
        model.addAttribute("titulo", "hola spring framework!");
        return "index";
    }

    @GetMapping({"/", "", "/index"})
    public String index(Map<String, Object> map) {
        map.put("titulo", "hola spring framework con map xd");
        return "index";
    }

    @GetMapping({"/", "", "/index"})
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("titulo", "hola spring framework con model and view xd");
        mv.setViewName("index");
        return mv;
    }*/
}

package com.vzla.jc.web;

import com.vzla.jc.domain.Persona;
import com.vzla.jc.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    
    public String inicio(Model model) {
        
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el controlador Spring MVC");

        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    //Se mapeo la ruta al formulario con la accion Guardar
    @PostMapping("/guardar")
    //Se crea el metodo guardar con el argumento de tipo persona
    //Se invoca la interface Persona.service para que guarde los registros
    //Se retorna a la pagina de inicio con "redirect:/"
    public String guardar (Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
}

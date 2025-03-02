package com.crudSpringBoolWEBc.Controller;

import com.crudSpringBoolWEBc.Dto.PersonaDto;
import com.crudSpringBoolWEBc.Entity.Persona;
import com.crudSpringBoolWEBc.Service.PersonaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/persona", "/"})
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    PersonaServicioImpl personaServicio;

    /**
     * Metodo para obtener todas las personas
     * @param modelo
     * @return la vista persona
     */
    @GetMapping
    public String getPersona(Model modelo, @Param("palabraClave") String palabraClave) {
        modelo.addAttribute("personas", personaServicio.findAll(palabraClave));
        modelo.addAttribute("palabraClave", palabraClave);
        return "persona";
    }

    /**
     *
     * @param modelo
     * @return la vista de persona
     */
    @GetMapping("/nueva")
    public String nuevaPersona(Model modelo){
        modelo.addAttribute("persona", new Persona());
        return "nueva";
    }


    @PostMapping("/nueva")
    public String savePersona(@ModelAttribute("persona") @Validated Persona persona, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model modelo){
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("persona", persona);
            return "nueva";
        }
        personaServicio.savePersona(persona);
        redirectAttributes.addFlashAttribute("msgExito", "Persona guardada con exito");
        return "redirect:/persona";

    }

    @GetMapping("/editar/{id}")
    public String editPersona(@PathVariable Integer id, Model modelo){
        modelo.addAttribute("persona", personaServicio.buscarPersona(id));
        return "nueva";
    }

    @PostMapping("/editar/{id}")
    public String updatePersona(@PathVariable Integer id, @ModelAttribute("persona") @Validated Persona persona,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes, Model modelo){
        Persona p = personaServicio.buscarPersona(id);

        if (bindingResult.hasErrors()) {
            modelo.addAttribute("persona", persona);
            return "nueva";
        }
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            p.setCorreo(persona.getCorreo());
            p.setFecha_nacimiento(persona.getFecha_nacimiento());

            personaServicio.savePersona(p);
            redirectAttributes.addFlashAttribute("msgExito", "Se ha actualizado el registro correctamente");
            return "redirect:/persona";

    }

    @PostMapping("eliminar/{id}")
    public String deletePersona(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        personaServicio.deletePersona(id);
        redirectAttributes.addFlashAttribute("msgExito", "El registro ha sido eliminado correctamente");
        return "redirect:/persona";
    }
}

package com.crudSpringBoolWEBc.Service;

import com.crudSpringBoolWEBc.Entity.Persona;
import com.crudSpringBoolWEBc.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicioImpl {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> findAll(String palabraClave) {
        if (palabraClave != null) {
            return personaRepository.findAll(palabraClave);
        }
        return personaRepository.findAll();
    }

    public void savePersona(Persona persona) {
        personaRepository.save(persona);

    }
    public Persona buscarPersona(Integer id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            return personaOptional.get();
        } else {
            throw new RuntimeException("Persona no encontrada");
        }
    }

    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

}

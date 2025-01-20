package br.com.spring.erudio.api_gateway.controllers;

import br.com.spring.erudio.api_gateway.dto.PersonDTO;
import br.com.spring.erudio.api_gateway.model.Person;
import br.com.spring.erudio.api_gateway.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    //produces = MediaType.APPLICATION_JSON_VALUE por conta do swagger
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<PersonDTO> persons = personServices.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        var persons = personServices.findById(id);
        return ResponseEntity.ok().body(persons);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        var entity = personServices.create(personDTO);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Long id) {
        var entity = personServices.update(id, personDTO);
        return ResponseEntity.accepted().body(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}

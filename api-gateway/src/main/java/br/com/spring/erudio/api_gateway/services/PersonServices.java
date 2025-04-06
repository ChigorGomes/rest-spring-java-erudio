package br.com.spring.erudio.api_gateway.services;

import br.com.spring.erudio.api_gateway.controllers.PersonController;
import br.com.spring.erudio.api_gateway.dto.v1.PersonDTO;
import br.com.spring.erudio.api_gateway.dto.v2.PersonDTOV2;
import br.com.spring.erudio.api_gateway.exceptions.ResourceNotFoundException;
import br.com.spring.erudio.api_gateway.mapper.ModelMap;
import br.com.spring.erudio.api_gateway.mapper.custom.PersonMapper;
import br.com.spring.erudio.api_gateway.model.Person;
import br.com.spring.erudio.api_gateway.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonServices {

    private final PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO create(PersonDTO personDTO) {
        var entity = ModelMap.parseObject(personDTO, Person.class);
        var entitySave = personRepository.save(entity);
        var dto = ModelMap.parseObject(entitySave, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public List<PersonDTO> findAll() {
        var persons = personRepository.findAll();
        var personDTOList = ModelMap.ParseListObject(persons, PersonDTO.class);
        personDTOList.forEach(PersonServices::addHateoasLinks);
        return personDTOList;
    }

    public PersonDTO findById(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        PersonDTO personDTO = ModelMap.parseObject(entity, PersonDTO.class); //adicionando hateos
        addHateoasLinks(personDTO);
        return personDTO;
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " Not Found"));
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());
        var entitySave = personRepository.save(entity);
        var dto = ModelMap.parseObject(entitySave, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;

    }

    public void delete(Long id) {
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " Not Found"));
        personRepository.deleteById(entity.getId());
    }


    public PersonDTOV2 createV2(PersonDTOV2 personDTO) {
        var entity = PersonMapper.convertDTOToEntity(personDTO);
        var entitySave = personRepository.save(entity);
        return PersonMapper.convertEntityToDTO(entitySave);
    }

    private static void addHateoasLinks(PersonDTO personDTO) {
        personDTO.add(linkTo(methodOn(PersonController.class).getPersonById(personDTO.getPersonId())).withSelfRel().withType("GET"));
        personDTO.add(linkTo(methodOn(PersonController.class).getAllPerson()).withRel("findAll").withType("GET"));
        personDTO.add(linkTo(methodOn(PersonController.class).createPerson(personDTO)).withRel("create").withType("POST"));
        personDTO.add(linkTo(methodOn(PersonController.class).updatePerson(personDTO, personDTO.getPersonId())).withRel("update").withType("PUT"));
        personDTO.add(linkTo(methodOn(PersonController.class).deletePerson(personDTO.getPersonId())).withRel("delete").withType("DELETE"));

    }
}

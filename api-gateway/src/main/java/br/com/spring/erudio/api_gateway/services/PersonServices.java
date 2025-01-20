package br.com.spring.erudio.api_gateway.services;

import br.com.spring.erudio.api_gateway.dto.PersonDTO;
import br.com.spring.erudio.api_gateway.exceptions.ResourceNotFoundException;
import br.com.spring.erudio.api_gateway.mapper.ModelMap;
import br.com.spring.erudio.api_gateway.model.Person;
import br.com.spring.erudio.api_gateway.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    private final PersonRepository personRepository;
    public PersonServices(PersonRepository personRepository ) {
        this.personRepository = personRepository;


    }

    public PersonDTO create(PersonDTO personDTO) {
        var entity = ModelMap.parseObject(personDTO, Person.class);
        var entitySave =  personRepository.save(entity);
        return ModelMap.parseObject(entitySave, PersonDTO.class);
    }
    public List<PersonDTO> findAll() {
        var persons = personRepository.findAll();
        return ModelMap.ParseListObject(persons, PersonDTO.class);
    }
    public PersonDTO findById(Long id) {
        var entity = personRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException(id + " Not Found"));
        return ModelMap.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO update(Long id,PersonDTO personDTO) {
        var entity =   personRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException(id + " Not Found"));
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());
        var entitySave =  personRepository.save(entity);
        return ModelMap.parseObject(entitySave, PersonDTO.class);

    }

    public void delete(Long id) {
        var entity =   personRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException(id + " Not Found"));
        personRepository.deleteById(entity.getId());
    }



}

package br.com.spring.erudio.api_gateway.mapper.custom;

import br.com.spring.erudio.api_gateway.dto.v2.PersonDTOV2;
import br.com.spring.erudio.api_gateway.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

// V2
@Service
public class PersonMapper {
    public static PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 personDTO = new PersonDTOV2();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAddress(person.getAddress());
        personDTO.setGender(person.getGender());
        personDTO.setBirthDay(new Date());
        return personDTO;
    }

    public static  Person convertDTOToEntity(PersonDTOV2 personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setAddress(personDTO.getAddress());
        person.setGender(personDTO.getGender());
        return person;
    }
}

package br.com.spring.erudio.api_gateway.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;


@JsonPropertyOrder({"personId","address","firstName","lastName","gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {
    private static final long serialVersionUID = 1L;


//    @JsonIgnore

    @JsonProperty("id")
    @JsonIgnore
    private Long personId;

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("address")

    private String address;
    @JsonProperty("gender")

    private String gender;

    public PersonDTO() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PersonDTO personDTO = (PersonDTO) o;
        return personId.equals(personDTO.personId) && firstName.equals(personDTO.firstName) && lastName.equals(personDTO.lastName) && address.equals(personDTO.address) && gender.equals(personDTO.gender);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + personId.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }
}

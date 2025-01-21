package br.com.spring.erudio.api_gateway.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonDTOV2 implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String firstName;

    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;

    public PersonDTOV2() {
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        PersonDTOV2 that = (PersonDTOV2) o;
        return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName) && address.equals(that.address) && gender.equals(that.gender) && birthDay.equals(that.birthDay);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + birthDay.hashCode();
        return result;
    }
}

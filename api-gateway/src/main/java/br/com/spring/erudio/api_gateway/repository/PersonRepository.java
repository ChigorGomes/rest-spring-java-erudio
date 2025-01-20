package br.com.spring.erudio.api_gateway.repository;

import br.com.spring.erudio.api_gateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

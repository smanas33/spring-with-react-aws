package com.msahoo.springbootaws.repository;

import com.msahoo.springbootaws.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonSpringJPARepository extends JpaRepository<Person, Long> {

    List<Person> findByAddress(String address);
}

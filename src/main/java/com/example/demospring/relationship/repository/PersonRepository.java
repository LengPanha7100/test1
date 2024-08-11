package com.example.demospring.relationship.repository;

import com.example.demospring.relationship.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}

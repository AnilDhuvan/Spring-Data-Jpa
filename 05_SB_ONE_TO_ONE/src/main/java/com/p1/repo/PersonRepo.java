package com.p1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}

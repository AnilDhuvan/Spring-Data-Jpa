package com.p1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Passport;

public interface PassportRepo extends JpaRepository<Passport, Integer> {

}

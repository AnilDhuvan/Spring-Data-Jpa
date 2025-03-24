package com.p1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Address;

public interface AddrRepo extends JpaRepository<Address, Integer>{

}

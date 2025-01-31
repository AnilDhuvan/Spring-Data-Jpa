package com.p1.repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.p1.entity.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 1. Find customers by name
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findByName(@Param("name") String name);

    // 2. Find customers by city
    @Query("SELECT c FROM Customer c WHERE c.city = :city")
    List<Customer> findByCity(@Param("city") String city);

    // 3. Find customers whose age is greater than a certain value
    @Query("SELECT c FROM Customer c WHERE c.age > :age")
    List<Customer> findByAgeGreaterThan(@Param("age") int age);

    // 4. Find customers with email containing a keyword (LIKE query)
    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:keyword%")
    List<Customer> findByEmailContaining(@Param("keyword") String keyword);

    // 5. Find top 5 oldest customers
    @Query("SELECT c FROM Customer c ORDER BY c.age DESC")
    List<Customer> findTop5OldestCustomers(Pageable pageable);

    // 6. Find customers whose ID is in a given list
    @Query("SELECT c FROM Customer c WHERE c.id IN :ids")
    List<Customer> findByIds(@Param("ids") List<Long> ids);

    // 7. Update customer email by ID
    @Modifying
    @Transactional
    @Query("UPDATE Customer c SET c.email = :email WHERE c.id = :id")
    int updateCustomerEmail(@Param("id") Long id, @Param("email") String newEmail);

    // 8. Delete customers by city
    @Modifying
    @Transactional
    @Query("DELETE FROM Customer c WHERE c.city = :city")
    int deleteCustomersByCity(@Param("city") String city);
}


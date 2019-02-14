package com.peoplehum.tag.repository;

import com.peoplehum.tag.v1.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("com.peoplehum.tag.repository.CustomerRepository")
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

  CustomerEntity findByEmail(String email);

}


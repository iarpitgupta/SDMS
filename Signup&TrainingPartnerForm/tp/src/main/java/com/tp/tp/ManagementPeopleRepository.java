package com.tp.tp;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ManagementPeopleRepository extends CrudRepository<ManagementPeople,Integer> {
    ManagementPeople findByEmailId(String email);
}

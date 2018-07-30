package com.tp.tp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffPeopleRepository extends CrudRepository<StaffPeople,Integer> {
    StaffPeople findByEmailId(String email);
}

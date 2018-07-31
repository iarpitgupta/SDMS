package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISingUpRepository extends CrudRepository<User,Long> {
    int countByUserName(String Name);
}

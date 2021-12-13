package com.itstep.trelloanalog.repositories;

import com.itstep.trelloanalog.entities.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DbUser, Long> {
    DbUser findByEmail(String email);
}

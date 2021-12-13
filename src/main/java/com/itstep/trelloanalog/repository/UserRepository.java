package com.itstep.trelloanalog.repository;

import com.itstep.trelloanalog.entities.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DbUser, Long> {
    DbUser findByEmail(String email);
}

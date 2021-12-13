package com.itstep.trelloanalog.repositories;

import com.itstep.trelloanalog.entities.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {
}

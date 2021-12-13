package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.WorkType;

import java.util.List;

public interface WorkTypeService {

    WorkType getWorkType(Long id);

    List<WorkType> getWorkTypes();

    WorkType addOrUpdateWorkType(WorkType workType);

    void deleteWorkType(Long id);
}

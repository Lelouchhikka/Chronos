package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.WorkType;
import com.itstep.trelloanalog.repositories.WorkTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeServiceImpl implements WorkTypeService {

    private final WorkTypeRepository workTypeRepository;

    public WorkTypeServiceImpl(WorkTypeRepository workTypeRepository) {
        this.workTypeRepository = workTypeRepository;
    }

    @Override
    public WorkType getWorkType(Long id) {
        return workTypeRepository.getById(id);
    }

    @Override
    public List<WorkType> getWorkTypes() {
        return workTypeRepository.findAll();
    }

    @Override
    public WorkType addOrUpdateWorkType(WorkType workType) {
        return workTypeRepository.save(workType);
    }

    @Override
    public void deleteWorkType(Long id) {
        workTypeRepository.deleteById(id);
    }
}

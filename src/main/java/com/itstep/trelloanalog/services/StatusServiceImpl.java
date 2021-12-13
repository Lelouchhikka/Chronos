package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.Status;
import com.itstep.trelloanalog.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<Status> getStatuses() {
        return statusRepository.findAll();
    }

    @Override
    public Status getStatus(Long id) {
        return statusRepository.getById(id);
    }

    @Override
    public Status addOrUpdateStatus(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}

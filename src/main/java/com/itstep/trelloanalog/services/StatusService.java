package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.Status;

import java.util.List;

public interface StatusService {

    List<Status> getStatuses();

    Status getStatus(Long id);

    Status addOrUpdateStatus(Status status);

    void deleteStatus(Long id);

}

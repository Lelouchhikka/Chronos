package com.itstep.trelloanalog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasks")
public class Task extends BaseEntity {

    private String name;

    private String description;

    private String comment;

    @OneToOne
    private Status status;

    @OneToOne
    private WorkType workType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deadline", nullable = false, updatable = false)
    private Date deadline;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "started_at", nullable = false, updatable = false)
    private Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finished_at")
    private Date finishedAt;
}

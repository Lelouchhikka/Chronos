package com.itstep.trelloanalog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="projects")
public class Project extends BaseEntity {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserProfile> users;
}

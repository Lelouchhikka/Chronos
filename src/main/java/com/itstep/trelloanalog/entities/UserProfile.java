package com.itstep.trelloanalog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_profiles")
public class UserProfile extends BaseEntity {

    private String fullName;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.REMOVE)
    private DbUser dbUser;

}

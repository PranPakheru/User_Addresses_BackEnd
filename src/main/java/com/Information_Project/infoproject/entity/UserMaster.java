package com.Information_Project.infoproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user_master")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private long mobileNumber;

    @Column(name = "date_of_registration")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfRegistration;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "userMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserAddresses> userAddresses;

}

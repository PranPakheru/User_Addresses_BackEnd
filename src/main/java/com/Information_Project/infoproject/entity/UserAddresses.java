package com.Information_Project.infoproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_address")
    private String fullAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userMaster_id")
    @JsonIgnore
    private UserMaster userMaster;

}

package com.Information_Project.infoproject.repository;

import com.Information_Project.infoproject.entity.UserAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressesRepository extends JpaRepository<UserAddresses, Long> {

    List<UserAddresses> findByUserMasterId(long id);
}

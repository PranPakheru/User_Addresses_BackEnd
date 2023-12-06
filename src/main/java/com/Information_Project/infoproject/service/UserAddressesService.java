package com.Information_Project.infoproject.service;

import com.Information_Project.infoproject.dto.UserAddressesDto;
import com.Information_Project.infoproject.entity.UserAddresses;

import java.util.List;

public interface UserAddressesService {

    String addAddressForUser(UserAddressesDto userAddressesDto, long id);
    List<UserAddresses> findUserAddress(long id);
    String deleteUserAddress(long id);

}

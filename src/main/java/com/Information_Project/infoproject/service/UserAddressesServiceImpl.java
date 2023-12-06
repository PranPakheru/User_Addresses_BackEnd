package com.Information_Project.infoproject.service;

import com.Information_Project.infoproject.dto.UserAddressesDto;
import com.Information_Project.infoproject.entity.UserAddresses;
import com.Information_Project.infoproject.entity.UserMaster;
import com.Information_Project.infoproject.errorHandling.ResourceNotFoundException;
import com.Information_Project.infoproject.repository.UserAddressesRepository;
import com.Information_Project.infoproject.repository.UserMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressesServiceImpl implements UserAddressesService{

    //other class objects.
    @Autowired
    private UserAddressesRepository userAddressesRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMasterRepository userMasterRepository;


    //entity-dto conversion of user address
    private UserAddresses mapToEntity(UserAddressesDto userAddressesDto){
        UserAddresses userAdd = modelMapper.map(userAddressesDto, UserAddresses.class);
        return userAdd;
    }

    private UserAddressesDto mapToDto(UserAddresses userAddresses){
        UserAddressesDto userAddressesDto = modelMapper.map(userAddresses, UserAddressesDto.class);
        return userAddressesDto;
    }


    //other implementation methods for CRUD of addresses.
    @Override
    public String addAddressForUser(UserAddressesDto userAddressesDto, long id) {
        UserMaster userMaster = userMasterRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("UserMaster", "id", id));
        UserAddresses userAddresses = mapToEntity(userAddressesDto);
        userAddresses.setUserMaster(userMaster);
        userAddressesRepo.save(userAddresses);
        return "Address saved successfully.";
    }

    @Override
    public List<UserAddresses> findUserAddress(long id) {
        List<UserAddresses> byUserMasterId = userAddressesRepo.findByUserMasterId(id);
        return byUserMasterId;
    }

    @Override
    public String deleteUserAddress(long id) {
        userAddressesRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("UserAddress", "id", id));
        userAddressesRepo.deleteById(id);
        return "Address deleted successfully.";
    }
}

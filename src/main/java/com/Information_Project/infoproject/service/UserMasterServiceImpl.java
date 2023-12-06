package com.Information_Project.infoproject.service;

import com.Information_Project.infoproject.config.BeanConfig;
import com.Information_Project.infoproject.dto.UserMasterDto;
import com.Information_Project.infoproject.entity.UserMaster;
import com.Information_Project.infoproject.errorHandling.ResourceNotFoundException;
import com.Information_Project.infoproject.repository.UserMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMasterServiceImpl implements UserMasterService{
    
    //other class objects.
    @Autowired
    private UserMasterRepository userMasterRepo;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BeanConfig beanConfig;


    //entity-dto conversion methods
    private UserMaster mapToEntity(UserMasterDto userMasterDto){
        UserMaster mapEntity = modelMapper.map(userMasterDto, UserMaster.class);
        return mapEntity;
    }

    private UserMasterDto mapToDto(UserMaster userMaster){
        UserMasterDto mapDto = modelMapper.map(userMaster, UserMasterDto.class);
        return mapDto;
    }


    //other implementation methods.
    @Override
    public String saveUserMaster(UserMasterDto userMasterDto) {
        UserMaster userMaster = mapToEntity(userMasterDto);
        userMaster.setPassword(beanConfig.passwordEncoderD().encode(userMasterDto.getPassword()));
        UserMaster save = userMasterRepo.save(userMaster);

        return "User Master saved successfully.";
    }

    @Override
    public List<UserMasterDto> getAllUserMasters() {
        List<UserMaster> all = userMasterRepo.findAll();
        List<UserMasterDto> collect = all.stream().map(this::mapToDto).collect(Collectors.toList());
        return collect;
    }

    @Override
    public UserMasterDto getOneUser(long id) {
        UserMaster userMaster1 = userMasterRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("UserMaster", "id", id));
        UserMasterDto userMasterDto = mapToDto(userMaster1);
        return userMasterDto;
    }

    @Override
    public UserMasterDto updateTheUserMaster(long id, UserMasterDto userMasterDto) {
        UserMaster userMaster = userMasterRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("UserMaster", "id", id));

        userMaster.setId(id);
        userMaster.setName(userMasterDto.getName());
        userMaster.setPassword(userMasterDto.getPassword());
        userMaster.setMobileNumber(userMasterDto.getMobileNumber());
        userMaster.setDateOfRegistration(userMasterDto.getDateOfRegistration());
        userMaster.setStatus(userMasterDto.getStatus());

        UserMaster save = userMasterRepo.save(userMaster);
        UserMasterDto newUserMasterDto1 = mapToDto(save);
        
        return newUserMasterDto1;
    }

    @Override
    public String deleteTheUserMaster(long id) {
        userMasterRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("UserMaster", "id", id));
        userMasterRepo.deleteById(id);
        return "User Master deleted successfully.";
    }
}

package com.Information_Project.infoproject.service;

import com.Information_Project.infoproject.dto.UserMasterDto;

import java.util.List;

public interface UserMasterService {

    String saveUserMaster(UserMasterDto userMasterDto);
    List<UserMasterDto> getAllUserMasters();
    UserMasterDto getOneUser(long id);
    UserMasterDto updateTheUserMaster(long id, UserMasterDto userMasterDto);
    String deleteTheUserMaster(long id);
}

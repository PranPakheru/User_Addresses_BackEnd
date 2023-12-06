package com.Information_Project.infoproject.controller;

import com.Information_Project.infoproject.dto.UserMasterDto;
import com.Information_Project.infoproject.service.UserMasterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userMas")
public class UserMasterController {

    //other class objects.
    @Autowired
    private UserMasterService userMasterService;


    //controller methods for CRUD.

    //below method is to create a user master.
    //http://localhost:8080/info-proj/userMas/createUserMaster
    @PostMapping("/createUserMaster")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> createUserMaster(@Valid @RequestBody UserMasterDto userMasterDto){

        String msg = userMasterService.saveUserMaster(userMasterDto);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //below method is to read all users
    //http://localhost:8080/info-proj/userMas/getAllUserMasters
    @GetMapping("/getAllUserMasters")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<UserMasterDto>> getAllUserMasters(){
        List<UserMasterDto> allUserMasters = userMasterService.getAllUserMasters();
        return new ResponseEntity<>(allUserMasters, HttpStatus.OK);
    }

    //below is the method to read one user.
    //http://localhost:8080/info-proj/userMas/getOneUserMaster/{}
    @GetMapping("/getOneUserMaster/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<UserMasterDto> getOneUserMasterById(@PathVariable long id){
        UserMasterDto oneUser = userMasterService.getOneUser(id);
        return new ResponseEntity<>(oneUser, HttpStatus.OK);
    }

    //below is the method to update one user.
    //http://localhost:8080/info-proj/userMas/updateUser/{}
    @PutMapping("/updateUser/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<UserMasterDto> updateOneUserMasterById(@Valid @PathVariable long id, @Valid @RequestBody UserMasterDto userMasterDto){
        UserMasterDto userMasterDto1 = userMasterService.updateTheUserMaster(id, userMasterDto);
        return new ResponseEntity<>(userMasterDto1, HttpStatus.OK);
    }

    //below is the method to delete one user master.
    //http://localhost:8080/info-proj/userMas/deleteUserMaster/{}
    @DeleteMapping("/deleteUserMaster/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> deleteOneUserMaster(@PathVariable long id){
        String msg = userMasterService.deleteTheUserMaster(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}

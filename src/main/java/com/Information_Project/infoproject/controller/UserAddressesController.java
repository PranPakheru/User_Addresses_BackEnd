package com.Information_Project.infoproject.controller;

import com.Information_Project.infoproject.dto.UserAddressesDto;
import com.Information_Project.infoproject.entity.UserAddresses;
import com.Information_Project.infoproject.service.UserAddressesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userAdd")
public class UserAddressesController {

    //other class controller.
    @Autowired
    private UserAddressesService userAddressesService;


    //CRUD operations for user address.

    //below method is to add address with the help of user master id.
    //http://localhost:8080/info-proj/userAdd/addUserAddress/{}
    @PostMapping("/addUserAddress/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> addUserAddress(@Valid @RequestBody UserAddressesDto userAddressesDto, @PathVariable long id){
        String msg = userAddressesService.addAddressForUser(userAddressesDto, id);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //below method is to get all addresses by user master id.
    //http://localhost:8080/info-proj/userAdd/getUserAddressById/{}
    @GetMapping("/getUserAddressById/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<UserAddresses>> getAllAddresses(@PathVariable long id){
        List<UserAddresses> userAddress = userAddressesService.findUserAddress(id);
        return new ResponseEntity<>(userAddress, HttpStatus.OK);
    }

    //below method is to delete single user address by user address id.
    //http://localhost:8080/info-proj/userAdd/deleteAddressById/{}
    @DeleteMapping("/deleteAddressById/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> deleteAddress(@PathVariable long id){
        String msg = userAddressesService.deleteUserAddress(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}

package com.Information_Project.infoproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterDto {

    private long id;

    @NotNull
    @Size(min = 1, message = "User Master's name should at least be 1 characters!")
    private String name;

    @NotNull
    @Size(min = 5, message = "Password should at least be 5 characters!")
    private String password;

    @NotNull
    private long mobileNumber;

    @NotNull
    private Date dateOfRegistration;

    @NotNull
    private String status;
}

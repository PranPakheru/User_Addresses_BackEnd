package com.Information_Project.infoproject.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressesDto {

    private long id;

    @NotNull
    @Size(min = 10, message = "Address should at least be 10 characters!")
    private String fullAddress;

}

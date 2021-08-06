package com.example.usermanage.Model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String phone;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 8, max = 30, message = "Pasword must be more thanh 8 characters and less thanh 30 characters")
    private String password;


}

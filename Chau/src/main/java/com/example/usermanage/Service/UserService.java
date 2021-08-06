package com.example.usermanage.Service;

import com.example.usermanage.Model.Dto.UserDto;
import com.example.usermanage.Model.Request.CreateUserRequest;
import com.example.usermanage.Model.Request.UpdateUserRequest;

import java.util.List;

public interface UserService {
    public List<UserDto> getListUser();

    public UserDto getUserById(int id);

    public UserDto createUser(CreateUserRequest req);

    public UserDto updateUser(UpdateUserRequest req, int id);

    public void deleteUser(int id);
}

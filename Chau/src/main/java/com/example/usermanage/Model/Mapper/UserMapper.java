package com.example.usermanage.Model.Mapper;

import com.example.usermanage.Entity.User;
import com.example.usermanage.Model.Dto.UserDto;
import com.example.usermanage.Model.Request.CreateUserRequest;
import com.example.usermanage.Model.Request.UpdateUserRequest;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        tmp.setEmail(user.getEmail());

        return tmp;
    }

    public static User toUser(CreateUserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setPassword(req.getPassword());

        return user;
    }

    public static User toUser(UpdateUserRequest req, int id) {
        User user = new User();
        user.setId(id);
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setAvatar(req.getAvatar());
        user.setPassword(req.getPassword());
        user.setRole("USER");

        return user;
    }
}

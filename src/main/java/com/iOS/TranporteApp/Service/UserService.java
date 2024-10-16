package com.iOS.TranporteApp.Service;

import com.iOS.TranporteApp.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id_user);
    UserDto getUserByUsername(String username);
    UserDto getUserByEmail(String email);
    UserDto getUserByPhone(int phone);
    List<UserDto> getAllUsers();

    UserDto updateUser(Long id_User,UserDto userDto);
    UserDto CreateUser(UserDto userDto);
}

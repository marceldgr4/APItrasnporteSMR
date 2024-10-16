package com.iOS.TranporteApp.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iOS.TranporteApp.Dto.UserDto;
import com.iOS.TranporteApp.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    // Endpoint para obtener un usuario por su ID
    @GetMapping("{/id_user}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id_user") Long id_User){
        UserDto user = userService.getUserById(id_User);
        return ResponseEntity.ok(user);

    }
    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto newUser= userService.CreateUser(userDto);
        return ResponseEntity.ok(newUser);
    }
    // Endpoint para actualizar un usuario
    @PutMapping("{/id_user}")
    public ResponseEntity<UserDto> updateUser (@PathVariable Long id_user, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(id_user, userDto);
        return ResponseEntity.ok(updatedUser);
    }
    

}

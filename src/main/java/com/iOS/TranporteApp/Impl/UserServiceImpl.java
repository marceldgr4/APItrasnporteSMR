package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.UserDto;
import com.iOS.TranporteApp.Entity.User;
import com.iOS.TranporteApp.Repository.UsuarioRepository;

import com.iOS.TranporteApp.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUserById(Long id_user) {
        User user =usuarioRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException ("User not found"));
        return modelMapper.map(user, UserDto.class); // Uso de ModelMapper
    }

    @Override
    public UserDto getUserByUsername(String fullname) {
        User user = usuarioRepository.findByFullname(fullname)
                .orElseThrow(() -> new RuntimeException("username not found"));
        return modelMapper.map(user, UserDto.class); 
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("email not found"));
        return modelMapper.map(user, UserDto.class); // Uso de ModelMapper
    }

    @Override
    public UserDto getUserByPhone(int phone) {
        User user = usuarioRepository.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("phone not found"));
        return modelMapper.map(user, UserDto.class); // Uso de ModelMapper
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usuarioRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class)) // Uso de ModelMapper
                .collect(Collectors.toList());
    }



    @Override
    public UserDto updateUser(Long id_User, UserDto userDto) {
        User user = usuarioRepository.findById(id_User)
                .orElseThrow(() -> new RuntimeException("User not found"));

        modelMapper.map(userDto, user); // Mapear los campos del DTO a la entidad existente
        User updatedUser = usuarioRepository.save(user);

        return modelMapper.map(updatedUser, UserDto.class); // Mapear la entidad actualizada de vuelta a DTO
    }

    @Override
    public UserDto CreateUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class); // Mapear DTO a entidad
        User newUser = usuarioRepository.save(user);
        return modelMapper.map(newUser, UserDto.class); // Mapear entidad a DTO
    }
}

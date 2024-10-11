package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<User,Long> {
    Optional<User> findByFullname(String fullname);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(int phone);
}

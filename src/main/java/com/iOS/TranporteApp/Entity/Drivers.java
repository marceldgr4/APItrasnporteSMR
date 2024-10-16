package com.iOS.TranporteApp.Entity;

import com.iOS.TranporteApp.Emun.Shift;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Drivers")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_driver;

    @Column(nullable = false,unique = true)
    private String Code;

    @Column(nullable = false,unique = true)
    private String full_name;

    @Column(nullable = false,unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Shift shift;

//ERD
    @OneToOne
    @JoinColumn(name = "id_Bus")
    private Bus bus;

}

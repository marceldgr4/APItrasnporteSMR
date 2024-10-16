package com.iOS.TranporteApp.Entity;

import com.iOS.TranporteApp.Emun.Shift;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Drivers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conductor;

    @Column(nullable = false,unique = true)
    private String Code;

    @Column(nullable = false,unique = true)
    private String full_name;

    @Column(nullable = false,unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Shift shift;

//ERD
@OneToMany(mappedBy = "conductor")
private List<Bus> buses;



}

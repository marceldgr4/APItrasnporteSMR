package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Locations")

@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_location;

    @Column( name = "name", nullable = false, unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private String address;

    //EDR
    @ManyToMany(mappedBy = "location")
    private List<Bus> buses;



}

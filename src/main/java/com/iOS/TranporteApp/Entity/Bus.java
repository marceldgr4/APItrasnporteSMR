package com.iOS.TranporteApp.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Data
@Table(name = "Buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Bus;

    @Column(nullable = false, unique = true)
    private String Bus_plate;

    @Column(nullable = false, unique = true)
    private String status;

    @Column(nullable = false, unique = true)
    private String type;

    @Column(nullable = false, unique = true)
    private String model;

    @Column(nullable = false, unique = true)
    private Integer Capacity;

    @Column(nullable = false, unique = true)
    private String Brand;

    //ER
    @ManyToMany
    @JoinTable(name = "Ruta_Bus",
    joinColumns = @JoinColumn(name = "id_Bus"),
            inverseJoinColumns = @JoinColumn(name = "id_Route")
    )
    private List<Routes> routes;

    @ManyToMany
    @JoinTable(name = "Bus_locations",
            joinColumns = @JoinColumn(name = "id_Bus"),
            inverseJoinColumns = @JoinColumn(name = "id_Location")
    )
    private List<Locations> location;

    @ManyToOne
    @JoinColumn(name = "id_Driver")
    private Drivers driver;

    @OneToMany(mappedBy = "bus")
    private List<Payments_Card> payments;






}

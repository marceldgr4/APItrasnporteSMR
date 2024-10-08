package com.iOS.TranporteApp.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Entity
@Data
@Table(name = "Routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Route;

    @Column(nullable = false, unique = true)
    private String route_name;

    @Column(nullable = false, unique = true)
    private String route_origen;

    @Column(nullable = false, unique = true)
    private String route_destination;

    @Column(nullable = false, unique = true)
    private String route_type;

    @Column(nullable = false, unique = true)
    private String route_status;

    @Column(nullable = false, unique = true)
    private Time Start_Time;

    @Column(nullable = false, unique = true)
    private Time End_Time;

//ERD

    @ManyToMany
    @JoinTable(name = "Ruta_bus",
    joinColumns = @JoinColumn(name = "id_Route"),
    inverseJoinColumns = @JoinColumn(name = "id_Bus"))
    private List<Bus> busList;


    @OneToMany(mappedBy = "routes")
    private List<Stops> stops;





}

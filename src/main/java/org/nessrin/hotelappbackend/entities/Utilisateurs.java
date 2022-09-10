package org.nessrin.hotelappbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateurs {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String nom;
    private String prenom;
    private String email;
    private Long phone;
    @OneToMany(mappedBy = "utilisateurs")
    private List<Booking> bookingList;
}

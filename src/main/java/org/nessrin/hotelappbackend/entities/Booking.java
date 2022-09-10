package org.nessrin.hotelappbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nessrin.hotelappbackend.enums.BookingStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Destination;
   /* private Date checkin;
    private Date checkout;
    private Long norooms;
    private Long noadults;
    private Long nochildren;*/
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date checkin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkout;
    private String nom;
    private String email;
    private String phone;
    private Long nopersons;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @ManyToOne
    private Utilisateurs utilisateurs;
}

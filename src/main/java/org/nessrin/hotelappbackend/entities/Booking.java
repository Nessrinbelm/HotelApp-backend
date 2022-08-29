package org.nessrin.hotelappbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nessrin.hotelappbackend.enums.BookingStatus;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private String id;
    private Date datereservation;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @ManyToOne
    private Utilisateurs utilisateurs;
}

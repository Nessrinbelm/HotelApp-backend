package org.nessrin.hotelappbackend.repositories;

import org.nessrin.hotelappbackend.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking,String> {
}

package org.nessrin.hotelappbackend.repositories;

import org.hibernate.query.NativeQuery;
import org.nessrin.hotelappbackend.entities.Booking;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @RestResource(path="/MyBookings")
    public List<Booking> findByIdContains(@Param("id") Long Id);
    @RestResource(path="/MyBookingsPage")
    public Page<Booking> findByIdContains(@Param("id") Long Id, Pageable pageable);


}

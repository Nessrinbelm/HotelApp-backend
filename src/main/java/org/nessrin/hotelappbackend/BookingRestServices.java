package org.nessrin.hotelappbackend;

import org.nessrin.hotelappbackend.entities.Booking;
import org.nessrin.hotelappbackend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingRestServices {
    @Autowired
   private  BookingRepository bookingRepository;
    @GetMapping(value = "/listBookings")
    public List<Booking> listBookings(){
      return bookingRepository.findAll();
    }
   /* @GetMapping(value = "/listBookings/{id}")
    public List<Booking> listBookings(Long id){
        return bookingRepository.findAll();
    }*/

}

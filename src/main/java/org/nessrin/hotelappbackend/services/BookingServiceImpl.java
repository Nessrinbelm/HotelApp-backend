package org.nessrin.hotelappbackend.services;

import org.nessrin.hotelappbackend.entities.Booking;
import org.nessrin.hotelappbackend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> listAll() {
        return bookingRepository.findAll();
    }
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
    public Booking get(Long id) {
        return bookingRepository.findById(id).get();
    }
    public void deleteBookingById(Long id)
    {
        bookingRepository.deleteById(id);
    }

}

package org.nessrin.hotelappbackend;

import org.nessrin.hotelappbackend.entities.Booking;
import org.nessrin.hotelappbackend.entities.Utilisateurs;
import org.nessrin.hotelappbackend.repositories.BookingRepository;
import org.nessrin.hotelappbackend.repositories.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HotelAppBackendApplication {


    @Autowired
    private UtilisateursRepository utilisateursRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(HotelAppBackendApplication.class, args);

    }

    @Bean
     CommandLineRunner start(UtilisateursRepository utilisateursRepository,
                             BookingRepository bookingRepository) {

         return args -> {

             Stream.of("Hassan", "Yassine", "Aicha").forEach(prenom -> {
                 restConfiguration.exposeIdsFor(Utilisateurs.class);
                 Utilisateurs utilisateurs = new Utilisateurs();
                 utilisateurs.setPrenom(prenom);
                 utilisateurs.setNom("Test");
                 utilisateurs.setEmail(prenom + "@gmail.com");
                 utilisateursRepository.save(utilisateurs);
             });
           utilisateursRepository.findAll().forEach(utilisateurs -> {
                 restConfiguration.exposeIdsFor(Booking.class);
                 Booking booking = new Booking();
                 booking.setNom("Something");
                 booking.setDestination("Somewhere");
                 booking.setEmail(booking.getNom()+"@gmail.com");
                 booking.setCheckin(new Date());
                 booking.setCheckout(new Date());
                 booking.setNopersons(3l);
                 booking.setUtilisateurs(utilisateurs);
                 bookingRepository.save(booking);
             });



         };

     }}

package org.nessrin.hotelappbackend;

import org.nessrin.hotelappbackend.entities.Booking;
import org.nessrin.hotelappbackend.entities.Utilisateurs;
import org.nessrin.hotelappbackend.enums.BookingStatus;
import org.nessrin.hotelappbackend.repositories.BookingRepository;
import org.nessrin.hotelappbackend.repositories.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.UUID;
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
        //restConfiguration.exposeIdsFor(Utilisateurs.class);
    }
    @Bean
     CommandLineRunner start(UtilisateursRepository utilisateursRepository,
                             BookingRepository bookingRepository){
        return args -> {
          Stream.of("Hassan","Yassine","Aicha").forEach(prenom->{
              Utilisateurs utilisateurs=new Utilisateurs();
              utilisateurs.setPrenom(prenom);
              utilisateurs.setNom("Test");
              utilisateurs.setEmail(prenom+"@gmail.com");
              utilisateursRepository.save(utilisateurs);
          });
          utilisateursRepository.findAll().forEach(utilisateurs -> {
              Booking booking=new Booking();
              booking.setId(UUID.randomUUID().toString());
              booking.setDatereservation(new Date());
              booking.setStatus(BookingStatus.APPROUVED);
              booking.setUtilisateurs(utilisateurs);
              bookingRepository.save(booking);
          });
        };
     }
}

package org.nessrin.hotelappbackend.services;

import org.nessrin.hotelappbackend.entities.Booking;
import org.nessrin.hotelappbackend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookingRestServices {
    @Autowired
   private  BookingRepository bookingRepository;
    @Autowired
    private  BookingServiceImpl bookingService;
//    @Autowired
//    private  CelebrationServiceImpl celebrationService;
   /* @Autowired
    private CelebrationRepository celebrationRepository;
    @Autowired
    private FoodRepository foodRepository;*/

//    private  FoodServiceImpl foodService;


     /////// BOOKING REST API

    @PostMapping("/booking")
    public void saveBooking(
            @RequestBody Booking booking) {
          bookingService.save(booking);

    }
    @GetMapping(value = "/listBookings")
    public List<Booking> listBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping(value = "/bookings/utilisateur")
    public List<Booking> listBooking(Long id_user){
        return bookingRepository.findAll().stream()
                .filter(booking -> booking.getUtilisateurs().getId().equals(20L))
                .collect(Collectors.toList());
    }

  /*  /////  CELEBRATION REST API

    @PostMapping("/celebration")
    public void saveCelebration(
            @RequestBody CelebrationBook celebrationBook) {
        celebrationService.savecelebration(celebrationBook);
    }

    @GetMapping(value = "/listCelebrations")
    public List<CelebrationBook> listCelebrations(){
        return celebrationRepository.findAll();
    }

  /////   FOOD REST API

    @PostMapping("/foodss")
    public void saveFoods(
            @RequestBody FoodBook foodBook) {
       foodService.saveFood(foodBook);
    }

    @GetMapping(value = "/listFoods")
    public List<FoodBook> listFoods(){
        return foodRepository.findAll();
    }

*/












 /*   @PostMapping(value = "/booking")
    public Booking CreateBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }*/




   /* @GetMapping(value = "/listBookings/{id}")
    public Booking listBookings(@PathVariable(name = "id") String id){
        return bookingRepository.findById(id).get();
    }
    @PutMapping(value = "/listBookings/{id}")
    public Booking update(@PathVariable(name = "id") String id,@RequestBody Booking b){
        b.setId(id);
        return bookingRepository.save(b);
    }
    @PostMapping(value = "/listBookings")
    public Booking save(@RequestBody Booking b){
        return bookingRepository.save(b);
    }

    @DeleteMapping(value = "/listBookings/{id}")
    public void delete(@PathVariable(name = "id") String id){
         bookingRepository.deleteById(id);
    }
*/


   /* @GetMapping(value = "/listBookingsbyUser")
    public List<Booking>listBookings(Utilisateurs utilisateurs){
        return bookingRepository.findAll(utilisateurs);
    }*/

}

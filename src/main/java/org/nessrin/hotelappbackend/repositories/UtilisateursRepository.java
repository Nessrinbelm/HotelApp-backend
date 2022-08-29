package org.nessrin.hotelappbackend.repositories;

import org.nessrin.hotelappbackend.entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface UtilisateursRepository extends JpaRepository<Utilisateurs,Long> {

}

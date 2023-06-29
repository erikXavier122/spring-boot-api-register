package com.api.parkingcontrol.domain.repository.v1;

import com.api.parkingcontrol.domain.model.v1.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


//nos estendemos o jpa pq ele tem mais metodos prontos para nos facilitar em transaçoes com o banco dados,Ex.: salvar, deletar, puxar um, puxar todos
// nao é necessario usar @Repository pq graças ao Jpa ele ja nos indica que é um repository
@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartamentAndBlock(String apartament, String block);

}

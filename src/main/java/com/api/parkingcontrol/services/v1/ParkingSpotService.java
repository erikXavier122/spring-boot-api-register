package com.api.parkingcontrol.services.v1;

import com.api.parkingcontrol.domain.model.v1.ParkingSpotModel;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ParkingSpotService {

    ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

     boolean existsByApartamentAndBlock(String apartament, String block);

     List<ParkingSpotModel> findAll();

     Optional<ParkingSpotModel> findById(UUID id);

     void delete(ParkingSpotModel parkingSpotModel);

}

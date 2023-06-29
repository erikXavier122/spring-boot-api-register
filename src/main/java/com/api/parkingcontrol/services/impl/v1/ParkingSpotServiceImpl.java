package com.api.parkingcontrol.services.impl.v1;


import com.api.parkingcontrol.domain.model.v1.ParkingSpotModel;
import com.api.parkingcontrol.domain.repository.v1.ParkingSpotRepository;
import com.api.parkingcontrol.services.v1.ParkingSpotService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotServiceImpl(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }


    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }


    public boolean existsByApartamentAndBlock(String apartament, String block) {
        return parkingSpotRepository.existsByApartamentAndBlock(apartament, block);
    }


    public List<ParkingSpotModel> findAll() {
        return parkingSpotRepository.findAll();
    }


    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}

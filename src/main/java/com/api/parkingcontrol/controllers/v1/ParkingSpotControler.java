package com.api.parkingcontrol.controllers.v1;



import com.api.parkingcontrol.dtos.v1.ParkingSpotDto;
import com.api.parkingcontrol.domain.model.v1.ParkingSpotModel;
import com.api.parkingcontrol.services.v1.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/parking-spot/v1")
public class ParkingSpotControler {

    private final ParkingSpotService parkingSpotService;

    //  Ponto de injeção com ajuda o construtor

//  a partir de agora vamos fazer nossas implementações
//  com PostMapping faremos a implementação de um metodo de salvação

    public ParkingSpotControler(ParkingSpotService parkingSpotService){
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object>saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }
        if(parkingSpotService.existsByApartamentAndBlock(parkingSpotDto.getApartament(),parkingSpotDto.getBlock())){
        }
        var parkingSpotModelV1 = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto,parkingSpotModelV1);
        parkingSpotModelV1.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModelV1));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpotModel> parkingSpotModelV1Optional = parkingSpotService.findById(id);
        if (!parkingSpotModelV1Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelV1Optional.get());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpotModel>parkingSpotModelV1Optional = parkingSpotService.findById(id);
        if (!parkingSpotModelV1Optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot Not Found.");
        }
        parkingSpotService.delete(parkingSpotModelV1Optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted succefully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id")UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpotModel> parkingSpotModelV1Optional = parkingSpotService.findById(id);
        if(!parkingSpotModelV1Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot Not Found.");
        }
        var parkingSpotModelV1 = parkingSpotModelV1Optional.get();
        parkingSpotModelV1.setApartament(parkingSpotDto.getApartament());
        parkingSpotModelV1.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
        parkingSpotModelV1.setModelCar(parkingSpotDto.getModelCar());
        parkingSpotModelV1.setColorCar(parkingSpotDto.getColorCar());
        parkingSpotModelV1.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
        parkingSpotModelV1.setBlock(parkingSpotDto.getBlock());
        parkingSpotModelV1.setBrandCar(parkingSpotDto.getBrandCar());
        parkingSpotModelV1.setResponsibleName(parkingSpotDto.getResponsibleName());
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModelV1));
    }

}

package com.api.parkingcontrol.domain.model.v1;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

//é uma entidade do tipo tabela
@Entity
@Table(name="tb_parking_spot")
public class ParkingSpotModel implements Serializable {
    private static final Long serialVersionUID = 1L;


//com o @Id nos identificamos para o interlij que é uma entidade id, com o @generatedValue identificamos que ele ira ter um autp incremento UUID é o tipo da variavel
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//tipo String ,nao recebe valor vazio tem que ser unico e ate no maximo 10 caracteres
    @Column(nullable = false,unique = true, length = 10)
    private String parkingSpotNumber;

//tipo String, nao recebe valor vazio tem que ser unico e ate no maximo 7 caracteres
    @Column(nullable = false,unique = true, length = 7)
    private String licensePlateCar;

//tipo String, nao recebe valor vazio e ate no maximo 70 caracteres
    @Column(nullable = false,length = 70)
    private String brandCar;

//tipo String, nao recebe valor vazio e ate no maximo 70 caracteres
    @Column(nullable = false,length = 70)
    private String modelCar;

//tipo String, nao recebe valor vazio e ate no maximo 70 caracteres
    @Column(nullable = false, length = 70)
    private String colorCar;

//tipo local date time isso significa que é um tipo data, nao recebe valor vazio
    @Column(nullable = false)
    private LocalDateTime registrationDate;

//tipo String, nao recebe valor vazio e ate no maximo 150 caracteres
    @Column(nullable = false,length = 150)
    private String responsibleName;

//tipo String, nao recebe valor vazio e ate no maximo 70 caracteres
    @Column(nullable = false,length = 30)
    private String apartament;

//tipo String, nao recebe valor vazio e ate no maximo 70 caracteres
    @Column(nullable = false,length = 30)
    private String block;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}

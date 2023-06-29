package com.api.parkingcontrol.domain.repository.v2;

import com.api.parkingcontrol.domain.model.v2.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RegisterRepository extends JpaRepository<Register, UUID> {


}

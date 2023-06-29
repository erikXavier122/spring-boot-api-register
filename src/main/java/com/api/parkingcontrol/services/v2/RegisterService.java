package com.api.parkingcontrol.services.v2;

import com.api.parkingcontrol.domain.model.v2.Register;
import com.api.parkingcontrol.dtos.v2.RegisterDto;

import java.util.List;

public interface RegisterService {

    List<Register> findAll();

    Register created(Register register);
}

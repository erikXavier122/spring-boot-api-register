package com.api.parkingcontrol.services.impl.v2;

import com.api.parkingcontrol.domain.model.v2.Register;
import com.api.parkingcontrol.domain.repository.v2.RegisterRepository;
import com.api.parkingcontrol.dtos.v2.RegisterDto;
import com.api.parkingcontrol.services.v2.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    final RegisterRepository registerRepository;

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }



    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public Register created(Register register) {
        return registerRepository.save(register);
    }


}

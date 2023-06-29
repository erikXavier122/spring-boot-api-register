package com.api.parkingcontrol.controllers.v2;


import com.api.parkingcontrol.domain.model.v2.Register;
import com.api.parkingcontrol.domain.repository.v2.RegisterRepository;
import com.api.parkingcontrol.dtos.v2.RegisterDto;
import com.api.parkingcontrol.services.v2.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/register/v2")
public class RegisterControler {

    private final RegisterService registerService;

    public RegisterControler(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Register>> getAllRegister(){
        return ResponseEntity.status(HttpStatus.OK).body(registerService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Object>saveRepository(@RequestBody @Valid RegisterDto registerDto){
        var register = new Register();
        BeanUtils.copyProperties(registerDto,register);
        register.setDateCreated(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(registerService.created(register));
    }


}

package com.luan.api.controller;

import com.luan.api.model.Acceleration;
import com.luan.api.service.AccelerationService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    private final AccelerationService accelerationService;

    public AccelerationController(AccelerationService accelerationService) {
        this.accelerationService = accelerationService;
    }

    @GetMapping
    public ResponseEntity<Acceleration> find(@Param("id")Integer id,
                               @Param("name")String name,
                               @Param("companyId") Integer companyId){

        Acceleration acceleration = null;

        if(id != null){
            acceleration = accelerationService.findAccelerationById(id);
        }else if(name != null){
            acceleration = accelerationService.findAccelerationByName(name);
        }else if(companyId != null){
            acceleration = accelerationService.findByCompanyId(companyId);
        }

        return new ResponseEntity(acceleration, HttpStatus.OK);
    }


    @PatchMapping
    public ResponseEntity<Acceleration> save(@RequestBody Acceleration acceleration){
        Acceleration resposta = accelerationService.save(acceleration);

        if(resposta != null){
            return new ResponseEntity<>(resposta,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
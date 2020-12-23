package com.luan.api.controller;

import com.luan.api.model.Company;
import com.luan.api.service.CompanyService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Company> find(@Param("id") Integer id,
                               @Param("accelerationId") Integer accelerationId,
                               @Param("userId") Integer userId){

        Company company = null;

        if(id != null){
            company = companyService.findById(id);
        }else if(accelerationId != null){
            company = companyService.findByAccelerationId(accelerationId);
        }else if(userId != null){
            company = companyService.findByUserId(userId);
        }

        return ResponseEntity.ok(company);
    }



    @PatchMapping
    public ResponseEntity<Company> save(@RequestBody Company company){
        Company resposta = companyService.save(company);

        if(resposta != null){
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

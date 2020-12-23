package com.luan.api.controller;

import com.luan.api.model.Company;
import com.luan.api.service.CompanyService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<?> find(@Param("id") Integer id,
                               @Param("accelerationId") Integer accelerationId,
                               @Param("userId") Integer userId){

        List<Company> companyList = null;

        if(id != null){
            Arrays.asList(companyService.findById(id));
        }else if(accelerationId != null){
            companyList = companyService.findByAccelerationId(accelerationId);
        }else if(userId != null){
            companyList = companyService.findByUserId(userId);
        }

        return ResponseEntity.ok(companyList);
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

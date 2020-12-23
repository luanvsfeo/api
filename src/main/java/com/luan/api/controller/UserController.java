package com.luan.api.controller;

import com.luan.api.model.User;
import com.luan.api.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> find(@Param("id") Integer id,
                                    @Param("accelerationName") String accelerationName,
                                    @Param("companyId") Integer companyId){
        User user =  null;

        if(id != null){
            user = userService.findById(id);
        }else if(accelerationName != null){
            user =  userService.findByAccelerationName(accelerationName);
        }else if(companyId != null){
            user = userService.findByCompanyId(companyId);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<User> save(@RequestBody User user){

       User resposta = userService.save(user);

       if(resposta != null){
           return new ResponseEntity<>(resposta,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(resposta,HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}

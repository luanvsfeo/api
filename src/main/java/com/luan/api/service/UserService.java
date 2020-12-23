package com.luan.api.service;

import com.luan.api.model.User;
import com.luan.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User findByAccelerationName(String  accelerationName){
        return userRepository.findByAccelerationName(accelerationName).orElse(null);
    }

    public User findByCompanyId(int companyId){
        return userRepository.findByCompanyId(companyId).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

}

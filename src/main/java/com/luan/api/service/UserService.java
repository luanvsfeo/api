package com.luan.api.service;

import com.luan.api.model.User;
import com.luan.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findByAccelerationName(String  accelerationName){
        return userRepository.findByAccelerationName(accelerationName);
    }

    public List<User> findByCompanyId(int companyId){
        return userRepository.findByCompanyId(companyId);
    }

    public User save(User user){
        return userRepository.save(user);
    }

}

package com.reservationapp.service;

import com.reservationapp.entity.UserRegistartion;
import com.reservationapp.payload.UserRegistrationDto;
import com.reservationapp.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;


    public UserRegistrationDto createUser(UserRegistartion userRegistartion){
        userRegistrationRepository.save(userRegistartion);
        return null;
    }

    public UserRegistartion getUserById(long id){
        return userRegistrationRepository.findById(id).get();
    }
}

package com.reservationapp.controller;
import com.reservationapp.entity.UserRegistartion;
import com.reservationapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/users")
public class UserRegistrationController {
    @Autowired
    private UserServiceImpl userService;
    @PostMapping
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePicture") MultipartFile  profilePicture
    ) {
        try{
        // Create a new UserRegistration object
        UserRegistartion userRegistartion=new UserRegistartion();
        userRegistartion.setName(name);
        userRegistartion.setEmail(email);
        userRegistartion.setPassword(password);
        userRegistartion.setProfilePicture(profilePicture.getBytes());
        userService.createUser(userRegistartion);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Registration Done...";
    }

    @GetMapping("{id}")
    public ResponseEntity<UserRegistartion> getUserById(@PathVariable long id){
        UserRegistartion user = userService.getUserById(id);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
}

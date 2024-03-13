package com.reservationapp.entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="user_registrations")
public class UserRegistartion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;
        private String password;

        @Lob
        @Column(name = "profile_picture", length = 1024)
        private byte[] profilePicture;


        // Getters and setters
        // Constructors
    }




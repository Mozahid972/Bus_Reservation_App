package com.reservationapp.repository;

import com.reservationapp.entity.UserRegistartion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistartion,Long> {
}

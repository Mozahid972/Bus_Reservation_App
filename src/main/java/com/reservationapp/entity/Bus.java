package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    private double price;
    private int totalSeats;
    private int availableSeats;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;


// Getters and Setters
    // You can generate them using your IDE or Lombok's @Data annotation
}

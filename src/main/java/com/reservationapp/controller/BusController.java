package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.payload.BusDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.service.BusService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BusService busService;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody BusDto busDto) throws ParseException {
        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

}
